package com.loans.Loans.Controller;

import com.loans.Loans.Constants.LoanConstants;
import com.loans.Loans.Model.CommonResponseModel;
import com.loans.Loans.Model.LoansRequestModel;
import com.loans.Loans.Service.Impl.LoanServiceImpl;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/loans/v1")
@AllArgsConstructor
@Validated
public class LoansController {

    private LoanServiceImpl loanService;

    @PostMapping("/create")
    public ResponseEntity<CommonResponseModel> createLoan(
            @RequestBody Map<String,String> map
    ){
        loanService.createLoan(map.get("phone_no"));
        return ResponseEntity.ok()
                .body(CommonResponseModel.builder()
                        .status_code(LoanConstants.STATUS_200)
                        .message(LoanConstants.MESSAGE_200)
                        .build()
                );
    }
}
