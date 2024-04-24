package com.loans.Loans.Service;

import com.loans.Loans.Model.LoansRequestModel;
import com.loans.Loans.Model.LoansResponseModel;

public interface ILoanService {

    void createLoan(String mobileNo);

    void updateLoan(LoansRequestModel loansRequest);

    LoansResponseModel fetchLoans(String mobileNo);

    void deleteLoan(String mobileNo);
}
