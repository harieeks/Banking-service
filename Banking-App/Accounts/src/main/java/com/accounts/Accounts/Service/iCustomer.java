package com.accounts.Accounts.Service;

import com.accounts.Accounts.Entity.Customer;
import com.accounts.Accounts.Model.CustomerRequestModel;
import com.accounts.Accounts.Model.CustomerResponseModel;
import com.accounts.Accounts.Model.UpdateCustomerRequestModel;

import java.util.Optional;

public interface iCustomer {

    void createNewCustomer(CustomerRequestModel model);
    Optional<Customer> findById(Long id);

    CustomerResponseModel updateCustomerDetails(UpdateCustomerRequestModel customerRequestModel);
}
