package org.banking.ebankingbackend.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.banking.ebankingbackend.Enums.AccountStatus;

import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor @AllArgsConstructor
@Table(name = "accounts")
@Inheritance(strategy = InheritanceType.JOINED)

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date createdAt;
    private Double balance;

    @Enumerated(EnumType.STRING)
    private AccountStatus status;
    private String currency;

    @ManyToOne
    private Customer customer;

    @OneToMany(mappedBy = "account")
    private List<Operation> operations;

    @OneToOne(mappedBy = "account")
    private SavingAccount savingAccount;

    @OneToOne(mappedBy = "account")
    private CurrentAccount currentAccount;
}
