package com.trinhha.demo.itblog.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Component
public class IndexController {

    @GET
    @ResponseBody
    @Produces(MediaType.APPLICATION_JSON)
    public String addNewUser() {
        return "hello the world";
    }
}
