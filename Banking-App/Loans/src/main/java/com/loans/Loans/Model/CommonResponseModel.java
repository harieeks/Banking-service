package com.loans.Loans.Model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Builder
public class CommonResponseModel {

    private String status_code;
    private String message;
}
