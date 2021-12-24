package com.hexagonal.template.application.port.out.repository;

import com.hexagonal.template.application.domain.GoodsQuantity;
import com.hexagonal.template.application.paging.Page;

import java.util.List;

public interface GoodsQuantityRepository {

    public List<GoodsQuantity> findGoodsQuantityList(Page page);
    public GoodsQuantity add(GoodsQuantity goodsQuantity);
    public GoodsQuantity delete(GoodsQuantity goodsQuantity);
    public GoodsQuantity save(GoodsQuantity goodsQuantity);
    public GoodsQuantity findByGoodsID(int goodsID);

}
