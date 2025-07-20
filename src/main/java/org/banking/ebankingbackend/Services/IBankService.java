package org.banking.ebankingbackend.Services;

import org.banking.ebankingbackend.Entities.Account;
import org.banking.ebankingbackend.Entities.Customer;

public interface IBankService {

    Customer addNewCustomer(Customer customer);
    Account addNewAccount();
}
