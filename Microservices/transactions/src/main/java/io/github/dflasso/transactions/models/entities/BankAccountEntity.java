package io.github.dflasso.transactions.models.entities;

import io.github.dflasso.transactions.models.constants.BankAccountStatus;
import io.github.dflasso.transactions.models.constants.BankAccountTypes;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "bank_account")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude="person")
public class BankAccountEntity {

    @Id
    @Column(name = "bank_account_num")
    private String account_number;

    @Column(name = "ba_status")
    private BankAccountStatus status;

    @Column(name = "ba_type")
    private BankAccountTypes type;

    @Column(name = "ba_is_external")
    private Boolean isExternal;

    @ManyToOne
    @JoinColumn(name="person_code", referencedColumnName = "pr_code")
    private PersonEntity person;

    @ManyToOne
    @JoinColumn(name="id_bank_external", referencedColumnName = "id_bank_external")
    private BankExternalEntity bankExternal;

    @OneToMany(mappedBy = "bankAccountDestiny")
    private Set<TransactionEntity> trxsAccredited;

    @OneToMany(mappedBy = "bankAccountOrigin")
    private Set<TransactionEntity> trxsDebited;

    @Column(name = "ba_created_date", nullable = false, updatable = false)
    @CreatedDate
    @DateTimeFormat(pattern="yyyy-MM-dd-HH.mm.ss")
    private LocalDateTime createdDate;

    @Column(name = "ba_modified_date")
    @LastModifiedDate
    private LocalDateTime modifiedDate;

    @PrePersist
    public void prePersistAuditEvent() {
        this.createdDate = LocalDateTime.now();
        this.modifiedDate = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdateAuditEvent() {
        this.modifiedDate = LocalDateTime.now();
    }
}
