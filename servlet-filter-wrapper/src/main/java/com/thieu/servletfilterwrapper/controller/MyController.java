package com.thieu.servletfilterwrapper.controller;

import com.thieu.servletfilterwrapper.dto.Employee;
import com.thieu.servletfilterwrapper.exception.AppException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class MyController {

    @PostMapping("/test1")
    public ResponseEntity<Employee> hello(@RequestBody Employee employee) {
        log.info("POST - function - hello");
        if (1 == 1)
            throw new AppException(234, "123456");
        return ResponseEntity.ok(employee);
    }

    @PostMapping("/test2")
    public ResponseEntity<Employee> hello2(@RequestBody Employee employee) throws Exception {
        log.info("POST - function - hello");
        if (1 == 1 && 1/0 == 2)
            throw new Exception();
        return ResponseEntity.ok(employee);
    }
    @PostMapping("/test3")
    public ResponseEntity<Employee> hello3(@RequestBody Employee employee) throws IOException {
        log.info("POST - function - hello");
        if (1 == 1)
            throw new IOException();
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/123")
    public ResponseEntity<Employee> helloGet() {
        log.info("GET - function - helloGet");
        return ResponseEntity.ok(Employee.builder().msg("sever hello").build());
    }
}
