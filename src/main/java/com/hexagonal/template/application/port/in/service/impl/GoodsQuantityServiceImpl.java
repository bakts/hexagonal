package com.hexagonal.template.application.port.in.service.impl;

import com.hexagonal.template.application.constants.ListConstants;
import com.hexagonal.template.application.domain.Goods;
import com.hexagonal.template.application.domain.GoodsQuantity;
import com.hexagonal.template.application.dto.GoodsQuantityDTO;
import com.hexagonal.template.application.dto.factory.GoodsQuantityDTOFactory;
import com.hexagonal.template.application.paging.Page;
import com.hexagonal.template.application.port.in.service.GoodsQuantityService;
import com.hexagonal.template.application.port.out.repository.GoodsQuantityRepository;
import com.hexagonal.template.application.port.out.repository.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsQuantityServiceImpl implements GoodsQuantityService {

    private final GoodsRepository goodsRepository;
    private final GoodsQuantityRepository goodsQuantityRepository;

    @Autowired
    public GoodsQuantityServiceImpl(GoodsRepository goodsRepository, GoodsQuantityRepository goodsQuantityRepository) {
        this.goodsRepository = goodsRepository;
        this.goodsQuantityRepository = goodsQuantityRepository;
    }

    @Override
    public GoodsQuantityDTO add(GoodsQuantityDTO goodsQuantityDTO) {
        Goods foundGoods = goodsRepository.findByGoodsID(goodsQuantityDTO.getGoodsDTO().getGoodsID());
        GoodsQuantity foundGoodsQuantity = new GoodsQuantity(foundGoods, goodsQuantityDTO.getGoodsQuantity());
        GoodsQuantity addedGoodsQuantity  = goodsQuantityRepository.add(foundGoodsQuantity);
        return GoodsQuantityDTOFactory.create(addedGoodsQuantity);
    }

    @Override
    public GoodsQuantityDTO delete(GoodsQuantityDTO goodsQuantityDTO) {
        GoodsQuantity foundGoodsQuantity = goodsQuantityRepository.findByGoodsID(goodsQuantityDTO.getGoodsDTO().getGoodsID());
        if((foundGoodsQuantity.getGoodsQuantity() - goodsQuantityDTO.getGoodsQuantity()) < 0){
            return GoodsQuantityDTOFactory.create(foundGoodsQuantity);
        }
        GoodsQuantity deleteGoodsQuantity = new GoodsQuantity(foundGoodsQuantity.getGoods(), goodsQuantityDTO.getGoodsQuantity());
        GoodsQuantity deletedGoodsQuantity = goodsQuantityRepository.delete(deleteGoodsQuantity);
        return GoodsQuantityDTOFactory.create(deletedGoodsQuantity);
    }

    @Override
    public List<GoodsQuantityDTO> getGoodsQuantityList(int pageNum) {
        int goodsTotalCount = goodsRepository.countGoodsTotal();
        Page page = new Page(pageNum, ListConstants.LIST_SIZE, goodsTotalCount, ListConstants.ASC);
        List<GoodsQuantity> pagedGoodsQuantityList = goodsQuantityRepository.findGoodsQuantityList(page);
        return GoodsQuantityDTOFactory.createList(pagedGoodsQuantityList);
    }
}
