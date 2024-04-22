package com.accounts.Accounts.Model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommonResponseModel {

    private String status_code;
    private String status_message;
}
