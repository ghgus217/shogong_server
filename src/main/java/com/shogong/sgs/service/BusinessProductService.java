package com.shogong.sgs.service;

import java.util.ArrayList;

import com.shogong.sgs.repository.BusinessProductRepository;
import com.shogong.sgs.vo.BusinessProductGetResultVo;
import com.shogong.sgs.vo.BusinessProductGetVo;
import com.shogong.sgs.vo.BusinessProductUpdateVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessProductService {

    @Autowired
    BusinessProductRepository repository;

    public ArrayList<BusinessProductGetResultVo> getBusinessProduct(BusinessProductGetVo input)
    {
        return repository.getBusinessProduct(input);
    }

    public void updateBusinessProduct(BusinessProductUpdateVo input)
    {
        repository.updateBusinessProduct(input);
    }
    
}