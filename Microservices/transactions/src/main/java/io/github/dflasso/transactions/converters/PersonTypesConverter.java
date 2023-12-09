package io.github.dflasso.transactions.converters;

import io.github.dflasso.transactions.models.constants.PersonTypes;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class PersonTypesConverter implements AttributeConverter<PersonTypes, String> {
    @Override
    public String convertToDatabaseColumn(PersonTypes personTypes) {
        if(personTypes == null)
            return null;

        return  personTypes.getCode();
    }

    @Override
    public PersonTypes convertToEntityAttribute(String code) {
        if(code == null)
            return null;

        return Stream.of(PersonTypes.values())
                .filter(c -> c.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
