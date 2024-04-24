package com.loans.Loans.Service.Impl;

import com.loans.Loans.Constants.LoanConstants;
import com.loans.Loans.Entity.Loans;
import com.loans.Loans.Exception.LoanAlreadyExistException;
import com.loans.Loans.Model.LoansRequestModel;
import com.loans.Loans.Model.LoansResponseModel;
import com.loans.Loans.Repository.LoansRepository;
import com.loans.Loans.Service.ILoanService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class LoanServiceImpl implements ILoanService {

    private LoansRepository loansRepository;
    @Override
    public void createLoan(String mobileNo) {

        Optional<Loans> currentLoans=loansRepository.findByPhoneNo(mobileNo);
        if(currentLoans.isPresent())throw new LoanAlreadyExistException("Loan is not available for this number");
        createNewLoan(mobileNo);
    }
    private void createNewLoan(String phoneNo){
        Random random=new Random();
        int loanNo= random.nextInt(9000000)+1000000;

        Loans loans=new Loans();
        loans.setLoanType(LoanConstants.HOME_LOANS);
        loans.setLoanNo(Integer.toString(loanNo));
        loans.setPhoneNo(phoneNo);
        loans.setTotalLoan(1000000);
        loans.setAmountPaid(0);
        loans.setOutStandingAmount(10000);
        loansRepository.save(loans);
    }

    @Override
    public void updateLoan(LoansRequestModel loansRequest) {

    }

    @Override
    public LoansResponseModel fetchLoans(String mobileNo) {
        return null;
    }

    @Override
    public void deleteLoan(String mobileNo) {

    }
}
