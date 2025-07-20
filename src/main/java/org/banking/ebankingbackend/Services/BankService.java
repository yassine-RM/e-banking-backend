package org.banking.ebankingbackend.Services;

import lombok.AllArgsConstructor;
import org.banking.ebankingbackend.Repositories.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class BankService {

    private AccountRepository accountRepository;

    public void consultAccountOperations(){
        accountRepository.findById(1L).ifPresent(account -> account.getOperations().forEach(operation ->
                System.out.println("Type => " + operation.getType() + " Amount => " + operation.getAmount())
        ));
    }
}
