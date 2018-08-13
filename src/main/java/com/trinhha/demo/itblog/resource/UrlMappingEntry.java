package com.trinhha.demo.itblog.resource;

import com.trinhha.demo.itblog.controller.DictionaryController;
import com.trinhha.demo.itblog.controller.IndexController;
import com.trinhha.demo.itblog.controller.RoleController;
import com.trinhha.demo.itblog.controller.UserController;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Component
@Path("api")
@Consumes({"application/hal+json", "application/json"})
@Produces({"application/hal+json", "application/json"})
public class UrlMappingEntry {

    @Inject
    private IndexController indexController;

    @Inject
    private RoleController roleController;

    @Inject
    private UserController userController;

    @Inject
    private DictionaryController dictionaryController;

    @Path("")
    public IndexController routeToIndexController() {
        return indexController;
    }

    @Path("role")
    public RoleController routeToRoleController() {
        return roleController;
    }

    @Path("user")
    public UserController routeToUserController() {
        return userController;
    }

    @Path("dictionary")
    public DictionaryController routeToDictionaryController() {
        return dictionaryController;
    }
}
