package com.hexagonal.template.application.dto;

public class GoodsQuantityDTO {

    private final GoodsDTO goodsDTO;
    private final int goodsQuantity;

    public GoodsQuantityDTO(GoodsDTO goodsDTO, int goodsQuantity) {
        this.goodsDTO = goodsDTO;
        this.goodsQuantity = goodsQuantity;
    }

    public GoodsDTO getGoodsDTO() {
        return goodsDTO;
    }

    public int getGoodsQuantity() {
        return goodsQuantity;
    }

    @Override
    public String toString() {
        return "GoodsQuantityDTO{" +
                "goodsDTO=" + goodsDTO +
                ", goodsQuantity=" + goodsQuantity +
                '}';
    }

}
