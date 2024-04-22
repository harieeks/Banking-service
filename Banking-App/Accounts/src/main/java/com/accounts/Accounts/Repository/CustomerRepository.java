package com.accounts.Accounts.Repository;

import com.accounts.Accounts.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
