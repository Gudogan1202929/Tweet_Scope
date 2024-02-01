package com.any.service.reso.Model_res;

import com.any.model.dto.AskModel_dto;
import com.any.service.controller.model_con.AskModel_Controller;
import com.any.utils.constant.SystemPaths;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path(SystemPaths.MODEL)
public class AskModel_res {

    private final AskModel_Controller askModel_controller = new AskModel_Controller();

    @POST
    @Path(SystemPaths.MODEL_ABUSIVE)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response typeOfAbusive(AskModel_dto message) {
        try {
            return Response.ok(askModel_controller.typeOfAbusive(message.getMessage())).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        }
    }


    @POST
    @Path(SystemPaths.MODEL_TOPIC)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response typeOfTopics(AskModel_dto message){
        try {
            return Response.ok(askModel_controller.typeOfTopics(message.getMessage())).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        }
    }
}
