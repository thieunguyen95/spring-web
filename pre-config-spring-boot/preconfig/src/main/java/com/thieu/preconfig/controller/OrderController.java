package com.thieu.preconfig.controller;

import com.thieu.preconfig.model.Order;
import com.thieu.preconfig.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class OrderController {
    @Autowired
    OrderRepository orderRepository;

    @GetMapping
    public List<Order> getListOrder(){

        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8081/";
        ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);

        return orderRepository.findAll();
    }
}
