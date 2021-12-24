package com.hexagonal.template.application.port.in.service.impl;

import com.hexagonal.template.application.constants.ListConstants;
import com.hexagonal.template.application.domain.Goods;
import com.hexagonal.template.application.domain.GoodsQuantity;
import com.hexagonal.template.application.dto.GoodsDTO;
import com.hexagonal.template.application.dto.factory.GoodsDTOFactory;
import com.hexagonal.template.application.paging.Page;
import com.hexagonal.template.application.port.in.service.GoodsService;
import com.hexagonal.template.application.port.out.repository.GoodsQuantityRepository;
import com.hexagonal.template.application.port.out.repository.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    private final GoodsRepository goodsRepository;
    private final GoodsQuantityRepository goodsQuantityRepository;

    @Autowired
    public GoodsServiceImpl(GoodsRepository goodsRepository, GoodsQuantityRepository goodsQuantityRepository) {
        this.goodsRepository = goodsRepository;
        this.goodsQuantityRepository = goodsQuantityRepository;
    }

    @Override
    public GoodsDTO saveGoods(GoodsDTO goodsDTO) {
        Goods foundGoodsID = goodsRepository.findByGoodsID(goodsDTO.getGoodsID());
        if(foundGoodsID == null){
            Goods savedGoods = goodsRepository.save(new Goods(goodsDTO.getGoodsID(), goodsDTO.getName()));
            goodsQuantityRepository.save(new GoodsQuantity(savedGoods, 0));
            return GoodsDTOFactory.create(savedGoods);
        }
        return GoodsDTOFactory.create(foundGoodsID);
    }

    @Override
    public List<GoodsDTO> getGoodsList(int pageNum) {
        int goodsTotalCount = goodsRepository.countGoodsTotal();
        Page page = new Page(pageNum, ListConstants.LIST_SIZE, goodsTotalCount, ListConstants.ASC);
        List<Goods> pagedGoodsList = goodsRepository.findGoodsList(page);
        return GoodsDTOFactory.createList(pagedGoodsList);
    }
}
