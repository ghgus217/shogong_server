package com.shogong.sgs.method;

import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.shogong.sgs.service.JwtUtil;

import org.springframework.stereotype.Component;

@Component
public class JwtUtilImpl implements JwtUtil {
    private String TEST_SIGN_KEY = "2B6C3DC59545171F06483F2BE0CBE599F1DF9214700AC74B74DB5589FBA88C97";
    private Date EXPIRED_TIME = new Date(System.currentTimeMillis() + 1000 * 10);
    private String ISSUER = "JHH";

    @Override
    public String createToken() {
        return JWT.create()
                .withIssuer(ISSUER)
                .withExpiresAt(EXPIRED_TIME)
                .sign(Algorithm.HMAC256(TEST_SIGN_KEY));
    }

    @Override
    public void verifyToken(String givenToken) {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(TEST_SIGN_KEY))
                .withIssuer(ISSUER)
                .build();

        verifier.verify(givenToken);
    }
}