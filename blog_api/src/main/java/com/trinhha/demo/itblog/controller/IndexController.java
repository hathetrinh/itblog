package com.trinhha.demo.itblog.controller;

import com.trinhha.demo.itblog.dto.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Component
public class IndexController {

    @GET
    @ResponseBody
    public Response getHome() {
        return Response.ok().entity("Home Page").status(Response.Status.OK).build();
    }

    @POST
    @Path("/login")
    @ResponseBody
    public Response getLogin(@NotNull User user) {

        return Response.ok().entity("Login Page").status(Response.Status.OK).build();
    }

    @GET
    @Path("/access-denied")
    @ResponseBody
    public Response errorPage() {
        return Response.ok().entity("Access Denied").status(Response.Status.FORBIDDEN).build();
    }
}
