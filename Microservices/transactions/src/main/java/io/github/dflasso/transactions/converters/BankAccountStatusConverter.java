package io.github.dflasso.transactions.converters;

import io.github.dflasso.transactions.models.constants.BankAccountStatus;
import io.github.dflasso.transactions.models.constants.PersonTypes;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class BankAccountStatusConverter implements AttributeConverter<BankAccountStatus, String> {
    @Override
    public String convertToDatabaseColumn(BankAccountStatus status) {
        if(status == null)
            return null;

        return  status.getCode();
    }

    @Override
    public BankAccountStatus convertToEntityAttribute(String code) {
        if(code == null)
            return null;

        return Stream.of(BankAccountStatus.values())
                .filter(c -> c.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
