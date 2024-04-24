package com.accounts.Accounts.Controller;

import com.accounts.Accounts.Constants.AccountConstants;
import com.accounts.Accounts.Model.CommonResponseModel;
import com.accounts.Accounts.Model.CustomerRequestModel;
import com.accounts.Accounts.Model.CustomerResponseModel;
import com.accounts.Accounts.Model.UpdateCustomerRequestModel;
import com.accounts.Accounts.Service.Impl.iCustomerImplementation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts/v1")
@AllArgsConstructor
public class CustomerController {

    private iCustomerImplementation customerService;

    @PostMapping("/create")
    public ResponseEntity<CommonResponseModel> createCustomer(@Valid @RequestBody CustomerRequestModel model){
        customerService.createNewCustomer(model);
        return ResponseEntity
                .ok()
                .body(
                        CommonResponseModel.builder()
                        .status_code(AccountConstants.STATUS_200)
                        .status_message(AccountConstants.MESSAGE_201)
                        .build()
                );
    }

    @PutMapping("/update")
    public ResponseEntity<CustomerResponseModel> updateCustomerData(@RequestBody UpdateCustomerRequestModel customerRequestModel
    ){
        System.out.println(customerRequestModel.getAddress());
        var response= customerService.updateCustomerDetails(customerRequestModel);
        return ResponseEntity.ok()
                .body(response);
    }
}
