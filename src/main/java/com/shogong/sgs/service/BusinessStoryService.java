package com.shogong.sgs.service;

import com.shogong.sgs.repository.BusinessStoryRepository;
import com.shogong.sgs.vo.BusinessStoryGetResultVO;
import com.shogong.sgs.vo.BusinessStoryGetVO;
import com.shogong.sgs.vo.BusinessStoryUpdateResultVo;
import com.shogong.sgs.vo.BusinessStrotyUpdateVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessStoryService {

    @Autowired
    private BusinessStoryRepository businessStroyrepository;

    public BusinessStoryGetResultVO checkBusinessStory(String user) {

        BusinessStoryGetResultVO result = businessStroyrepository.checkBusinessStory(user);

        return result;
    }


    public BusinessStoryGetResultVO getByPostIdBusinessStory(int postId) {

        BusinessStoryGetResultVO result = businessStroyrepository.getByPostIdBusinessStory(postId);

        return result;
    }

    public BusinessStoryGetResultVO getByUserIdBusinessStory(String userId) {

        BusinessStoryGetResultVO result = businessStroyrepository.getByUserIdBusinessStory(userId);

        return result;
    }


    public BusinessStoryGetResultVO  updateBusinessStory(BusinessStrotyUpdateVo uvo) {

        BusinessStoryGetResultVO check = businessStroyrepository.checkBusinessStory(uvo.getId());

        if(check == null)
            businessStroyrepository.createBusinessStory(uvo);

       businessStroyrepository.updateBusinessStory(uvo);

       BusinessStoryGetResultVO  result =  businessStroyrepository.checkBusinessStory(uvo.getId());

        return result;
    }
    
}