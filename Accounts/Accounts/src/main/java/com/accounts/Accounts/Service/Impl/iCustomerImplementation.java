package com.accounts.Accounts.Service.Impl;

import com.accounts.Accounts.Entity.Customer;
import com.accounts.Accounts.Model.CustomerRequestModel;
import com.accounts.Accounts.Repository.CustomerRepository;
import com.accounts.Accounts.Service.iCustomer;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class iCustomerImplementation implements iCustomer {

    private ModelMapper modelMapper;
    private CustomerRepository customerRepository;

    @Override
    @Transactional
    public void createNewCustomer(CustomerRequestModel model) {
        customerRepository.save(modelMapper.map(model, Customer.class));
    }
}
