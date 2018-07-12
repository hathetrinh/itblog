package com.trinhha.demo.itblog;

import com.trinhha.demo.itblog.resource.MappingResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfiguration extends ResourceConfig {
    public JerseyConfiguration() {
        register(MappingResource.class);
    }
}
