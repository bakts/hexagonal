package com.hexagonal.template.application.port.in.service;

import com.hexagonal.template.application.dto.GoodsDTO;

import java.util.List;

public interface GoodsService {

    public List<GoodsDTO> getGoodsList(int pageNum);
    public GoodsDTO saveGoods(GoodsDTO goodsDTO);

}
