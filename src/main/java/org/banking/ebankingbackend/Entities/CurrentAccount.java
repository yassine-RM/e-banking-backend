package org.banking.ebankingbackend.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data @NoArgsConstructor @AllArgsConstructor
//@DiscriminatorValue("CURRENT")
public class CurrentAccount extends Account {
    private Double overDraft;
}
