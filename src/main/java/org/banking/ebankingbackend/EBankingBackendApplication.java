package org.banking.ebankingbackend;

import org.banking.ebankingbackend.Entities.*;
import org.banking.ebankingbackend.Enums.AccountStatus;
import org.banking.ebankingbackend.Enums.OperationType;
import org.banking.ebankingbackend.Repositories.*;
import org.banking.ebankingbackend.Services.IBankServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class EBankingBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(EBankingBackendApplication.class, args);
    }

    @Bean
    CommandLineRunner start(
            IBankServiceImpl bankService
    ){
        return args -> bankService.addNewCustomer(null);
    }
//    @Bean
    CommandLineRunner runner(
            CustomerRepository customerRepository,
            AccountRepository accountRepository,
            OperationRepository operationRepository
    ){
        return args -> {
            Stream.of("Yassine","Kamal","Aicha")
                    .forEach(name -> {
                                Customer customer = new Customer();
                                customer.setFirstName(name);
                                customer.setLastName("lastname");
                                customer.setEmail(name + "@gmail.com");
                                customer.setPhoneNumber("0690000000");
                                customerRepository.save(customer);
                    });
                customerRepository.findAll().forEach(customer -> {
                    Date currentDate = new Date();

                    CurrentAccount currentAccount = new CurrentAccount();
                    currentAccount.setOverDraft(1000.0);
                    currentAccount.setCreatedAt(currentDate);
                    currentAccount.setBalance(Math.random() * 10000);
                    currentAccount.setStatus(Math.random() > .5 ? AccountStatus.ACTIVE : AccountStatus.CLOSED);
                    currentAccount.setCurrency("USD");
                    currentAccount.setCustomer(customer);
                    accountRepository.save(currentAccount);

                    SavingAccount savingAccount = new SavingAccount();
                    savingAccount.setInterestRate(3.5);
                    savingAccount.setCreatedAt(currentDate);
                    savingAccount.setBalance(Math.random() * 10000);
                    savingAccount.setStatus(Math.random() > .5 ? AccountStatus.ACTIVE : AccountStatus.CLOSED);
                    savingAccount.setCurrency("USD");
                    savingAccount.setCustomer(customer);
                    accountRepository.save(savingAccount);
                });

                accountRepository.findAll().forEach(acc ->{
                    for (int i = 0; i < 5; i++) {
                        Operation operation = new Operation();
                        operation.setCreatedAt(new java.util.Date());
                        operation.setAmount(Math.random() * 1000);
                        operation.setType(Math.random() > .5 ? OperationType.DEPOSIT : OperationType.WITHDRAWAL);
                        operation.setAccount(acc);
                        operationRepository.save(operation);
                    }

                });

        };
    }
}
