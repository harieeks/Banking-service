package com.accounts.Accounts.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class UpdateCustomerRequestModel {

    private Long id;
    @JsonProperty(value = "address")
    private String address;
    @JsonProperty(value = "phone_no")
    private String phoneNo;
}
