package ar.com.newsan.esb.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

/**
 *  Represents an order line returned from EBS view XX_OM_ORDER_LINES_V
 */
public class ViewOrderLine {

    private BigInteger line;
    private String shipFromOrg;
    private BigInteger shipFromOrgId;
    private String lineStatus;
    private String itemCode;
    private String itemDesc;
    private BigInteger orderedQuantity;
    private String uom; //Quantity unity of measure
    private BigDecimal pricingQuantity;
    private BigDecimal unitPrice;
    private BigDecimal totalPrice;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Argentina/Buenos_Aires")
    private Date scheduleShipDate; //Estimated time of shipping
    private String type;
    private String typeDescription;
    private String categoryCode;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Argentina/Buenos_Aires")
    private Date lineLastUpdate;

    //Getters & Setters

    public BigInteger getLine() {
        return line;
    }

    public void setLine(BigInteger line) {
        this.line = line;
    }

    public String getShipFromOrg() {
        return shipFromOrg;
    }

    public void setShipFromOrg(String shipFromOrg) {
        this.shipFromOrg = shipFromOrg;
    }

    public BigInteger getShipFromOrgId() {
        return shipFromOrgId;
    }

    public void setShipFromOrgId(BigInteger shipFromOrgId) {
        this.shipFromOrgId = shipFromOrgId;
    }

    public String getLineStatus() {
        return lineStatus;
    }

    public void setLineStatus(String lineStatus) {
        this.lineStatus = lineStatus;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public BigInteger getOrderedQuantity() {
        return orderedQuantity;
    }

    public void setOrderedQuantity(BigInteger orderedQuantity) {
        this.orderedQuantity = orderedQuantity;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getPricingQuantity() {
        return pricingQuantity;
    }

    public void setPricingQuantity(BigDecimal pricingQuantity) {
        this.pricingQuantity = pricingQuantity;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getScheduleShipDate() {
        return scheduleShipDate;
    }

    public void setScheduleShipDate(Date scheduleShipDate) {
        this.scheduleShipDate = scheduleShipDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeDescription() {
        return typeDescription;
    }

    public void setTypeDescription(String typeDescription) {
        this.typeDescription = typeDescription;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public Date getLineLastUpdate() {
        return lineLastUpdate;
    }

    public void setLineLastUpdate(Date lineLastUpdate) {
        this.lineLastUpdate = lineLastUpdate;
    }
}
