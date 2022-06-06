package com.CRUD;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("api")
@Configuration
public class JerseyConfiguration extends ResourceConfig {
        public JerseyConfiguration() {
        	register(PersonneResource.class);
    		register(FilmResource.class);
    		property(ServletProperties.FILTER_FORWARD_ON_404, true);

        }
}