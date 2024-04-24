package com.loans.Loans.Model;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoansResponseModel {

    private String phoneNo;

    private String loanNo;

    private String loanType;

    private Integer totalLoan;

    private Integer amountPaid;

    private Integer outStandingAmount;
}
