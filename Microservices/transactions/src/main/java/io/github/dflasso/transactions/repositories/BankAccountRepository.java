package io.github.dflasso.transactions.repositories;

import io.github.dflasso.transactions.models.entities.BankAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccountEntity, String> {
}
