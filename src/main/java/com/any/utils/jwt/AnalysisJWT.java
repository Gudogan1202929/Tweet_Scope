package com.any.utils.jwt;

import com.any.main_logic.repo.BlackListNative;
import com.any.model.JWT_BL.UserModel;
import com.any.main_logic.repo.BlackListRepo;
import com.any.main_logic.repo.Account_repo;
import com.any.utils.constant.SystemConstants;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

public class AnalysisJWT {

    private static final Account_repo userRepo = new Account_repo();
    public static final BlackListRepo blackListRepo = new BlackListRepo();
    public static final BlackListNative blackListNative = new BlackListNative();

    public static boolean CheckJWTIfForUser(String jwt) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SystemConstants.THE_KEY_FOR_TOKEN.getBytes());
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT decodedJWT = verifier.verify(jwt);

            UserModel userModelFromDataBase =  userRepo.findByUsername(decodedJWT.getSubject());

            if (!decodedJWT.getSubject().equals(userModelFromDataBase.getUsername())
                    || !jwt.equals(userModelFromDataBase.getToken())){
                return false;
            }
            Long expirationTime = decodedJWT.getClaim(SystemConstants.EXPIRED).asLong();
            long currentTime = System.currentTimeMillis() / 1000;
            return expirationTime > currentTime;
        }catch (Exception e){
            return false;
        }
    }

    public static String WhatRole(String jwt) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SystemConstants.THE_KEY_FOR_TOKEN.getBytes());
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT decodedJWT = verifier.verify(jwt);
            return decodedJWT.getClaims().get(SystemConstants.ROLE).asString();
        }catch (Exception e){
            return null;
        }
    }
}
