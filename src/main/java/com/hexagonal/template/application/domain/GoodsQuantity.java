package com.hexagonal.template.application.domain;

public class GoodsQuantity implements Comparable<GoodsQuantity> {

    private final Goods goods;
    private int goodsQuantity;

    public GoodsQuantity(Goods goods, int goodsQuantity) {
        this.goods = goods;
        this.goodsQuantity = goodsQuantity;
    }

    public Goods getGoods() {
        return goods;
    }

    public int getGoodsQuantity() {
        return goodsQuantity;
    }

    @Override
    public String toString() {
        return "GoodsStock{" +
                "goods=" + goods +
                ", goodsQuantity=" + goodsQuantity +
                '}';
    }

    public GoodsQuantity addGoodsQuantity(int goodsQuantity) {
        this.goodsQuantity += goodsQuantity;
        return this;
    }

    public GoodsQuantity deleteGoodsQuantity(int goodsQuantity) {
        this.goodsQuantity -= goodsQuantity;
        return this;
    }

    @Override
    public int compareTo(GoodsQuantity o) {
        if (goods.getGoodsID() < o.getGoods().getGoodsID()) return -1;
        if (goods.getGoodsID() > o.getGoods().getGoodsID()) return 1;
        else return -1;
    }
}
