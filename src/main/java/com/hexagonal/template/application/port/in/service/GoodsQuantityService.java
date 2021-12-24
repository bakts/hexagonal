package com.hexagonal.template.application.port.in.service;

import com.hexagonal.template.application.dto.GoodsQuantityDTO;

import java.util.List;

public interface GoodsQuantityService {

    public GoodsQuantityDTO add(GoodsQuantityDTO goodsQuantityDTO);
    public GoodsQuantityDTO delete(GoodsQuantityDTO goodsQuantityDTO);
    public List<GoodsQuantityDTO> getGoodsQuantityList(int pageNum);

}
