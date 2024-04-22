package com.accounts.Accounts.Service.Impl;

import com.accounts.Accounts.Constants.AccountConstants;
import com.accounts.Accounts.Entity.Account;
import com.accounts.Accounts.Entity.Customer;
import com.accounts.Accounts.Exception.CustomerNotFoundException;
import com.accounts.Accounts.Model.CustomerRequestModel;
import com.accounts.Accounts.Model.CustomerResponseModel;
import com.accounts.Accounts.Model.UpdateCustomerRequestModel;
import com.accounts.Accounts.Repository.AccountsRepository;
import com.accounts.Accounts.Repository.CustomerRepository;
import com.accounts.Accounts.Service.iAccount;
import com.accounts.Accounts.Service.iCustomer;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class iCustomerImplementation implements iCustomer {

    private ModelMapper modelMapper;
    private CustomerRepository customerRepository;
    private AccountsRepository accountsRepository;

    @Override
    @Transactional
    public void createNewCustomer(CustomerRequestModel model) {
       Customer newCustomer= customerRepository.save(modelMapper.map(model, Customer.class));
       accountsRepository.save(createCustomerAccount(newCustomer));
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

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public CustomerResponseModel updateCustomerDetails(
            UpdateCustomerRequestModel customerRequestModel
    ) {
        System.out.println(customerRequestModel.getAddress()+" "+customerRequestModel.getPhoneNo());

        Optional<Customer> customer=customerRepository.findById(customerRequestModel.getId());
        if(customer.isEmpty()) throw new CustomerNotFoundException("Customer not found for id "+customerRequestModel.getId());
        var updatedCustomer=customer.get();
        updatedCustomer.setAddress(setValue(customerRequestModel.getAddress(),updatedCustomer.getAddress()));
        updatedCustomer.setPhoneNo(setValue(customerRequestModel.getPhoneNo(),updatedCustomer.getPhoneNo()));
        customerRepository.save(updatedCustomer);

        return modelMapper.map(updatedCustomer,CustomerResponseModel.class);
    }

    private String setValue(String newValue,String oldValue){
        if(newValue != null)return newValue;
        else return  oldValue;
    }
}
