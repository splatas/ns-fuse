package ar.com.newsan.esb.model;

import com.fasterxml.jackson.annotation.*;

import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class POReception {

    private BigDecimal groupId;
    private BigDecimal receiptHeader;
    private String receiptNumber;
    private String status;

    //Constructor
    public POReception(BigDecimal groupId) {
        this.groupId = groupId;
    }

    //Setters & Getters

    public BigDecimal getGroupId() {
        return groupId;
    }

    public void setGroupId(BigDecimal groupId) {
        this.groupId = groupId;
    }

    public BigDecimal getReceiptHeader() {
        return receiptHeader;
    }

    public void setReceiptHeader(BigDecimal receiptHeader) {
        this.receiptHeader = receiptHeader;
    }

    public String getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "POReception{" +
                "groupId=" + groupId +
                ", status='" + status + '\'' +
                '}';
    }
}
