package com.trinhha.demo.itblog.controller;

import com.trinhha.demo.itblog.service.impl.WordServiceImpl;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
public class DictionaryController {

    @Getter
    @Setter
    @Inject
    private WordServiceImpl wordService;

    @ResponseBody
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVietNameseMean(@NotNull @QueryParam("english") String english) {

        return Response.ok().build();
    }
}
