package com.thieu.servletfilterwrapper.security.advice;


import com.thieu.servletfilterwrapper.dto.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
@Slf4j
public class ProcessBodyAdvice implements ResponseBodyAdvice {

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        log.info("AfterController - modified");
        if(response instanceof ServletServerHttpResponse) {
            ServletServerHttpResponse res= (ServletServerHttpResponse)(response);
            res.setStatusCode(HttpStatusCode.valueOf(res.getServletResponse().getStatus())); // modify headers
            res.getHeaders().set("Test-key-Header", "Test-key-Header"); //modify headers
        }

        if(body instanceof Employee) {
            Employee employee= (Employee)(body);
            employee.setMsg((employee.getMsg() != null ? employee.getMsg() : "") + " - after");
        }

        return body;
    }
}