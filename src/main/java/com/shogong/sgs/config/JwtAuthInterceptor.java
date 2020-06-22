package com.shogong.sgs.config;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shogong.sgs.repository.UserRepository;
import com.shogong.sgs.service.JwtUtil;
import com.shogong.sgs.vo.LoginVo;
import com.shogong.sgs.vo.TokenCheckVo;
import com.shogong.sgs.vo.UserRegistetVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class JwtAuthInterceptor implements HandlerInterceptor {
    
    @Autowired
    private JwtUtil jwtUtil;
    
    @Autowired
    private UserRepository userRepository;

    private String HEADER_TOKEN_KEY = "access-token";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String givenToken = request.getHeader(HEADER_TOKEN_KEY);
        TokenCheckVo tokenCheckVo = userRepository.tokenCheck(givenToken);

        if(tokenCheckVo == null)
            return false;

        //verifyToken(givenToken, userid);

        response.setHeader("userId", tokenCheckVo.getUSER_ID());

        response.setStatus(401);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception
    {
        
    }

    private void verifyToken(String givenToken, String membersToken) {
        if(! givenToken.equals(membersToken)){
            throw new IllegalArgumentException("사용자의 Token과 일치하지 않습니다.");
        }

        jwtUtil.verifyToken(givenToken);
    }

    
}