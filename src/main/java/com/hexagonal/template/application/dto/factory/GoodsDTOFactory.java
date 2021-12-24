package com.hexagonal.template.application.dto.factory;

import com.hexagonal.template.application.domain.Goods;
import com.hexagonal.template.application.dto.GoodsDTO;

import java.util.ArrayList;
import java.util.List;

public class GoodsDTOFactory {

    public static GoodsDTO create(Goods goods){
        return new GoodsDTO(goods.getGoodsID(), goods.getName());
    }

    public static List<GoodsDTO> createList(List<Goods> goodsList) {
        List<GoodsDTO> goodsDTOList = new ArrayList<>();
        for (Goods goods : goodsList){
            goodsDTOList.add(GoodsDTOFactory.create(goods));
        }
        return goodsDTOList;
    }
}
