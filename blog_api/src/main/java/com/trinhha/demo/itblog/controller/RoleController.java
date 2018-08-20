package com.trinhha.demo.itblog.controller;

import com.trinhha.demo.itblog.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
public class RoleController {

    @Autowired
    RoleService roleService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ResponseBody
    public Response getUser() {
        return Response.status(200).entity(roleService.getAllRoles()).build();
    }
}
