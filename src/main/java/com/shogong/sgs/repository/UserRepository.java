package com.shogong.sgs.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.shogong.sgs.vo.LoginResultVo;
import com.shogong.sgs.vo.LoginVo;
import com.shogong.sgs.vo.TokenCheckResultVo;
import com.shogong.sgs.vo.TokenCheckVo;
import com.shogong.sgs.vo.UserRegistetVo;

@Repository
@Mapper
public interface UserRepository {

    int Register(UserRegistetVo user);

    LoginResultVo Login(LoginVo user);

    TokenCheckResultVo tokenCheck(String givenToken);
}