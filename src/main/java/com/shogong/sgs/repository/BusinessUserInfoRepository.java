package com.shogong.sgs.repository;

import java.util.ArrayList;

import com.shogong.sgs.vo.BusinessUserInfoCheckVo;
import com.shogong.sgs.vo.BusinessUserInfoGetVo;
import com.shogong.sgs.vo.BusinessUserListResultVo;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface BusinessUserInfoRepository {

    public BusinessUserInfoCheckVo checkBusinessUserInfo(String user);
    public BusinessUserInfoGetVo getBusinessUserInfo(int userId);
    public ArrayList<BusinessUserListResultVo> getBusinessUserList(int page);
    
}