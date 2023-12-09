package io.github.dflasso.transactions.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude="person")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_employee")
    private Long id;

    @OneToOne(mappedBy = "employee")
    private PersonEntity person;

    @Column(name = "em_work_position", length = 400, nullable = false)
    private String workPosition;

    @Column(name = "em_admission_date", nullable = false, updatable = false)
    @CreatedDate
    @DateTimeFormat(pattern="yyyy-MM-dd-HH.mm.ss")
    private LocalDateTime admissionDate;

    @Column(name = "em_leaving_date", updatable = false)
    @CreatedDate
    @DateTimeFormat(pattern="yyyy-MM-dd-HH.mm.ss")
    private LocalDateTime leavingDate;

    @Column(name = "em_created_date", nullable = false, updatable = false)
    @CreatedDate
    @DateTimeFormat(pattern="yyyy-MM-dd-HH.mm.ss")
    private LocalDateTime createdDate;

    @Column(name = "em_modified_date")
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
