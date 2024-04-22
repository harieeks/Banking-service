package com.accounts.Accounts.Model;

import com.accounts.Accounts.Entity.Customer;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
public class AccountResponseModel {

    private String accountNo;

    private Customer customer;

    private String accountType;

    @JsonProperty(value = "created_at")
    private LocalDateTime createdAt;

    @JsonProperty(value = "created_by")
    private String createdBy;

}
