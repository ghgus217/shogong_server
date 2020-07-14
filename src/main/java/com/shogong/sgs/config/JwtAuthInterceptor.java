package com.shogong.sgs.config;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shogong.sgs.repository.UserRepository;
import com.shogong.sgs.service.JwtUtil;
import com.shogong.sgs.vo.LoginVo;
import com.shogong.sgs.vo.TokenCheckResultVo;
import com.shogong.sgs.vo.TokenCheckVo;
import com.shogong.sgs.vo.UserRegistetVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

public class JwtAuthInterceptor implements HandlerInterceptor, Filter {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepository userRepository;

    private String HEADER_TOKEN_KEY = "access_token";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        //Cookie givenToken = WebUtils.getCookie(request, access_token);
        TokenCheckResultVo tokenCheckVo = userRepository.tokenCheck(request.getHeader("access_token"));

        if (tokenCheckVo == null) {
            // response.sendRedirect("/");
            return false;
        }

        // verifyToken(givenToken, userid);

        //request.setAttribute("userId", tokenCheckVo.getId());
        response.setHeader("userId", tokenCheckVo.getId());

        //response.setStatus(401);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {

    }

    private void verifyToken(String givenToken, String membersToken) {
        if (!givenToken.equals(membersToken)) {
            throw new IllegalArgumentException("사용자의 Token과 일치하지 않습니다.");
        }

        jwtUtil.verifyToken(givenToken);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
            throws IOException, ServletException {
                HttpServletResponse response = (HttpServletResponse) servletResponse;
                HttpServletRequest request= (HttpServletRequest) servletRequest;
        
                response.setHeader("Access-Control-Allow-Origin", "*");
                response.setHeader("Access-Control-Allow-Methods", "GET,POST,DELETE,PUT,OPTIONS");
                response.setHeader("Access-Control-Allow-Headers", "*");
                response.setHeader("Access-Control-Allow-Credentials", "true");
                response.setHeader("Access-Control-Max-Age", "180");
                chain.doFilter(servletRequest, servletResponse);

    }

    
}