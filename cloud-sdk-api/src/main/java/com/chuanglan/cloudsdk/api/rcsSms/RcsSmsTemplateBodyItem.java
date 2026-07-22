package com.chuanglan.cloudsdk.api.rcsSms;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 视频短信模板内容项（body 列表元素）。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RcsSmsTemplateBodyItem extends CloudSdkModel {

    /**
     * 媒体类型：text / video / audio / image。
     */
    private String type;

    /**
     * 后缀格式，和 type 配合使用：
     * text: txt； video: mp4/3gp； audio: mp3； image: jpg/gif/png。
     */
    private String exType;

    /**
     * 文本素材直接传内容；文件素材（图片、视频、音频等）可传 base64 或文件 url，
     * 具体由 {@link #contentType} 指定。
     */
    private String content;

    /**
     * content 类型（文本不考虑该值）。文件素材时：1 = base64，2 = 文件素材 url。不传默认 1。
     */
    private Integer contentType;

    /**
     * 内容排序。
     */
    private Integer sort;

    public RcsSmsTemplateBodyItem setType(String type) {
        this.type = type;
        return this;
    }

    public RcsSmsTemplateBodyItem setExType(String exType) {
        this.exType = exType;
        return this;
    }

    public RcsSmsTemplateBodyItem setContent(String content) {
        this.content = content;
        return this;
    }

    public RcsSmsTemplateBodyItem setContentType(Integer contentType) {
        this.contentType = contentType;
        return this;
    }

    public RcsSmsTemplateBodyItem setSort(Integer sort) {
        this.sort = sort;
        return this;
    }

    public String getType() {
        return this.type;
    }

    public String getExType() {
        return this.exType;
    }

    public String getContent() {
        return this.content;
    }

    public Integer getContentType() {
        return this.contentType;
    }

    public Integer getSort() {
        return this.sort;
    }
}
