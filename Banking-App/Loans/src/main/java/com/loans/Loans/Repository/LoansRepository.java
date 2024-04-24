package com.loans.Loans.Repository;

import com.loans.Loans.Entity.Loans;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoansRepository extends JpaRepository<Loans,Long> {

    Optional<Loans> findByPhoneNo(String phoneNumber);
}
