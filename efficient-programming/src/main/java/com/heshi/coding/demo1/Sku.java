package com.heshi.coding.demo1;

public class Sku {
    private Integer skuId;
    private String skuName;
    private Double skuPrice;
    private Integer totalNum;
    private Double totalPrice;
    private Enum skyCategory;

    public Sku(Integer skuId, String skuName, Double skuPrice, Integer totalNum, Double totalPrice, Enum skyCategory) {
        this.skuId = skuId;
        this.skuName = skuName;
        this.skuPrice = skuPrice;
        this.totalNum = totalNum;
        this.totalPrice = totalPrice;
        this.skyCategory = skyCategory;
    }

    public Integer getSkuId() {
        return skuId;
    }

    public String getSkuName() {
        return skuName;
    }

    public Double getSkuPrice() {
        return skuPrice;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public Enum getSkyCategory() {
        return skyCategory;
    }

    @Override
    public String toString() {
        return "Sku{" +
                "skuId=" + skuId +
                ", skuName='" + skuName + '\'' +
                ", skuPrice=" + skuPrice +
                ", totalNum=" + totalNum +
                ", totalPrice=" + totalPrice +
                ", skyCategory=" + skyCategory +
                '}';
    }
}
