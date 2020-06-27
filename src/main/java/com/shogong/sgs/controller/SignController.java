package com.shogong.sgs.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shogong.sgs.repository.UserRepository;
import com.shogong.sgs.service.UserService;
import com.shogong.sgs.vo.LoginResponseVo;
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
import org.springframework.web.util.WebUtils;

import io.swagger.annotations.Api;

@CrossOrigin(origins = "http://localhost:3000")
@Api(description = "유저 API")
@RestController
public class SignController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService service;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/api/auth/register")
    public boolean Register(@RequestBody UserRegistetVo user) {
        service.Register(user);

        if (user.getId() == null)
            return false;

        return true;
    }

    @PostMapping("/api/auth/login")
    public LoginResponseVo Login(@RequestBody LoginVo user, HttpServletResponse response) {
        LoginResultVo result = service.Login(user);
        LoginResponseVo lrv = new LoginResponseVo();

        if(result.getUSER_TOKEN() == null)
            lrv.setLogin_Message("login fail");
        else
        {
            response.setHeader("access-token", result.getUSER_TOKEN());
            response.addCookie(new Cookie("access-token", result.getUSER_TOKEN()));  
            lrv.setLogin_Message("login success");
        }

        return lrv;
    }

    @GetMapping("/api/auth/check")
    public TokenCheckVo check(HttpServletRequest request, HttpServletResponse response)
    {
        Cookie givenToken = WebUtils.getCookie(request, "access-token");
        TokenCheckVo tokenCheckVo = userRepository.tokenCheck(givenToken.getValue());
        
        return tokenCheckVo;
    }


   @GetMapping("/test")
    public String Test()
    {
	String testst = "test"; 
        return testst;
    }


}
