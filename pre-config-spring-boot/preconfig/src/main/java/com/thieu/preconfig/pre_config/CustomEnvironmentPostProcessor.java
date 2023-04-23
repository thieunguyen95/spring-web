package com.thieu.preconfig.pre_config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.boot.logging.DeferredLog;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

import static org.springframework.core.env.StandardEnvironment.SYSTEM_ENVIRONMENT_PROPERTY_SOURCE_NAME;

@Component
public class CustomEnvironmentPostProcessor implements EnvironmentPostProcessor {

    private static final DeferredLog log = new DeferredLog();

    @Override
    public void postProcessEnvironment(
            ConfigurableEnvironment env, SpringApplication app) {

        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8081/";
        ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);

//        Map mapProperties = response.getBody();
//        mapProperties.put("server.port", 8089);
        env.getPropertySources()
                .addAfter(SYSTEM_ENVIRONMENT_PROPERTY_SOURCE_NAME, new MapPropertySource("prefixProperty", response.getBody()));

        log.info("load PreConfig");
    }

}
