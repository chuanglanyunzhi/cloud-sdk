package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import java.util.List;

/**
 * 表格 OCR 表格行数据。
 */
public class TableOcrTableRows extends CloudSdkModel {

    /**
     * 表格列数据。
     */
    public List<TableOcrTableColumns> tableColumns;

    public TableOcrTableRows setTableColumns(List<TableOcrTableColumns> tableColumns) {
        this.tableColumns = tableColumns;
        return this;
    }
}
