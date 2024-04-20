package com.accounts.Accounts.Exception;

public class CustomerNotFoundException extends RuntimeException{

    public CustomerNotFoundException(String error){
        super(error);
    }
}
