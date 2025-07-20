package org.banking.ebankingbackend.Repositories;

import org.banking.ebankingbackend.Entities.SavingAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SavingAccountRepository extends JpaRepository<SavingAccount, Long> {
}
