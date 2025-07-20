package org.banking.ebankingbackend.Repositories;

import org.banking.ebankingbackend.Entities.CurrentAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrentAccountRepository extends JpaRepository<CurrentAccount, Long> {
}
