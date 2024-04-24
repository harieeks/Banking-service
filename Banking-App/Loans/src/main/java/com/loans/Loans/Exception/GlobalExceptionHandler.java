package com.loans.Loans.Exception;

import com.loans.Loans.Constants.LoanConstants;
import com.loans.Loans.Model.ErrorResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(LoanAlreadyExistException.class)
    public ResponseEntity<ErrorResponseModel> handleLoanAlreadyExistException(
            LoanAlreadyExistException e,
            WebRequest webRequest
    ){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ErrorResponseModel.builder()
                        .status_code(LoanConstants.STATUS_401)
                        .api_path(e.getMessage())
                        .current_time(LocalDateTime.now())
                        .build()
                );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseModel> handleGlobalException(
            Exception e,
            WebRequest webRequest
            )
    {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ErrorResponseModel.builder()
                        .status_code(LoanConstants.STATUS_500)
                        .api_path(e.getMessage())
                        .current_time(LocalDateTime.now())
                        .build()
                );
    }
}
