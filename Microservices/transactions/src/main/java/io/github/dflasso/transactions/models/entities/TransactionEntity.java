package io.github.dflasso.transactions.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude= {"bankAccountOrigin", "bankAccountDestiny"})
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transactions")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "bank_account_origin", referencedColumnName = "bank_account_num")
    private BankAccountEntity bankAccountOrigin;

    @ManyToOne
    @JoinColumn(name = "bank_account_destiny", referencedColumnName = "bank_account_num")
    private BankAccountEntity bankAccountDestiny;

    @Column(name = "tr_description", length = 10000)
    private String description;

    @Column(name = "tr_amount", updatable = false)
    private Double amount;

    @Column(name = "tr_iva", updatable = false)
    private Double iva;

    @Column(name = "tr_commission", updatable = false )
    private Double commission;

    @Column(name = "pr_created_date", nullable = false, updatable = false)
    @CreatedDate
    @DateTimeFormat(pattern="yyyy-MM-dd-HH.mm.ss")
    private LocalDateTime createdDate;

    @PrePersist
    public void prePersistAuditEvent() {
        this.createdDate = LocalDateTime.now();
    }
}
