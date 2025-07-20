package org.banking.ebankingbackend.Services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.banking.ebankingbackend.Entities.Account;
import org.banking.ebankingbackend.Entities.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class IBankServiceImpl implements IBankService {

//    private static final Logger log = LoggerFactory.getLogger(IBankServiceImpl.class); == @Slf4j

    @Override
    public Customer addNewCustomer(Customer customer) {
        log.info("Adding new customer");
        return null;
    }

    @Override
    public Account addNewAccount() {
        return null;
    }
}
