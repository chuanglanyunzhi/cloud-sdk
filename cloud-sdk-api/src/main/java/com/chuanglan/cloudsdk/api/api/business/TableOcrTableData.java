package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import java.util.List;

/**
 * 表格 OCR 表格数据。
 */
public class TableOcrTableData extends CloudSdkModel {

    /**
     * 表头信息。
     */
    private List<Object> head;

    /**
     * 表格行数据。
     */
    private List<TableOcrTableRows> tableRows;

    /**
     * 表尾信息。
     */
    private List<Object> tail;

    public TableOcrTableData setHead(List<Object> head) {
        this.head = head;
        return this;
    }

    public TableOcrTableData setTableRows(List<TableOcrTableRows> tableRows) {
        this.tableRows = tableRows;
        return this;
    }

    public TableOcrTableData setTail(List<Object> tail) {
        this.tail = tail;
        return this;
    }

    public List<Object> getHead() {
        return this.head;
    }

    public List<TableOcrTableRows> getTableRows() {
        return this.tableRows;
    }

    public List<Object> getTail() {
        return this.tail;
    }
}
