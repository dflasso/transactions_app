package io.github.dflasso.transactions.daos;

import io.github.dflasso.transactions.exceptions.NotFoundException;
import io.github.dflasso.transactions.models.constants.PersonTypes;
import io.github.dflasso.transactions.models.entities.PersonEntity;

/**
 * Implements all logic to handle data of person table
 */
public interface IPersonDAO {

    /**
     *
     * @param code of person
     * @param type of person
     * @return data of Person
     * @throws NotFoundException if person wasn't found
     */
    public PersonEntity findByCodeAndType(String code, String type);

    /**
     *
     * @param type of person as string
     * @return PersonType value of enum
     */
    public PersonTypes getType(String type);
}
