package com.company.entity;

/**
 * Created by Administrator on 2017/4/20.
 */
public class Address {

    private Integer addrId;
    private Integer userId;
    private String name;
    private String phone;
    private String province;
    private Integer provinceId;
    private String city;
    private Integer cityId;
    private String region;
    private Integer regionId;
    private String street;
    private Integer streetId;
    private String addrDetail;
    private Boolean isDefault;

    @Override
    public String toString() {
        return "Address{ " +
                "addr_id=" + addrId +
                ", user_id = " + userId +
                ", name = '" + name + '\'' +
                ", phone = '" + phone + '\'' +
                ", province = '" + province + '\'' +
                ", city = '" + city + '\'' +
                ", region = '" + region + '\'' +
                ", street = '" + street +'\'' +
                ", addr_detail = '" + addrDetail + '\'' +
                ", is_default = " + isDefault +
                "}";
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public Integer getStreetId() {
        return streetId;
    }

    public void setStreetId(Integer streetId) {
        this.streetId = streetId;
    }

    public Integer getAddrId() {
        return addrId;
    }

    public void setAddrId(Integer addrId) {
        this.addrId = addrId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region == null ? null:region.trim();
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street == null ? null: street.trim();
    }

    public String getAddrDetail() {
        return addrDetail;
    }

    public void setAddrDetail(String addrDetail) {
        this.addrDetail = addrDetail == null ? null: addrDetail.trim();
    }

    public Boolean getDefault() {
        return isDefault;
    }

    public void setDefault(Boolean aDefault) {
        isDefault = aDefault;
    }
}
