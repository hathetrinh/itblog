package com.trinhha.demo.itblog.configuration;

import com.trinhha.demo.itblog.resource.UrlMappingEntry;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(UrlMappingEntry.class);
    }
}
