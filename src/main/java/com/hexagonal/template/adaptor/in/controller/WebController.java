package com.hexagonal.template.adaptor.in.controller;

import com.hexagonal.template.application.dto.GoodsDTO;
import com.hexagonal.template.application.dto.GoodsQuantityDTO;
import com.hexagonal.template.application.port.in.service.GoodsQuantityService;
import com.hexagonal.template.application.port.in.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class WebController {

    private final GoodsService goodsService;
    private final GoodsQuantityService goodsQuantityService;

    @Autowired
    public WebController(GoodsService goodsService, GoodsQuantityService goodsQuantityService) {
        this.goodsService = goodsService;
        this.goodsQuantityService = goodsQuantityService;
    }

    @GetMapping({"/", "/index"})
    public String goodsQuantityListView(Model model, HttpServletRequest request, HttpServletResponse response){
        return "goodsQuantityList";
    }

    @GetMapping({"/goods"})
    public String goodsListView(Model model, HttpServletRequest request, HttpServletResponse response){
        return "goodsList";
    }

    @GetMapping({"/goods/quantity/list"})
    public ResponseEntity<List<GoodsQuantityDTO>> getGoodsQuantityList(Model model, HttpServletRequest request, HttpServletResponse response
                                                           , @RequestParam(value = "pn", required = false) int pageNum
    ){
        List<GoodsQuantityDTO> goodsQuantityList = goodsQuantityService.getGoodsQuantityList(pageNum);
        return new ResponseEntity<>(goodsQuantityList, HttpStatus.OK);
    }

    @GetMapping({"/goods/list"})
    public ResponseEntity<List<GoodsDTO>> getGoodsList(Model model, HttpServletRequest request, HttpServletResponse response
            , @RequestParam(value = "pn", required = false) int pageNum
    ){
        List<GoodsDTO> goodsList = goodsService.getGoodsList(pageNum);
        return new ResponseEntity<>(goodsList, HttpStatus.OK);
    }

    @PostMapping({"/goods/save"})
    public ResponseEntity<GoodsDTO> saveGoods(Model model, HttpServletRequest request, HttpServletResponse response
            , @RequestParam(value = "goodsid", required = false) int goodsID
            , @RequestParam(value = "goodsnm", required = false) String goodsName
    ){
        GoodsDTO goodsDTO = new GoodsDTO(goodsID, goodsName);
        GoodsDTO savedGoodsDTO = goodsService.saveGoods(goodsDTO);
        return new ResponseEntity<>(savedGoodsDTO, HttpStatus.OK);
    }

    @PostMapping({"/goods/quantity/add"})
    public ResponseEntity<GoodsQuantityDTO> addGoodsQuantity(Model model, HttpServletRequest request, HttpServletResponse response
            , @RequestParam(value = "goodsid", required = false) int goodsID
            , @RequestParam(value = "goodsqnt", required = false) int goodsQuantity
    ){
        GoodsDTO goodsDTO = new GoodsDTO(goodsID, null);
        GoodsQuantityDTO goodsQuantityDTO = new GoodsQuantityDTO(goodsDTO, goodsQuantity);
        GoodsQuantityDTO addedGoodsQuantityDTO = goodsQuantityService.add(goodsQuantityDTO);
        return new ResponseEntity<>(addedGoodsQuantityDTO, HttpStatus.OK);
    }

    @PostMapping({"/goods/quantity/delete"})
    public ResponseEntity<GoodsQuantityDTO> deleteGoodsQuantity(Model model, HttpServletRequest request, HttpServletResponse response
            , @RequestParam(value = "goodsid", required = false) int goodsID
            , @RequestParam(value = "goodsqnt", required = false) int goodsQuantity
    ){
        GoodsDTO goodsDTO = new GoodsDTO(goodsID, null);
        GoodsQuantityDTO goodsQuantityDTO = new GoodsQuantityDTO(goodsDTO, goodsQuantity);
        GoodsQuantityDTO addedGoodsQuantityDTO = goodsQuantityService.delete(goodsQuantityDTO);
        return new ResponseEntity<>(addedGoodsQuantityDTO, HttpStatus.OK);
    }

}
