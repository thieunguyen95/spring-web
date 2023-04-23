package com.thieu.preconfig;

import com.thieu.preconfig.dto.PropertyDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class Controller {

    @GetMapping("/")
    public Map getListProperties() throws InterruptedException {
        Thread.sleep(3000);
        Map res = new HashMap();

        res.put("spring.datasource.username", "root");
        res.put("spring.datasource.password", "");

        return res;
    }
}
