package com.shogong.sgs.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shogong.sgs.service.BusinessUserInfoService;
import com.shogong.sgs.service.UserService;
import com.shogong.sgs.vo.BusinessUserInfoCheckVo;
import com.shogong.sgs.vo.TokenCheckResultVo;
import com.shogong.sgs.vo.BusinessUserInfoGetVo;
import com.shogong.sgs.vo.BusinessUserListResultVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin(origins = "http://localhost:3000")
@Api(description = "사업자 정보 API")
@RestController
public class BusinessUserInfoController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BusinessUserInfoService service;
    @Autowired
    private UserService userService;

    @GetMapping("/businessUserInfo/check")
    public int checkBusinessUserInfo(HttpServletRequest request, HttpServletResponse response) {

        TokenCheckResultVo result = userService.tokenCheck(request.getHeader("access_token"));

        BusinessUserInfoCheckVo checkResult = service.checkBusinessUserInfo(result.getId());

        if(checkResult == null)
            return 0;

        return checkResult.getIdx();
    }

    @GetMapping("/businessUserInfo/get/{postId}")
    public BusinessUserInfoGetVo getBusinessUserInfo(@PathVariable int postId, HttpServletRequest request, HttpServletResponse response) {

        TokenCheckResultVo result = userService.tokenCheck(request.getHeader("access_token"));

        BusinessUserInfoGetVo getResult = service.getBusinessUserInfo(postId);

        if(getResult == null)
            return new BusinessUserInfoGetVo();

        return getResult;
    }

    @GetMapping("/businessUserList/get")
    public ArrayList<BusinessUserListResultVo> getBusinessUserList(@RequestParam int page, HttpServletRequest request,HttpServletResponse response) {
        
        TokenCheckResultVo result = userService.tokenCheck(request.getHeader("access_token"));

        if(result == null)
            return null;

        ArrayList<BusinessUserListResultVo> getResult = service.getBusinessUserList(page);

        if(getResult == null)
            return null;

        return getResult;
    }
    
    
}