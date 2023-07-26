package com.thieu.async.config;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

@Data
@Configuration
@ConfigurationProperties(prefix = "map")
@PropertySource(value = "classpath:mapping-codes.yml", factory = YamlPropertySourceFactory.class)
public class CustomPropertiesConfig {

    private final String DEFAULT_CODE = "0600";
    private Map<String, String> iso8583;
    private Map<String, String> osb;
    private Map<String, String> db;

    @PostConstruct
    private void init() {
        System.out.println(1);
        if (iso8583 == null){
            iso8583 = new HashMap<>();
        }
        if (osb == null){
            osb = new HashMap<>();
        }
    }

    public String getIso8583ToAtomicCode(String code){
        String result = iso8583.get(code);
        return StringUtils.hasText(result) ? result : DEFAULT_CODE;
    }

    public String getOSBToAtomicCode(String code){
        String result = osb.get(code);
        return StringUtils.hasText(result) ? result : DEFAULT_CODE;
    }

    public String getDBToAtomicCode(String code){
        String result = db.get(code);
        return StringUtils.hasText(result) ? result : DEFAULT_CODE;
    }

}
