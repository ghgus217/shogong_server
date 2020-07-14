package com.shogong.sgs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shogong.sgs.service.BusinessStoryService;
import com.shogong.sgs.service.UserService;
import com.shogong.sgs.vo.BusinessStoryGetMappingVo;
import com.shogong.sgs.vo.BusinessStoryGetResultVO;
import com.shogong.sgs.vo.BusinessStoryGetVO;
import com.shogong.sgs.vo.BusinessStoryUpdateResultVo;
import com.shogong.sgs.vo.BusinessStrotyUpdateVo;
import com.shogong.sgs.vo.TokenCheckResultVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@CrossOrigin(origins = "http://localhost:3000")
@Api(description = "제조사스토리 API")
@RestController
public class BusinessStoryController{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BusinessStoryService service;
    @Autowired
    private UserService userService;

    @GetMapping("/manufacturer/check")
    public int checkBusinessStory(final HttpServletRequest request, final HttpServletResponse response) {

        final TokenCheckResultVo result = userService.tokenCheck(request.getHeader("access_token"));

        final BusinessStoryGetResultVO getResult = service.checkBusinessStory(result.getId());

        if(getResult == null)
            return 0;

        return getResult.getIdx();
    }

    @GetMapping("/manufacturer/getbypostid/{postId}")
    public BusinessStoryGetResultVO getByPostIdBusinessStory(@PathVariable int postId, final HttpServletRequest request, final HttpServletResponse response) {

        final TokenCheckResultVo result = userService.tokenCheck(request.getHeader("access_token"));

        if(result == null)

            return new BusinessStoryGetResultVO();

        BusinessStoryGetResultVO getResult = service.getByPostIdBusinessStory(postId);

        if(getResult == null)
        {
            getResult = new BusinessStoryGetResultVO();
            getResult.setSTAUTS(false);
            getResult.setIdx(-1);
        }
        else
            getResult.setSTAUTS(true);

        return getResult;
    }

    @GetMapping("/manufacturer/getbyuserid/{userId}")
    public BusinessStoryGetResultVO getByUserIdBusinessStory(@PathVariable String userId, final HttpServletRequest request, final HttpServletResponse response) {

        final TokenCheckResultVo result = userService.tokenCheck(request.getHeader("access_token"));

        if(result == null)

            return new BusinessStoryGetResultVO();

        BusinessStoryGetResultVO getResult = service.getByUserIdBusinessStory(userId);

        if(getResult == null)
        {
            getResult = new BusinessStoryGetResultVO();
            getResult.setSTAUTS(false);
            getResult.setIdx(-1);
        }
        else
            getResult.setSTAUTS(true);

        return getResult;
    }

    @PostMapping("/manufacturer/register")
    public BusinessStoryGetResultVO updateBusinessStory(@RequestBody final BusinessStrotyUpdateVo getvo, final HttpServletRequest request, final HttpServletResponse response) {

        final TokenCheckResultVo result = userService.tokenCheck(request.getHeader("access_token"));
        getvo.setId(result.getId());
        return service.updateBusinessStory(getvo);
    }
    
}