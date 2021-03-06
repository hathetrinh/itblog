package com.trinhha.demo.itblog.controller;

import com.trinhha.demo.itblog.dto.User;
import com.trinhha.demo.itblog.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
public class UserController {
    @Inject
    UserService userService;

    @POST
    @ResponseBody
    @Path("registration")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addNewUser(@NotNull User user) {
        userService.saveUser(user);
        return Response.ok().entity(user).build();
    }

    @GET
    @ResponseBody
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUser() {
        return Response.ok(userService.findAllUsers()).build();
    }

    @GET
    @ResponseBody
    @Path("/search")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserByEmail(@DefaultValue("admin@gmail.com") @QueryParam("email") String email) {
        User user = userService.findUserByEmail(email);
        if (null != user) {
            return Response.status(200).entity(user).build();
        } else {
            return Response.status(404).build();
        }
    }

    @PUT
    @ResponseBody
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePassword(@FormParam("email") String email,
            @DefaultValue("!23Asd") @FormParam("password") String password) {
        User user = userService.updateUser(userService.findUserByEmail(email));
        return Response.ok().entity(user).build();
    }
}
