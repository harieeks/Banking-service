package com.loans.Loans.Model;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@Builder
public class ErrorResponseModel {

    private String status_code;
    private String error_message;
    private String api_path;
    private LocalDateTime current_time;
}
