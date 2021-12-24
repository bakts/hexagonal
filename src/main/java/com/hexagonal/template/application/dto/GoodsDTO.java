package com.hexagonal.template.application.dto;

public class GoodsDTO {

    private final int goodsID;
    private final String name;

    public GoodsDTO(int goodsID, String name) {
        this.goodsID = goodsID;
        this.name = name;
    }

    public int getGoodsID() {
        return goodsID;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "GoodsDTO{" +
                "goodsID=" + goodsID +
                ", name='" + name + '\'' +
                '}';
    }

}
