package ar.com.newsan.esb.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;

@JsonIgnoreProperties(value = { "reqStatus", "msgData", "msgCount" })
public class ProductStock {

    private BigDecimal organization;
    private String subInventory;
    private BigDecimal inventory;
    private String reqStatus;
    private Integer msgCount;
    private String msgData;
    private Integer onHand;
    private Integer onHandReservable;
    private Integer reserved;
    private Integer suggested;
    private Integer availableToTransact;
    private Integer availableToReserve;

    //Getters & Setters

    public BigDecimal getOrganization() {
        return organization;
    }

    public void setOrganization(BigDecimal organization) {
        this.organization = organization;
    }

    public String getSubInventory() {
        return subInventory;
    }

    public void setSubInventory(String subInventory) {
        this.subInventory = subInventory;
    }

    public BigDecimal getInventory() {
        return inventory;
    }

    public void setInventory(BigDecimal inventory) {
        this.inventory = inventory;
    }

    public String getReqStatus() {
        return reqStatus;
    }

    public void setReqStatus(String reqStatus) {
        this.reqStatus = reqStatus;
    }

    public Integer getMsgCount() {
        return msgCount;
    }

    public void setMsgCount(Integer msgCount) {
        this.msgCount = msgCount;
    }

    public String getMsgData() {
        return msgData;
    }

    public void setMsgData(String msgData) {
        this.msgData = msgData;
    }

    public Integer getOnHand() {
        return onHand;
    }

    public void setOnHand(Integer onHand) {
        this.onHand = onHand;
    }

    public Integer getOnHandReservable() {
        return onHandReservable;
    }

    public void setOnHandReservable(Integer onHandReservable) {
        this.onHandReservable = onHandReservable;
    }

    public Integer getReserved() {
        return reserved;
    }

    public void setReserved(Integer reserved) {
        this.reserved = reserved;
    }

    public Integer getSuggested() {
        return suggested;
    }

    public void setSuggested(Integer suggested) {
        this.suggested = suggested;
    }

    public Integer getAvailableToTransact() {
        return availableToTransact;
    }

    public void setAvailableToTransact(Integer availableToTransact) {
        this.availableToTransact = availableToTransact;
    }

    public Integer getAvailableToReserve() {
        return availableToReserve;
    }

    public void setAvailableToReserve(Integer availableToReserve) {
        this.availableToReserve = availableToReserve;
    }


    @Override
    public String toString() {
        return "ProductStock{" +
                "organization='" + organization + '\'' +
                ", subInventory='" + subInventory + '\'' +
                ", inventory='" + inventory + '\'' +
                ", onHand=" + onHand +
                ", onHandReservable=" + onHandReservable +
                ", reserved=" + reserved +
                ", suggested=" + suggested +
                ", availableToTransact=" + availableToTransact +
                ", availableToReserve=" + availableToReserve +
                '}';
    }
}
