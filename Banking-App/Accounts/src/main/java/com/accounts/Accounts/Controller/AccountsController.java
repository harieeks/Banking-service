package com.accounts.Accounts.Controller;

import com.accounts.Accounts.Constants.AccountConstants;
import com.accounts.Accounts.Model.AccountResponseModel;
import com.accounts.Accounts.Model.CommonResponseModel;
import com.accounts.Accounts.Service.Impl.IAccountsImplementation;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts/v1")
@AllArgsConstructor
public class AccountsController {

    private IAccountsImplementation accountService;
    @GetMapping("/{id}")
    public ResponseEntity<AccountResponseModel> getCustomerAccount(@PathVariable("id")Long id){

        var responseModel=accountService.findCustomerAccount(id);
        return ResponseEntity.ok().body(responseModel);
    }

    @GetMapping("/list")
    public ResponseEntity<Page<AccountResponseModel>> getAllCustomerAccounts(Pageable pageable){

        Page<AccountResponseModel> responseModel=accountService.findAllCustomerAccount(pageable);
        return ResponseEntity.ok()
                .body(responseModel);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<CommonResponseModel> deleteAccount(@PathVariable("id")Long id){

        accountService.deleteAccountById(id);
        return ResponseEntity.ok()
                .body(
                        CommonResponseModel.builder()
                                .status_code(AccountConstants.STATUS_200)
                                .status_message(AccountConstants.DELETE_MESSAGE)
                                .build()
                );
    }
}
