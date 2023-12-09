package io.github.dflasso.transactions.repositories;

import io.github.dflasso.transactions.models.entities.BankExternalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankExternalRepository extends JpaRepository<BankExternalEntity, Long> {
}
