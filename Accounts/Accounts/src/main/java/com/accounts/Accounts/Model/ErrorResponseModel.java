package com.accounts.Accounts.Model;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@Builder
public class ErrorResponseModel {

    private String api_path;
    private HttpStatus status_code;
    private String error_message;
    private LocalDateTime error_time;
}
