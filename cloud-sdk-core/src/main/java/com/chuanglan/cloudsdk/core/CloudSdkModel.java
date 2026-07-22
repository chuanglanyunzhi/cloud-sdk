package com.chuanglan.cloudsdk.core;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * SDK 模型基类，提供对象与 Map 的双向转换。
 */
public abstract class CloudSdkModel {

    private static final ObjectMapper MAPPER = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

    /**
     * 将当前对象转换为 Map，key 使用 @NameInMap 指定的线上参数名。
     *
     * <p>遍历完整继承链上的所有已声明字段（包含 private），而非仅 public 字段，
     * 因为 SDK 内的模型字段普遍为 private。
     */
    public Map<String, Object> toMap() throws CloudSdkException {
        Map<String, Object> map = new HashMap<>();
        try {
            for (Field field : collectFields(this.getClass())) {
                field.setAccessible(true);
                Object value = field.get(this);
                if (value == null) {
                    continue;
                }
                NameInMap annotation = field.getAnnotation(NameInMap.class);
                String key = annotation != null ? annotation.value() : field.getName();
                map.put(key, value);
            }
        } catch (IllegalAccessException e) {
            throw new CloudSdkException("ModelToMapError", "模型转 Map 失败: " + e.getMessage(), null, 0, e);
        }
        return map;
    }

    /**
     * 收集从当前类到 {@link CloudSdkModel} 的完整继承链上的所有已声明字段，跳过静态字段。
     */
    private static java.util.List<Field> collectFields(Class<?> clazz) {
        java.util.List<Field> fields = new java.util.ArrayList<>();
        for (Class<?> c = clazz; c != null && CloudSdkModel.class.isAssignableFrom(c); c = c.getSuperclass()) {
            for (Field field : c.getDeclaredFields()) {
                if (!java.lang.reflect.Modifier.isStatic(field.getModifiers())) {
                    fields.add(field);
                }
            }
        }
        return fields;
    }

    /**
     * 从 Map 构建模型对象，key 使用 @NameInMap 指定的线上参数名（未指定时回退为 Java 字段名）。
     *
     * <p>直接通过反射按字段赋值，不经过 {@code MAPPER.convertValue(Map, Class)}：
     * 后者会按字段上的 {@code @JsonProperty} 重新解析 key，若字段名（如 creditCode）与
     * {@code @JsonProperty}（如 credit_code）不一致，会导致该字段在反序列化时被静默丢弃。
     */
    public static <T extends CloudSdkModel> T build(Map<String, ?> map, Class<T> clazz) throws CloudSdkException {
        if (map == null) {
            return null;
        }
        try {
            T instance = clazz.getDeclaredConstructor().newInstance();
            Map<String, Field> fieldByKey = new HashMap<>();
            for (Field field : collectFields(clazz)) {
                NameInMap annotation = field.getAnnotation(NameInMap.class);
                String key = annotation != null ? annotation.value() : field.getName();
                fieldByKey.put(key, field);
            }
            for (Map.Entry<String, ?> entry : map.entrySet()) {
                Field field = fieldByKey.get(entry.getKey());
                if (field == null || entry.getValue() == null) {
                    continue;
                }
                field.setAccessible(true);
                Object value = MAPPER.convertValue(entry.getValue(), MAPPER.getTypeFactory().constructType(field.getGenericType()));
                field.set(instance, value);
            }
            return instance;
        } catch (Exception e) {
            throw new CloudSdkException("MapToModelError", "Map 转模型失败: " + e.getMessage(), null, 0, e);
        }
    }

    /**
     * 将 JSON 字符串转换为 Map。
     */
    public static Map<String, Object> parseJson(String json) throws CloudSdkException {
        try {
            return MAPPER.readValue(json, new TypeReference<Map<String, Object>>() {});
        } catch (Exception e) {
            throw new CloudSdkException("ParseJsonError", "JSON 解析失败: " + e.getMessage(), null, 0, e);
        }
    }

    /**
     * 将对象序列化为 JSON 字符串。
     */
    public static String toJson(Object value) throws CloudSdkException {
        try {
            return MAPPER.writeValueAsString(value);
        } catch (Exception e) {
            throw new CloudSdkException("SerializeJsonError", "JSON 序列化失败: " + e.getMessage(), null, 0, e);
        }
    }

    public static ObjectMapper getMapper() {
        return MAPPER;
    }
}
