package org.banking.ebankingbackend.Repositories;

import org.banking.ebankingbackend.Entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
