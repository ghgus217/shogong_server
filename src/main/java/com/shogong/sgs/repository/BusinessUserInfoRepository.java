package com.shogong.sgs.repository;

import com.shogong.sgs.vo.BusinessUserInfoCheckVo;
import com.shogong.sgs.vo.BusinessUserInfoGetVo;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface BusinessUserInfoRepository {

    public BusinessUserInfoCheckVo checkBusinessUserInfo(String user);
    public BusinessUserInfoGetVo getBusinessUserInfo(int userId);
    
}