package com.hexagonal.template.application.domain;

public class Goods implements Comparable<Goods> {

    private final int goodsID;
    private final String name;

    public Goods(int goodsID, String name) {
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
        return "Goods{" +
                "goodsID=" + goodsID +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Goods o) {
        if (goodsID < o.getGoodsID()) return -1;
        if (goodsID > o.getGoodsID()) return 1;
        else return -1;
    }
}
