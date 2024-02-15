package com.any.main_logic.controllers.model_con;

import com.any.main_logic.services.Model_services.HateModelService;
import com.any.main_logic.services.Model_services.TopicModelService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/classify")
public class TextClassificationController {
    private final HateModelService _hateModel = new HateModelService();
    private final TopicModelService _topicModel = new TopicModelService();

    @Path("/hate")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response classifyHate(@QueryParam("text") String text) {
        try {
            var hateClass = _hateModel.ClassifyText(text);
            return Response.ok(hateClass).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.BAD_REQUEST).entity(ex.getMessage()).build();
        }
    }

    @Path("/topic")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response classifyTopic(@QueryParam("text") String text) {
        try {
            var topicClass = _topicModel.ClassifyText(text);
            return Response.ok(topicClass).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.BAD_REQUEST).entity(ex.getMessage()).build();
        }
    }
}
