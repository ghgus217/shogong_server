package com.shogong.sgs.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shogong.sgs.repository.UserRepository;
import com.shogong.sgs.service.UserService;
import com.shogong.sgs.vo.LoginResultVo;
import com.shogong.sgs.vo.LoginVo;
import com.shogong.sgs.vo.TokenCheckVo;
import com.shogong.sgs.vo.UserRegistetVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@CrossOrigin(origins="http://localhost:3000")
@Api(description = "유저 API")
@RestController
public class SignController{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService service;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/api/auth/register")
    public boolean Register(@RequestBody UserRegistetVo user)
    {
        service.Register(user);

        if(user.getId() == null)
            return false;

        return true;
    }

    @PostMapping("/api/auth/login")
    public LoginResultVo Login(@RequestBody LoginVo user, HttpServletResponse response)
    {
        LoginResultVo result = service.Login(user);

        if(result.getUSER_TOKEN() == null)
            result.setLogin_Message("login fail");
        else
        {
            response.addCookie(new Cookie("access-token", "USER_TOKEN"));  
            result.setLogin_Message("login success");
        }

        return result;
    }

    @PostMapping("/api/auth/check")
    public TokenCheckVo check(@RequestBody LoginVo user, HttpServletRequest request, HttpServletResponse response)
    {
        String HEADER_TOKEN_KEY = "access-token";

        String givenToken = request.getHeader(HEADER_TOKEN_KEY);
        TokenCheckVo tokenCheckVo = userRepository.tokenCheck(givenToken);
        
        return tokenCheckVo;
    }


   @GetMapping("/test")
    public String Test()
    {
	String testst = "test"; 
        return testst;
    }


}
