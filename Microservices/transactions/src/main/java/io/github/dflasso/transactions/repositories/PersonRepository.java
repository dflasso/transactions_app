package io.github.dflasso.transactions.repositories;

import io.github.dflasso.transactions.models.constants.PersonTypes;
import io.github.dflasso.transactions.models.entities.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, String> {

    public Optional<PersonEntity> findByCodeAndType(String code, PersonTypes type);
}
