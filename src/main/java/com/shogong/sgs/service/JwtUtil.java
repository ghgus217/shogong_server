package com.shogong.sgs.service;

public interface JwtUtil {

    String createToken();
    void verifyToken(String givenToken);
}