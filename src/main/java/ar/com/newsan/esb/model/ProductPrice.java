package ar.com.newsan.esb.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

public class ProductPrice {

    private String opUnit;
    private BigDecimal opUnitId;
    private Integer listHeaderId;
    private String listHeaderName;
    private String listHeaderDescription;
    private Integer listLineId;
    private String inventoryItemId;
    private String inventoryItemCode;
    private String uomCode;
    private String uom;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Argentina/Buenos_Aires")
    private Date lineStart;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Argentina/Buenos_Aires")
    private Date lineEnd;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Argentina/Buenos_Aires")
    private Date headerStart;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Argentina/Buenos_Aires")
    private Date headerEnd;
    private String listTypeCode;
    private String activeFlag;
    private String lineTypeCode;
    private String arithmeticOp;
    private String currency;
    private BigDecimal unitPrice;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastUpdate;

    //Getters & Setters

    public String getOpUnit() {
        return opUnit;
    }

    public void setOpUnit(String opUnit) {
        this.opUnit = opUnit;
    }

    public BigDecimal getOpUnitId() {
        return opUnitId;
    }

    public void setOpUnitId(BigDecimal opUnitId) {
        this.opUnitId = opUnitId;
    }

    public Integer getListHeaderId() {
        return listHeaderId;
    }

    public void setListHeaderId(Integer listHeaderId) {
        this.listHeaderId = listHeaderId;
    }

    public String getListHeaderName() {
        return listHeaderName;
    }

    public void setListHeaderName(String listHeaderName) {
        this.listHeaderName = listHeaderName;
    }

    public String getListHeaderDescription() {
        return listHeaderDescription;
    }

    public void setListHeaderDescription(String listHeaderDescription) {
        this.listHeaderDescription = listHeaderDescription;
    }

    public Integer getListLineId() {
        return listLineId;
    }

    public void setListLineId(Integer listLineId) {
        this.listLineId = listLineId;
    }

    public String getInventoryItemId() {
        return inventoryItemId;
    }

    public void setInventoryItemId(String inventoryItemId) {
        this.inventoryItemId = inventoryItemId;
    }

    public String getInventoryItemCode() {
        return inventoryItemCode;
    }

    public void setInventoryItemCode(String inventoryItemCode) {
        this.inventoryItemCode = inventoryItemCode;
    }

    public String getUomCode() {
        return uomCode;
    }

    public void setUomCode(String uomCode) {
        this.uomCode = uomCode;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

    public Date getLineStart() {
        return lineStart;
    }

    public void setLineStart(Date lineStart) {
        this.lineStart = lineStart;
    }

    public Date getLineEnd() {
        return lineEnd;
    }

    public void setLineEnd(Date lineEnd) {
        this.lineEnd = lineEnd;
    }

    public Date getHeaderStart() {
        return headerStart;
    }

    public void setHeaderStart(Date headerStart) {
        this.headerStart = headerStart;
    }

    public Date getHeaderEnd() {
        return headerEnd;
    }

    public void setHeaderEnd(Date headerEnd) {
        this.headerEnd = headerEnd;
    }

    public String getListTypeCode() {
        return listTypeCode;
    }

    public void setListTypeCode(String listTypeCode) {
        this.listTypeCode = listTypeCode;
    }

    public String getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(String activeFlag) {
        this.activeFlag = activeFlag;
    }

    public String getLineTypeCode() {
        return lineTypeCode;
    }

    public void setLineTypeCode(String lineTypeCode) {
        this.lineTypeCode = lineTypeCode;
    }

    public String getArithmeticOp() {
        return arithmeticOp;
    }

    public void setArithmeticOp(String arithmeticOp) {
        this.arithmeticOp = arithmeticOp;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    //Utils

    @Override
    public String toString() {
        return "ProductPrice{" +
                "opUnit='" + opUnit + '\'' +
                ", listHeaderName='" + listHeaderName + '\'' +
                ", inventoryItemCode='" + inventoryItemCode + '\'' +
                ", currency='" + currency + '\'' +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
