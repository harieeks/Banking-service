package com.accounts.Accounts.Exception;

import com.accounts.Accounts.Model.ErrorResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseModel> handleGlobalException(
            Exception e,
            WebRequest webRequest
    ){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(
                        ErrorResponseModel.builder()
                                .api_path(webRequest.getDescription(false))
                                .error_message(e.getMessage())
                                .status_code(HttpStatus.INTERNAL_SERVER_ERROR)
                                .error_time(LocalDateTime.now())
                                .build()
                );
    }
}
