package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import java.util.List;

/**
 * 发票 OCR 识别数据。
 */
public class InvoiceOcrData extends CloudSdkModel {

    /**
     * 校验码。
     */
    private String antiFakeCode;

    /**
     * 复核人。
     */
    private String checker;

    /**
     * 开票人。
     */
    private String clerk;

    /**
     * 价税合计。
     */
    private String invoiceAmount;

    /**
     * 发票代码。
     */
    private String invoiceCode;

    /**
     * 开票日期。
     */
    private String invoiceDate;

    /**
     * 发票号码。
     */
    private String invoiceNo;

    /**
     * 服务名称。
     */
    private List<String> itemName;

    /**
     * 收款人。
     */
    private String payee;

    /**
     * 销售方地址。
     */
    private String payeeAddress;

    /**
     * 销售方名称。
     */
    private String payeeName;

    /**
     * 销售方开户行及账号。
     */
    private String payeeBankName;

    /**
     * 销售方纳税人识别号。
     */
    private String payeeRegisterNo;

    /**
     * 购买方地址电话。
     */
    private String payerAddress;

    /**
     * 购买方开户行及账号。
     */
    private String payerBankName;

    /**
     * 购买方名称。
     */
    private String payerName;

    /**
     * 购买方纳税人识别号。
     */
    private String payerRegisterNo;

    /**
     * 价税合计（大写）。
     */
    private String sumAmount;

    /**
     * 合计税额。
     */
    private String taxAmount;

    /**
     * 合计金额。
     */
    private String withoutTaxAmount;

    public InvoiceOcrData setAntiFakeCode(String antiFakeCode) {
        this.antiFakeCode = antiFakeCode;
        return this;
    }

    public InvoiceOcrData setChecker(String checker) {
        this.checker = checker;
        return this;
    }

    public InvoiceOcrData setClerk(String clerk) {
        this.clerk = clerk;
        return this;
    }

    public InvoiceOcrData setInvoiceAmount(String invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
        return this;
    }

    public InvoiceOcrData setInvoiceCode(String invoiceCode) {
        this.invoiceCode = invoiceCode;
        return this;
    }

    public InvoiceOcrData setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
        return this;
    }

    public InvoiceOcrData setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
        return this;
    }

    public InvoiceOcrData setItemName(List<String> itemName) {
        this.itemName = itemName;
        return this;
    }

    public InvoiceOcrData setPayee(String payee) {
        this.payee = payee;
        return this;
    }

    public InvoiceOcrData setPayeeAddress(String payeeAddress) {
        this.payeeAddress = payeeAddress;
        return this;
    }

    public InvoiceOcrData setPayeeName(String payeeName) {
        this.payeeName = payeeName;
        return this;
    }

    public InvoiceOcrData setPayeeBankName(String payeeBankName) {
        this.payeeBankName = payeeBankName;
        return this;
    }

    public InvoiceOcrData setPayeeRegisterNo(String payeeRegisterNo) {
        this.payeeRegisterNo = payeeRegisterNo;
        return this;
    }

    public InvoiceOcrData setPayerAddress(String payerAddress) {
        this.payerAddress = payerAddress;
        return this;
    }

    public InvoiceOcrData setPayerBankName(String payerBankName) {
        this.payerBankName = payerBankName;
        return this;
    }

    public InvoiceOcrData setPayerName(String payerName) {
        this.payerName = payerName;
        return this;
    }

    public InvoiceOcrData setPayerRegisterNo(String payerRegisterNo) {
        this.payerRegisterNo = payerRegisterNo;
        return this;
    }

    public InvoiceOcrData setSumAmount(String sumAmount) {
        this.sumAmount = sumAmount;
        return this;
    }

    public InvoiceOcrData setTaxAmount(String taxAmount) {
        this.taxAmount = taxAmount;
        return this;
    }

    public InvoiceOcrData setWithoutTaxAmount(String withoutTaxAmount) {
        this.withoutTaxAmount = withoutTaxAmount;
        return this;
    }

    public String getAntiFakeCode() {
        return this.antiFakeCode;
    }

    public String getChecker() {
        return this.checker;
    }

    public String getClerk() {
        return this.clerk;
    }

    public String getInvoiceAmount() {
        return this.invoiceAmount;
    }

    public String getInvoiceCode() {
        return this.invoiceCode;
    }

    public String getInvoiceDate() {
        return this.invoiceDate;
    }

    public String getInvoiceNo() {
        return this.invoiceNo;
    }

    public List<String> getItemName() {
        return this.itemName;
    }

    public String getPayee() {
        return this.payee;
    }

    public String getPayeeAddress() {
        return this.payeeAddress;
    }

    public String getPayeeName() {
        return this.payeeName;
    }

    public String getPayeeBankName() {
        return this.payeeBankName;
    }

    public String getPayeeRegisterNo() {
        return this.payeeRegisterNo;
    }

    public String getPayerAddress() {
        return this.payerAddress;
    }

    public String getPayerBankName() {
        return this.payerBankName;
    }

    public String getPayerName() {
        return this.payerName;
    }

    public String getPayerRegisterNo() {
        return this.payerRegisterNo;
    }

    public String getSumAmount() {
        return this.sumAmount;
    }

    public String getTaxAmount() {
        return this.taxAmount;
    }

    public String getWithoutTaxAmount() {
        return this.withoutTaxAmount;
    }
}
