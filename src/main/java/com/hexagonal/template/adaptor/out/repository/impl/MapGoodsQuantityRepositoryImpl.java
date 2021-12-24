package com.hexagonal.template.adaptor.out.repository.impl;

import com.hexagonal.template.application.domain.GoodsQuantity;
import com.hexagonal.template.application.paging.Page;
import com.hexagonal.template.application.port.out.repository.GoodsQuantityRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class MapGoodsQuantityRepositoryImpl implements GoodsQuantityRepository {

    //키가 goodsID
    private Map<Integer, GoodsQuantity> goodsQuantityMap;

    public MapGoodsQuantityRepositoryImpl() {
        if(goodsQuantityMap == null){
            goodsQuantityMap = new HashMap<>();
        }
    }

    @Override
    public List<GoodsQuantity> findGoodsQuantityList(Page page) {
        List<GoodsQuantity> goodsQuantityList = goodsQuantityMap.values().stream().collect(Collectors.toList());
        if(!page.isAsc()){
            goodsQuantityList.sort(Comparator.reverseOrder());
        }
        return goodsQuantityList.subList(page.getListStartIdx(), page.getListEndIdx());
    }

    @Override
    public GoodsQuantity add(GoodsQuantity goodsQuantity) {
        GoodsQuantity foundGoodsQuantity = goodsQuantityMap.get(goodsQuantity.getGoods().getGoodsID());
        GoodsQuantity addedGoodsQuantity = foundGoodsQuantity.addGoodsQuantity(goodsQuantity.getGoodsQuantity());
        goodsQuantityMap.put(addedGoodsQuantity.getGoods().getGoodsID(), addedGoodsQuantity);
        return addedGoodsQuantity;
    }

    @Override
    public GoodsQuantity delete(GoodsQuantity goodsQuantity) {
        GoodsQuantity foundGoodsQuantity = goodsQuantityMap.get(goodsQuantity.getGoods().getGoodsID());
        GoodsQuantity deletedGoodsQuantity = foundGoodsQuantity.deleteGoodsQuantity(goodsQuantity.getGoodsQuantity());
        goodsQuantityMap.put(deletedGoodsQuantity.getGoods().getGoodsID(), deletedGoodsQuantity);
        return deletedGoodsQuantity;
    }

    @Override
    public GoodsQuantity save(GoodsQuantity goodsQuantity) {
        GoodsQuantity foundGoodsQuantity = goodsQuantityMap.get(goodsQuantity.getGoods().getGoodsID());
        if(foundGoodsQuantity == null){
            goodsQuantityMap.put(goodsQuantity.getGoods().getGoodsID(), goodsQuantity);
        }
        return goodsQuantity;
    }

    @Override
    public GoodsQuantity findByGoodsID(int goodsID) {
        return goodsQuantityMap.get(goodsID);
    }
}
