package com.hexagonal.template.application.port.out.repository;

import com.hexagonal.template.application.domain.Goods;
import com.hexagonal.template.application.paging.Page;

import java.util.List;

public interface GoodsRepository {

    public Goods save(Goods goods);
    public int countGoodsTotal();
    public Goods findByGoodsID(int goodsID);
    public List<Goods> findGoodsList(Page page);
}
