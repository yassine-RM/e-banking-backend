package org.banking.ebankingbackend;

import org.banking.ebankingbackend.Entities.Account;
import org.banking.ebankingbackend.Entities.Customer;
import org.banking.ebankingbackend.Entities.Operation;
import org.banking.ebankingbackend.Entities.SavingAccount;
import org.banking.ebankingbackend.Enums.AccountStatus;
import org.banking.ebankingbackend.Enums.OperationType;
import org.banking.ebankingbackend.Repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class EBankingBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(EBankingBackendApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(
            CustomerRepository customerRepository,
            AccountRepository accountRepository,
            OperationRepository operationRepository,
            SavingAccountRepository savingAccountRepository,
            CurrentAccountRepository currentAccountRepository
    ){
        return args -> {

            Stream.of("Yassine","Kamal","Aicha")
                    .forEach(name -> {
                        Customer customer = new Customer();
                        customer.setFirstName(name);
                        customer.setLastName("lastname");
                        customer.setEmail(name+"@gmail.com");
                        customer.setPhoneNumber("0690000000");
                        customerRepository.save(customer);

                        Account account = new Account();
                        account.setCustomer(customer);
                        account.setBalance(1000000.0);
                        account.setCurrency("DH");
                        account.setStatus(AccountStatus.ACTIVE);
                        account.setCreatedAt(new java.util.Date());
                        accountRepository.save(account);

                        SavingAccount savingAccount = new SavingAccount();
                        savingAccount.setInterestRate(12);
                        savingAccount.setAccount(account);
                        savingAccountRepository.save(savingAccount);

                        Operation operation = new Operation();
                        operation.setCreatedAt(new java.util.Date());
                        operation.setAmount(100.0);
                        operation.setType(OperationType.DEPOSIT);
                        operation.setAccount(account);
                        operationRepository.save(operation);

                    });
        };
    }
}
