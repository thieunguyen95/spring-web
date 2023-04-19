package com.thieu.servletfilterwrapper.controller;

import com.thieu.servletfilterwrapper.dto.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class MyController {

    @PostMapping
    public ResponseEntity<Employee> hello(@RequestBody Employee employee){
        log.info("POST - function - hello");
        return ResponseEntity.ok(employee);
    }

    @GetMapping
    public ResponseEntity<Employee> helloGet(){
        log.info("POST - function - helloGet");
        return ResponseEntity.ok(Employee.builder().msg("sever hello").build());
    }
}
