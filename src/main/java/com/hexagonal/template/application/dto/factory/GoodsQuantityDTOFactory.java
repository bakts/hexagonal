package com.hexagonal.template.application.dto.factory;

import com.hexagonal.template.application.domain.GoodsQuantity;
import com.hexagonal.template.application.dto.GoodsQuantityDTO;

import java.util.ArrayList;
import java.util.List;

public class GoodsQuantityDTOFactory {

    public static GoodsQuantityDTO create(GoodsQuantity goodsQuantity){
        return new GoodsQuantityDTO(GoodsDTOFactory.create(goodsQuantity.getGoods()), goodsQuantity.getGoodsQuantity());
    }

    public static List<GoodsQuantityDTO> createList(List<GoodsQuantity> goodsQuantityList){
        List<GoodsQuantityDTO> goodsQuantityDTOList = new ArrayList<>();
        for (GoodsQuantity goodsQuantity : goodsQuantityList){
            goodsQuantityDTOList.add(GoodsQuantityDTOFactory.create(goodsQuantity));
        }
        return goodsQuantityDTOList;
    }

}
