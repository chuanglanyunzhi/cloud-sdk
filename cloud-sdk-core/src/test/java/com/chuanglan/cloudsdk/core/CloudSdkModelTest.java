package com.chuanglan.cloudsdk.core;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CloudSdkModelTest {

    static class TestModel extends CloudSdkModel {
        @NameInMap("UserName")
        public String userName;

        @NameInMap("Age")
        public Integer age;

        public TestModel setUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public TestModel setAge(Integer age) {
            this.age = age;
            return this;
        }
    }

    @Test
    void testToMapUsesNameInMap() {
        TestModel model = new TestModel().setUserName("Alice").setAge(30);
        Map<String, Object> map = model.toMap();
        assertEquals("Alice", map.get("UserName"));
        assertEquals(30, map.get("Age"));
        assertFalse(map.containsKey("userName"));
    }

    @Test
    void testBuildUsesNameInMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("UserName", "Bob");
        map.put("Age", 25);
        TestModel model = CloudSdkModel.build(map, TestModel.class);
        assertEquals("Bob", model.userName);
        assertEquals(25, model.age);
    }

    @Test
    void testNullFieldIgnored() {
        TestModel model = new TestModel().setUserName("Alice");
        Map<String, Object> map = model.toMap();
        assertEquals("Alice", map.get("UserName"));
        assertFalse(map.containsKey("Age"));
    }
}
