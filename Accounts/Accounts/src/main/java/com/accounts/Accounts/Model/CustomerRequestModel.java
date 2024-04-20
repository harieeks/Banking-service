package com.accounts.Accounts.Model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerRequestModel {

    @NotNull(message = "Name is required")
    @Size(min = 2,message = "Name should be minimum 3 characters")
    private String name;

    @NotNull(message = "Email is required")
    @Email(message = "Invalid email")
    private String email;

    @NotNull(message = "Phone number is required")
    @Pattern(regexp = "(^$|[0-9]{10})",message = "Mobile number must be 10 digits")
    private String phoneNo;

    @NotNull(message = "Address is required")
    private String address;
}
