package com.thieu.servletfilterwrapper.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    // Sử dụng @RestControllerAdvice, nó sẽ bắt tất cả các throws Exception(cả chủ động hoặc bị động)
    // Tại đây ta sẽ xử lý từng loại Exception, sau đó trả ra theo ý mình
    // Các Exception còn lại nếu không được xử lý sẽ được gom hết vào Exception.class.

    @ExceptionHandler({ AppException.class , IOException.class})  // Có thể bắt nhiều loại exception
    public ResponseEntity<?> handleExceptionA(Exception e) {
        if (e instanceof AppException) {
            AppException appEx = (AppException) e;
            return ResponseEntity.status(appEx.getCode()).body(appEx);
        } else {
            return ResponseEntity.status(411).body(e.getMessage());
        }
    }

    // Có thêm các @ExceptionHandler khác...

    // Nên bắt cả Exception.class
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleUnwantedException(Exception e) {
        // Log lỗi ra và ẩn đi message thực sự
        log.info(e.getMessage());
        return ResponseEntity.status(500).body("Unknow error");
    }
}
