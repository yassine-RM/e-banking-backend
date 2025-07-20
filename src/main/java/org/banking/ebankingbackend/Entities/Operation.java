package org.banking.ebankingbackend.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.banking.ebankingbackend.Enums.OperationType;

import java.util.Date;


@Data
@NoArgsConstructor @AllArgsConstructor
@Table(name = "operations")
@Entity
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date createdAt;
    private Double amount;
    private OperationType type;

    @ManyToOne
    private Account account;
}
