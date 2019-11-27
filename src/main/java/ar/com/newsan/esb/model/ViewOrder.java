package ar.com.newsan.esb.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *  Represents an order returned from EBS view XX_OM_ORDER_HEADERS_V
 */
public class ViewOrder {

    private BigInteger id;
    private String type;
    private String description;
    private BigInteger internalId;
    private String shipFromOrg;
    private BigInteger shipFromOrgId;
    private String operatingUnit;
    private BigInteger operatingUnitId;
    private String status;
    private BigInteger sellerId;
    private String account;
    private String accountName;
    private String currency;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Argentina/Buenos_Aires")
    private Date lastUpdate;

    //To put lines in same order
    private List<ViewOrderLine> lines;

    // Constructor
    public ViewOrder() {
        this.lines = new ArrayList<>();
    }

    //Setters & Getters

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigInteger getInternalId() {
        return internalId;
    }

    public void setInternalId(BigInteger internalId) {
        this.internalId = internalId;
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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getOperatingUnit() {
        return operatingUnit;
    }

    public void setOperatingUnit(String operatingUnit) {
        this.operatingUnit = operatingUnit;
    }

    public BigInteger getOperatingUnitId() {
        return operatingUnitId;
    }

    public void setOperatingUnitId(BigInteger operatingUnitId) {
        this.operatingUnitId = operatingUnitId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigInteger getSellerId() {
        return sellerId;
    }

    public void setSellerId(BigInteger sellerId) {
        this.sellerId = sellerId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public List<ViewOrderLine> getLines() {
        return lines;
    }

    public void setLines(List<ViewOrderLine> lines) {
        this.lines = lines;
    }


    @Override
    public String toString() {
        return "ViewOrder{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", internalId=" + internalId +
                ", status='" + status + '\'' +
                ", currency='" + currency + '\'' +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
