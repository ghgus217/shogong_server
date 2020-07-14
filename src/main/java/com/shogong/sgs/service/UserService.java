package com.shogong.sgs.service;

import com.shogong.sgs.method.JwtUtilImpl;
import com.shogong.sgs.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shogong.sgs.vo.LoginResultVo;
import com.shogong.sgs.vo.LoginVo;
import com.shogong.sgs.vo.TokenCheckResultVo;
import com.shogong.sgs.vo.TokenCheckVo;
import com.shogong.sgs.vo.UserRegistetVo;

@Service
public class UserService {

    private JwtUtilImpl ju = new JwtUtilImpl();


    @Autowired
    private UserRepository userRepository;

    public int Register(UserRegistetVo user) {

        user.setUSER_TOKEN(ju.createToken());

        return userRepository.Register(user);

    }

    public LoginResultVo Login(LoginVo user)
    {
        return userRepository.Login(user);
    }

    public TokenCheckResultVo tokenCheck(String tcvo)
    {
        return userRepository.tokenCheck(tcvo);
    }

}