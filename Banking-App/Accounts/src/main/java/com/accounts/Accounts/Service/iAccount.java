package com.accounts.Accounts.Service;

import com.accounts.Accounts.Entity.Account;
import com.accounts.Accounts.Entity.Customer;
import com.accounts.Accounts.Model.AccountResponseModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface iAccount {

    void createAccount(Customer customer);

    AccountResponseModel findCustomerAccount(Long id);
    Page<AccountResponseModel> findAllCustomerAccount(Pageable pageable);
    void deleteAccountById(Long id);
}
