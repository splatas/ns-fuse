package ar.com.newsan.esb.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigInteger;
import java.util.Date;

public class Customer {

    private String accountNum;
    private String accountName;
    private String description;
    private String descriptionCode;
    private String salesChannel;
    private String salesChannelCode;
    private String classDesc;
    private String classCode;
    private String fiscalCode;
    private String phoneArea;
    private String phone;
    private String mail;
    private String postalCode;
    private String address;
    private String city;
    private String provinceCode;
    private String province;
    private String status;
    private String organizationName;
    private BigInteger idOrganization;
    private BigInteger idSiteUse;
    private String siteUse;
    private String siteStatus;
    private BigInteger idSite;
    private String contributorClass;
    private BigInteger idSiteAcct;
    private String conTaxAttrValue;
    private String docLetter;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Argentina/Buenos_Aires")
    private Date lastUpdate;

    //Getters & Setters

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescriptionCode() {
        return descriptionCode;
    }

    public void setDescriptionCode(String descriptionCode) {
        this.descriptionCode = descriptionCode;
    }

    public String getSalesChannel() {
        return salesChannel;
    }

    public void setSalesChannel(String salesChannel) {
        this.salesChannel = salesChannel;
    }

    public String getSalesChannelCode() {
        return salesChannelCode;
    }

    public void setSalesChannelCode(String salesChannelCode) {
        this.salesChannelCode = salesChannelCode;
    }

    public String getClassDesc() {
        return classDesc;
    }

    public void setClassDesc(String classDesc) {
        this.classDesc = classDesc;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public String getFiscalCode() {
        return fiscalCode;
    }

    public void setFiscalCode(String fiscalCode) {
        this.fiscalCode = fiscalCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
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

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public BigInteger getIdOrganization() {
        return idOrganization;
    }

    public void setIdOrganization(BigInteger idOrganization) {
        this.idOrganization = idOrganization;
    }

    public BigInteger getIdSiteUse() {
        return idSiteUse;
    }

    public void setIdSiteUse(BigInteger idSiteUse) {
        this.idSiteUse = idSiteUse;
    }

    public String getSiteUse() {
        return siteUse;
    }

    public void setSiteUse(String siteUse) {
        this.siteUse = siteUse;
    }

    public String getSiteStatus() {
        return siteStatus;
    }

    public void setSiteStatus(String siteStatus) {
        this.siteStatus = siteStatus;
    }

    public BigInteger getIdSite() {
        return idSite;
    }

    public void setIdSite(BigInteger idSite) {
        this.idSite = idSite;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getPhoneArea() {
        return phoneArea;
    }

    public void setPhoneArea(String phoneArea) {
        this.phoneArea = phoneArea;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getContributorClass() {
        return contributorClass;
    }

    public void setContributorClass(String contributorClass) {
        this.contributorClass = contributorClass;
    }

    public BigInteger getIdSiteAcct() {
        return idSiteAcct;
    }

    public void setIdSiteAcct(BigInteger idSiteAcct) {
        this.idSiteAcct = idSiteAcct;
    }

    public String getConTaxAttrValue() {
        return conTaxAttrValue;
    }

    public void setConTaxAttrValue(String conTaxAttrValue) {
        this.conTaxAttrValue = conTaxAttrValue;
    }

    public String getDocLetter() {
        return docLetter;
    }

    public void setDocLetter(String docLetter) {
        this.docLetter = docLetter;
    }
}
