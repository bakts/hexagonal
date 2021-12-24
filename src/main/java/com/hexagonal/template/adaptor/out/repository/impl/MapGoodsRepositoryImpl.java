package com.hexagonal.template.adaptor.out.repository.impl;

import com.hexagonal.template.application.domain.Goods;
import com.hexagonal.template.application.paging.Page;
import com.hexagonal.template.application.port.out.repository.GoodsRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class MapGoodsRepositoryImpl implements GoodsRepository {

    //키가 goodsID
    private Map<Integer, Goods> goodsMap;

    public MapGoodsRepositoryImpl() {
        if(goodsMap == null){
            goodsMap = new HashMap<>();
        }
    }

    @Override
    public Goods save(Goods goods) {
        goodsMap.put(goods.getGoodsID(), goods);
        return goods;
    }

    @Override
    public int countGoodsTotal() {
        return goodsMap.size();
    }

    @Override
    public Goods findByGoodsID(int goodsID) {
        return goodsMap.get(goodsID);
    }

    @Override
    public List<Goods> findGoodsList(Page page) {
        List<Goods> goodsList = goodsMap.values().stream().collect(Collectors.toList());
        if(!page.isAsc()){
            goodsList.sort(Comparator.reverseOrder());
        }
        return goodsList.subList(page.getListStartIdx(), page.getListEndIdx());
    }
}
