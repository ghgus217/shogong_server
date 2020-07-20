package com.shogong.sgs.controller;

import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shogong.sgs.service.BusinessProductService;
import com.shogong.sgs.service.UserService;
import com.shogong.sgs.vo.BusinessProductGetResultVo;
import com.shogong.sgs.vo.BusinessProductGetVo;
import com.shogong.sgs.vo.BusinessProductUpdateVo;
import com.shogong.sgs.vo.TokenCheckResultVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



@Api(description = "상품 목록 API")
@RestController
public class BusinessProductController {

    @Autowired
    UserService userService;

    @Autowired
    BusinessProductService service;

    @GetMapping("/product/get")
    public ArrayList<BusinessProductGetResultVo> getBusinessProduct(@RequestParam String id, @RequestParam int page, HttpServletRequest request,HttpServletResponse response) {

        TokenCheckResultVo result = userService.tokenCheck(request.getHeader("access_token"));

        if(result == null)
            return null;

        BusinessProductGetVo input = new BusinessProductGetVo();
        input.setId(id); input.setPage(page);

        ArrayList<BusinessProductGetResultVo> getResult = service.getBusinessProduct(input);

        if(getResult == null)
            return null;

        return getResult;
    }

    @PostMapping("/product/update")
    public int updateBusinessProduct(@RequestBody BusinessProductUpdateVo input, HttpServletRequest request, HttpServletResponse response)
    {
        TokenCheckResultVo result = userService.tokenCheck(request.getHeader("access_token"));

        input.setUserId(result.getId());

        if(result == null)
            return 0;

        service.updateBusinessProduct(input);

        return 1;
    }
    
    
}