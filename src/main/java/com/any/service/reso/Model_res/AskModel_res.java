package com.any.service.reso.Model_res;

import com.any.service.controller.model_con.AskModel_Controller;
import com.any.utils.constant.SystemPaths;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path(SystemPaths.MODEL)
public class AskModel_res {

    private final AskModel_Controller askModel_controller = new AskModel_Controller();

    @GET
    @Path(SystemPaths.MODEL_ABUSIVE)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response typeOfAbusive() {
        try {
            return Response.ok(askModel_controller.typeOfAbusive()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        }
    }


    @GET
    @Path(SystemPaths.MODEL_TOPIC)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response typeOfTopics() {
        try {
            return Response.ok(askModel_controller.typeOfTopics()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        }
    }
}
