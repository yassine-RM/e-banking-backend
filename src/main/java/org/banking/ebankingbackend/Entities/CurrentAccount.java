package org.banking.ebankingbackend.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor @AllArgsConstructor
@Table(name = "current_accounts")
@Entity
public class CurrentAccount extends Account {

    private String overDraft;

    @OneToOne
    private Account account;
}
