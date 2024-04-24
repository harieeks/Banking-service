package com.loans.Loans.Model;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoansRequestModel {


    @NotNull(message = "Loan number is required")
    private String loanNo;

    @NotNull(message = "Loan type is required")
    private String loanType;

    @Positive(message = "Total loan should be greater than zero")
    private Integer totalLoan;

    @PositiveOrZero(message = "Total Amount paid should be greater than or equal to zero")
    private Integer amountPaid;

    @PositiveOrZero(message = "Total outstanding should be greater than or equal to zero")
    private Integer outStandingAmount;

    @NotNull(message = "Phone number is required")
    @Pattern(regexp = "(^$|[0-9]{10})",message = "Mobile number must be 10 digits")
    private String phoneNo;
}
