package io.github.dflasso.transactions.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "bank_external")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude="bankAccounts")
public class BankExternalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bank_external")
    private Long id;

    @Column(name = "be_name", length = 400, nullable = false)
    private String name;

    @Column(name = "be_logo", length = 10000)
    private String logo;

    @OneToMany(mappedBy = "bankExternal")
    private Set<BankAccountEntity> bankAccounts;
}
