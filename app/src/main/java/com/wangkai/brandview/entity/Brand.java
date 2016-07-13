package com.wangkai.brandview.entity;

/**
 * Created by wangkai on 16/7/13.
 */
public class Brand {

    private Integer imgUrl;
    private String brandName;

    public Brand(Integer imgUrl, String brandName) {
        this.imgUrl = imgUrl;
        this.brandName = brandName;
    }

    public Integer getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(Integer imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}
