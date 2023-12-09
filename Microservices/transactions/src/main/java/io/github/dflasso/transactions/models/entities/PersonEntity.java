package io.github.dflasso.transactions.models.entities;

import io.github.dflasso.transactions.models.constants.PersonTypes;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "persons")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonEntity {

    @Id
    @Column(name = "pr_code")
    private String code;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_employee", referencedColumnName = "id_employee")
    private EmployeeEntity employee;

    @OneToMany(mappedBy = "person")
    private Set<BankAccountEntity> bankAccounts;

    @Column(name = "pr_names", length = 400, nullable = false)
    private String names;

    @Column(name = "pr_lastnames", length = 400, nullable = false)
    private String lastnames;

    @Column(name = "pr_created_date", nullable = false, updatable = false)
    @CreatedDate
    @DateTimeFormat(pattern="yyyy-MM-dd-HH.mm.ss")
    private LocalDateTime createdDate;

    @Column(name = "pr_modified_date")
    @LastModifiedDate
    private LocalDateTime modifiedDate;

    @Column(name = "pr_birthday")
    private LocalDate birthday;

    @Column(name = "pr_type")
    private PersonTypes type;

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
