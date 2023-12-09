package io.github.dflasso.transactions.converters;

import io.github.dflasso.transactions.models.constants.BankAccountStatus;
import io.github.dflasso.transactions.models.constants.BankAccountTypes;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class BankAccountTypesConverter implements AttributeConverter<BankAccountTypes, String> {
    @Override
    public String convertToDatabaseColumn(BankAccountTypes type) {
        if(type == null)
            return null;

        return  type.getCode();
    }

    @Override
    public BankAccountTypes convertToEntityAttribute(String code) {
        if(code == null)
            return null;

        return Stream.of(BankAccountTypes.values())
                .filter(c -> c.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
