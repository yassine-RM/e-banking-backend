
package org.banking.ebankingbackend.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
//@DiscriminatorValue("SAVING")

public class SavingAccount extends Account {
    private Double interestRate;
}