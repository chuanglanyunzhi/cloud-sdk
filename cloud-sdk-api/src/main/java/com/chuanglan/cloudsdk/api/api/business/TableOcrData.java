package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import java.util.List;

/**
 * 表格 OCR 返回数据。
 */
public class TableOcrData extends CloudSdkModel {

    /**
     * 文件内容。
     */
    private String fileContent;

    /**
     * 表格数据。
     */
    private List<TableOcrTableData> tables;

    public TableOcrData setFileContent(String fileContent) {
        this.fileContent = fileContent;
        return this;
    }

    public TableOcrData setTables(List<TableOcrTableData> tables) {
        this.tables = tables;
        return this;
    }

    public String getFileContent() {
        return this.fileContent;
    }

    public List<TableOcrTableData> getTables() {
        return this.tables;
    }
}
