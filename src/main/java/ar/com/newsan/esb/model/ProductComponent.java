package ar.com.newsan.esb.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class ProductComponent {

    private Logger LOG = LoggerFactory.getLogger(ProductComponent.class);

    private String sku;
    private BigInteger productId;
    private BigInteger orgId;
    private String orgCode;
    private String alternate;
    private String code;
    private BigInteger id;
    private BigDecimal quantity;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Argentina/Buenos_Aires")
    private Date effectivityDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Argentina/Buenos_Aires")
    private Date disableDate;
    private String existSubstitute;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Argentina/Buenos_Aires")
    private Date lastUpdate;
    private BigInteger sequenceId;
    private BigInteger billSequenceId;

    //Getters & Setters

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public BigInteger getProductId() {
        return productId;
    }

    public void setProductId(BigInteger productId) {
        this.productId = productId;
    }

    public BigInteger getOrgId() {
        return orgId;
    }

    public void setOrgId(BigInteger orgId) {
        this.orgId = orgId;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getAlternate() {
        return alternate;
    }

    public void setAlternate(String alternate) {
        this.alternate = alternate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public Date getEffectivityDate() {
        return effectivityDate;
    }

    public void setEffectivityDate(Date effectivityDate) {
        this.effectivityDate = effectivityDate;
    }

    public Date getDisableDate() {
        return disableDate;
    }

    public void setDisableDate(Date disableDate) {
        this.disableDate = disableDate;
    }

    public String getExistSubstitute() {
        return existSubstitute;
    }

    public void setExistSubstitute(String existSubstitute) {
        this.existSubstitute = existSubstitute;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public BigInteger getSequenceId() {
        return sequenceId;
    }

    public void setSequenceId(BigInteger sequenceId) {
        this.sequenceId = sequenceId;
    }

    public BigInteger getBillSequenceId() {
        return billSequenceId;
    }

    public void setBillSequenceId(BigInteger billSequenceId) {
        this.billSequenceId = billSequenceId;
    }


    // Utils

    @Override
    public String toString() {
        return "ProductComponent{" +
                "sku='" + sku + '\'' +
                ", productId=" + productId +
                ", orgCode='" + orgCode + '\'' +
                ", quantity=" + quantity +
                ", lastUpdateDate=" + lastUpdate +
                '}';
    }
}
