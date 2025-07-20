package org.banking.ebankingbackend.Repositories;

import org.banking.ebankingbackend.Entities.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepository extends JpaRepository<Operation, Long> {
}
