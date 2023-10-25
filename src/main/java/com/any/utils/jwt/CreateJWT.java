package com.any.utils.jwt;

import com.any.model.JWT_BL.BlackListModel;
import com.any.model.JWT_BL.UserModel;
import com.any.service.repo.BlackListRepo;
import com.any.service.repo.Account_repo;
import com.any.utils.constant.SystemConstants;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;

public class CreateJWT {

    private static final Account_repo userRepo = new Account_repo();

    private static final BlackListRepo blackListRepo = new BlackListRepo();

    public static String createJWT(String UserName, long ttlMillis) {

        UserModel userModel = userRepo.findByUsername(UserName);

        if (userModel.getToken() != null) {
            BlackListModel blackListModel = new BlackListModel(userModel.getToken());
            blackListRepo.persist(blackListModel);
        }

        Algorithm algorithm = Algorithm.HMAC256(SystemConstants.THE_KEY_FOR_TOKEN.getBytes());

        String token = JWT.create()
                .withIssuer(SystemConstants.ISSUER)
                .withSubject(UserName)
                .withClaim(SystemConstants.ROLE, userModel.getRole())
                .withExpiresAt(new Date(System.currentTimeMillis() + 3600000))
                .sign(algorithm);

        userRepo.AddToken(userModel, token);
        return token;
    }
}
