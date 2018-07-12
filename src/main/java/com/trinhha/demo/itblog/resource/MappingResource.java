package com.trinhha.demo.itblog.resource;

import com.trinhha.demo.itblog.controller.IndexController;
import com.trinhha.demo.itblog.controller.RoleController;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Component
@Path("blog")
@Consumes({"application/hal+json", "application/json"})
@Produces({"application/hal+json", "application/json"})
public class MappingResource {

    @Inject
    private IndexController indexController;

    @Inject
    private RoleController roleController;

    @Path("index")
    public IndexController routeIndexController() {
        return indexController;
    }

    @Path("role")
    public RoleController routeRoleController() {
        return roleController;
    }
}
