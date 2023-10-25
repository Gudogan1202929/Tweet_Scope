package com.any.service.reso;

import com.any.model.JWT_BL.JWTModel;
import com.any.model.JWT_BL.UserModel;
import com.any.service.controller.Account_controller;
import com.any.utils.constant.SystemConstants;
import com.any.utils.constant.SystemPaths;
import com.any.utils.jwt.CreateJWT;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/account")
public class Account_reso {


    private static final Account_controller accountController = new Account_controller();


    @POST
    @Transactional
    @Path(SystemPaths.LOGIN_PATH)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login (UserModel userModel){
        try {
            boolean isUserExist = accountController.login(userModel);
            JWTModel jwtModel = new JWTModel();
            if (isUserExist){
                String jwt = CreateJWT.createJWT(userModel.getUsername(), SystemConstants.TOKEN_EXPIRATION_TIME);
                jwtModel.setJWTToken(jwt);
            }
            return Response.ok(jwtModel.getJWTToken()).build();
        }catch (Exception e){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }


    @POST
    @Transactional
    @Path(SystemPaths.SIGNUP)
    @Produces(MediaType.APPLICATION_JSON)
    public Response SignUp (UserModel userModel){
        try {
             if (accountController.signUp(userModel)){
                 return Response.ok().build();
             }else
                 return Response.status(Response.Status.BAD_REQUEST).build();
        }catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }


}
