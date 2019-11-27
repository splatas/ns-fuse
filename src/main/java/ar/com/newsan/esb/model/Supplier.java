package ar.com.newsan.esb.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

public class Supplier {

    private String vendorCode;
    private String vendorName;
    private Integer vendorId;
    private String vendorCategoryCode;
    private String vendorCategory;
    private String cuit;
    private String postalCode;
    private String address;
    private String city;
    private String provinceCode;
    private String province;
    private String operatingUnit;
    private Integer operatingUnitId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Argentina/Buenos_Aires")
    private Date addressInactive;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Argentina/Buenos_Aires")
    private Date vendorEndActive;
    private String phoneAreaCode;
    private String phoneNumber;
    private String mail;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Argentina/Buenos_Aires")
    private Date lastUpdate;
    private BigDecimal partySite;
    private BigDecimal locationId;
    private Integer vendorSite;
    private String orgPhonetic;
    private String purchaseSite;
    private String paySite;

    //Getters & Setters


    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public Integer getVendorId() {
        return vendorId;
    }

    public void setVendorId(Integer vendorId) {
        this.vendorId = vendorId;
    }

    public String getVendorCategoryCode() {
        return vendorCategoryCode;
    }

    public void setVendorCategoryCode(String vendorCategoryCode) {
        this.vendorCategoryCode = vendorCategoryCode;
    }

    public String getVendorCategory() {
        return vendorCategory;
    }

    public void setVendorCategory(String vendorCategory) {
        this.vendorCategory = vendorCategory;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getOperatingUnit() {
        return operatingUnit;
    }

    public void setOperatingUnit(String operatingUnit) {
        this.operatingUnit = operatingUnit;
    }

    public Integer getOperatingUnitId() {
        return operatingUnitId;
    }

    public void setOperatingUnitId(Integer operatingUnitId) {
        this.operatingUnitId = operatingUnitId;
    }

    public Date getAddressInactive() {
        return addressInactive;
    }

    public void setAddressInactive(Date addressInactive) {
        this.addressInactive = addressInactive;
    }

    public Date getVendorEndActive() {
        return vendorEndActive;
    }

    public void setVendorEndActive(Date vendorEndActive) {
        this.vendorEndActive = vendorEndActive;
    }

    public String getPhoneAreaCode() {
        return phoneAreaCode;
    }

    public void setPhoneAreaCode(String phoneAreaCode) {
        this.phoneAreaCode = phoneAreaCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public BigDecimal getPartySite() {
        return partySite;
    }

    public void setPartySite(BigDecimal partySite) {
        this.partySite = partySite;
    }

    public BigDecimal getLocationId() {
        return locationId;
    }

    public void setLocationId(BigDecimal locationId) {
        this.locationId = locationId;
    }

    public Integer getVendorSite() {
        return vendorSite;
    }

    public void setVendorSite(Integer vendorSite) {
        this.vendorSite = vendorSite;
    }

    public String getOrgPhonetic() {
        return orgPhonetic;
    }

    public void setOrgPhonetic(String orgPhonetic) {
        this.orgPhonetic = orgPhonetic;
    }

    public String getPurchaseSite() {
        return purchaseSite;
    }

    public void setPurchaseSite(String purchaseSite) {
        this.purchaseSite = purchaseSite;
    }

    public String getPaySite() {
        return paySite;
    }

    public void setPaySite(String paySite) {
        this.paySite = paySite;
    }
}
