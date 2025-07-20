package org.banking.ebankingbackend.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor @AllArgsConstructor
@Table(name = "saving_accounts")
@Entity
public class SavingAccount extends Account {

    private Integer interestRate;

    @OneToOne
    private Account account;
}
