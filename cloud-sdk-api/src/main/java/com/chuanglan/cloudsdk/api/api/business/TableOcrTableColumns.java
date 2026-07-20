package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import java.util.List;

/**
 * 表格 OCR 单元格数据。
 */
public class TableOcrTableColumns extends CloudSdkModel {

    /**
     * 单元格所占的列数。
     */
    private Integer endColumn;

    /**
     * 单元格所占的行数。
     */
    private Integer endRow;

    /**
     * 图片上单元格的高度。
     */
    private Integer height;

    /**
     * 单元格的起始列。
     */
    private Integer startColumn;

    /**
     * 单元格的起始行。
     */
    private Integer startRow;

    /**
     * 文本，每行（row）文字为一个 block。
     */
    private List<String> texts;

    /**
     * 宽。
     */
    private Integer width;

    public TableOcrTableColumns setEndColumn(Integer endColumn) {
        this.endColumn = endColumn;
        return this;
    }

    public TableOcrTableColumns setEndRow(Integer endRow) {
        this.endRow = endRow;
        return this;
    }

    public TableOcrTableColumns setHeight(Integer height) {
        this.height = height;
        return this;
    }

    public TableOcrTableColumns setStartColumn(Integer startColumn) {
        this.startColumn = startColumn;
        return this;
    }

    public TableOcrTableColumns setStartRow(Integer startRow) {
        this.startRow = startRow;
        return this;
    }

    public TableOcrTableColumns setTexts(List<String> texts) {
        this.texts = texts;
        return this;
    }

    public TableOcrTableColumns setWidth(Integer width) {
        this.width = width;
        return this;
    }

    public Integer getEndColumn() {
        return this.endColumn;
    }

    public Integer getEndRow() {
        return this.endRow;
    }

    public Integer getHeight() {
        return this.height;
    }

    public Integer getStartColumn() {
        return this.startColumn;
    }

    public Integer getStartRow() {
        return this.startRow;
    }

    public List<String> getTexts() {
        return this.texts;
    }

    public Integer getWidth() {
        return this.width;
    }
}
