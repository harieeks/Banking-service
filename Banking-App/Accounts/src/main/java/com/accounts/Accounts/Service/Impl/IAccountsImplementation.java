package com.accounts.Accounts.Service.Impl;

import com.accounts.Accounts.Constants.AccountConstants;
import com.accounts.Accounts.Entity.Account;
import com.accounts.Accounts.Entity.Customer;
import com.accounts.Accounts.Exception.CustomerNotFoundException;
import com.accounts.Accounts.Model.AccountResponseModel;
import com.accounts.Accounts.Repository.AccountsRepository;
import com.accounts.Accounts.Service.iAccount;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class IAccountsImplementation implements iAccount {

    private AccountsRepository accountsRepository;
    private iCustomerImplementation customerService;
    @Override
    @Transactional
    public void createAccount(Customer customer) {
        accountsRepository.save(createCustomerAccount(customer));
    }

    @Override
    public AccountResponseModel findCustomerAccount(Long customerId) {

        Optional<Customer> optionalCustomer=customerService.findById(customerId);
        if(optionalCustomer.isEmpty())throw new CustomerNotFoundException("Customer not found for id "+customerId);
        else {
            Account account=accountsRepository.findByCustomerId(customerId).get();
            return mapToAccountResponseModel(account);
        }
    }

    @Override
    public Page<AccountResponseModel> findAllCustomerAccount(Pageable pageable) {

        Page<Account> account=accountsRepository.findAllByIsDeletedFalse(pageable);
        return account.map(this::mapToAccountResponseModel);
    }

    @Override
    public void deleteAccountById(Long id) {

        Optional<Customer> optionalCustomer=customerService.findById(id);
        if(optionalCustomer.isEmpty())throw new CustomerNotFoundException("Customer not found for id "+id);
        else {
            Account account=accountsRepository.findByCustomerId(id).get();
            account.setDeleted(true);
            accountsRepository.save(account);
        }
    }

    private AccountResponseModel mapToAccountResponseModel(Account account){
        return AccountResponseModel.builder()
                 .createdAt(account.getCreatedAt())
                 .createdBy(account.getCreatedBy())
                 .accountType(account.getAccountType())
                 .accountNo(account.getAccountNo())
                 .customer(account.getCustomer())
                 .build();
    }

    private Account createCustomerAccount(Customer customer){

        Random random=new Random();
        int accNo=random.nextInt(900000)+100000;
        return Account.builder()
                .accountType(AccountConstants.SAVINGS)
                .customer(customer)
                .accountNo(Integer.toString(accNo))
                .build();
    }
}
