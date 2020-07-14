package com.shogong.sgs.repository;

import com.shogong.sgs.vo.BusinessStoryGetResultVO;
import com.shogong.sgs.vo.BusinessStoryUpdateResultVo;
import com.shogong.sgs.vo.BusinessStrotyUpdateVo;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface BusinessStoryRepository {

    public void createBusinessStory(BusinessStrotyUpdateVo user);
    public BusinessStoryGetResultVO checkBusinessStory(String user);
    public BusinessStoryGetResultVO getByPostIdBusinessStory(int postId);
    public BusinessStoryGetResultVO getByUserIdBusinessStory(String userId);
    public void updateBusinessStory(BusinessStrotyUpdateVo uvo);

}
