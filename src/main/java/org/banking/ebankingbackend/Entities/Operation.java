package org.banking.ebankingbackend.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.banking.ebankingbackend.Enums.OperationType;

import java.util.Date;


@Data
@NoArgsConstructor @AllArgsConstructor
@Entity
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date createdAt;
    private Double amount;
    @Enumerated(EnumType.STRING)
    private OperationType type;

    @ManyToOne
    private Account account;
}
