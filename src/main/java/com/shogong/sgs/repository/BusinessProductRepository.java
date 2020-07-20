package com.shogong.sgs.repository;

import java.util.ArrayList;

import com.shogong.sgs.vo.BusinessProductGetResultVo;
import com.shogong.sgs.vo.BusinessProductGetVo;
import com.shogong.sgs.vo.BusinessProductUpdateVo;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface BusinessProductRepository {

    public ArrayList<BusinessProductGetResultVo > getBusinessProduct(BusinessProductGetVo input);
    public void updateBusinessProduct(BusinessProductUpdateVo input);
}