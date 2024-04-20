package com.accounts.Accounts.Repository;

import com.accounts.Accounts.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountsRepository extends JpaRepository<Account,Long> {
}
