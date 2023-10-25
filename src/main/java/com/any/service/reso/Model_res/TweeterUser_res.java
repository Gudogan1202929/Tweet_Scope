package com.any.service.reso.Model_res;

import com.any.model.TweetUserModel;
import com.any.service.controller.model_con.TweetUserController;
import com.any.utils.constant.SystemPaths;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path(SystemPaths.TWEETER_USER)
public class TweeterUser_res {

    private final TweetUserController tweeterUserController = new TweetUserController();

    @GET
    @Path(SystemPaths.RETRIEVE)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response RetrieveAllTweeterUsers() {
        try {
            return Response.ok(tweeterUserController.retrieveAllUsers()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        }
    }

    @POST
    @Path(SystemPaths.INSERT)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertAllTweeterUsers(List<TweetUserModel> tweetUserModels) {
        try {
            boolean check = tweeterUserController.insertTweeterUsers(tweetUserModels);
            if (!check) {
                return Response.status(Response.Status.NOT_ACCEPTABLE).build();
            }
            return Response.ok(tweetUserModels).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        }
    }

    @GET
    @Path(SystemPaths.TOPREGIONS)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getTopRegions() {
        try {
            return Response.ok(tweeterUserController.TopRegions()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        }
    }


    @GET
    @Path(SystemPaths.GLOBALDISTRIBUTION)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getGlobalDistributions() {
        try {
            return Response.ok(tweeterUserController.globalDistribution()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        }
    }
}
