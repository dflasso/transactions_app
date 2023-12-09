package io.github.dflasso.transactions.models.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum BankAccountStatus {
    ACTIVE("ACTIVA"),
    DISABLE("CERRADA");

    private String code;
}
