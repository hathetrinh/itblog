package com.trinhha.demo.itblog.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Component
public class IndexController {

    @GET
    @ResponseBody
    public Response getHome() {

        return Response.ok().entity("Home Page").status(Response.Status.OK).build();
    }

    @GET
    @Path("/login")
    @ResponseBody
    public Response getLogin() {
        return Response.ok().entity("Login Page").status(Response.Status.OK).build();
    }

    @GET
    @Path("/access-denied")
    @ResponseBody
    public Response errorPage() {
        return Response.status(Response.Status.FORBIDDEN).entity("Access Denied").build();
    }
}
