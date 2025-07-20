package org.banking.ebankingbackend.Repositories;

import org.banking.ebankingbackend.Entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
