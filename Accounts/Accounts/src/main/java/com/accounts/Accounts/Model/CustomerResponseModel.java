package com.accounts.Accounts.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class CustomerResponseModel {

    @JsonProperty(value = "customer_id")
    private Long customerId;

    private String name;

    private String email;

    @JsonProperty(value = "phone_number")
    private String phoneNo;

    private String address;

    @JsonProperty(value = "created_at")
    private LocalDateTime createdAt;

    @JsonProperty(value = "created_by")
    private String createdBy;

}
