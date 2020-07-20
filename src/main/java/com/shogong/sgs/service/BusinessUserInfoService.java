package com.shogong.sgs.service;

import java.util.ArrayList;

import com.shogong.sgs.repository.BusinessUserInfoRepository;
import com.shogong.sgs.vo.BusinessUserInfoCheckVo;
import com.shogong.sgs.vo.BusinessUserInfoGetVo;
import com.shogong.sgs.vo.BusinessUserListResultVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessUserInfoService {

    @Autowired
    private BusinessUserInfoRepository repository;

    public BusinessUserInfoCheckVo checkBusinessUserInfo(String user){

        BusinessUserInfoCheckVo result = repository.checkBusinessUserInfo(user);

        return result;
    }

    public BusinessUserInfoGetVo getBusinessUserInfo(int postId) {

        BusinessUserInfoGetVo result = repository.getBusinessUserInfo(postId);

        return result;
    }

    public ArrayList<BusinessUserListResultVo> getBusinessUserList(int page) 
    {
        return repository.getBusinessUserList(page);
    }
    
}