package com.any.service.reso.Model_res;

import com.any.model.TweetModel;
import com.any.service.controller.model_con.TweetModelController;
import com.any.utils.constant.SystemPaths;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path(SystemPaths.TWEETS)
public class Tweet_res {

    private final TweetModelController tweetModelController = new TweetModelController();

    @GET
    @Path(SystemPaths.RETRIEVE)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAllTweets() {
        try {
            return Response.ok(tweetModelController.retrieveAllTweets()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        }
    }


    @POST
    @Path(SystemPaths.INSERT)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertAllTweets(List<TweetModel> tweetModels) {
        try {
            boolean check = tweetModelController.insertTweets(tweetModels);
            if (!check) {
                return Response.status(Response.Status.NOT_ACCEPTABLE).build();
            }
            return Response.ok(tweetModels).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        }
    }

    @GET
    @Path(SystemPaths.RESENTHATESPEECH)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response resentHateSpeech() {
        try {
            return Response.ok(tweetModelController.resentHateSpeech()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        }
    }

    @GET
    @Path(SystemPaths.RESNETPORNOGRAPHY)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response resentPornography() {
        try {
            return Response.ok(tweetModelController.resentPornography()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        }
    }

    @GET
    @Path(SystemPaths.RESNETABUSIVE)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response resentAbusive() {
        try {
            return Response.ok(tweetModelController.resentAbusive()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        }
    }

    @GET
    @Path(SystemPaths.OFFENSIVECHART)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response OffensiveChart() {
        try {
            return Response.ok(tweetModelController.OffensiveChart()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        }
    }

    @GET
    @Path(SystemPaths.TOPICCLASSIFICATIONS)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response topicClassifications() {
        try {
            return Response.ok(tweetModelController.topicClassifications()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        }
    }

    @GET
    @Path(SystemPaths.RECENTTOPIC)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response recentTopic() {
        try {
            return Response.ok(tweetModelController.recentTopic()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        }
    }
}
