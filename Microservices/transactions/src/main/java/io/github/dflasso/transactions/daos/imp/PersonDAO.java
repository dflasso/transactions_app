package io.github.dflasso.transactions.daos.imp;

import io.github.dflasso.transactions.daos.IPersonDAO;
import io.github.dflasso.transactions.exceptions.NotFoundException;
import io.github.dflasso.transactions.models.constants.AppErrorsCodesAndMessages;
import io.github.dflasso.transactions.models.constants.PersonTypes;
import io.github.dflasso.transactions.models.dtos.ApiError;
import io.github.dflasso.transactions.models.entities.PersonEntity;
import io.github.dflasso.transactions.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Stream;

@Service
@Primary
public class PersonDAO implements IPersonDAO {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public PersonEntity findByCodeAndType(String code, String type) {
        PersonTypes personType = this.getType(type);

        Optional<PersonEntity> person = personRepository.findByCodeAndType(code, personType);

        if(person.isEmpty()){
            ApiError error = new ApiError(HttpStatus.NOT_FOUND, AppErrorsCodesAndMessages.PERSON_NOT_FOUND);
            throw new NotFoundException(error);
        }

        return person.get();
    }

    @Override
    public PersonTypes getType(String type) {
        return Stream.of(PersonTypes.values())
                .filter(c -> c.getCode().equals(type))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
