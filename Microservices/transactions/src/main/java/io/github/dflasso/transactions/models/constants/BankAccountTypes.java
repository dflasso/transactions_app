package io.github.dflasso.transactions.models.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum BankAccountTypes {
    SAVING("AHORROS"),
    CURRENT("CORRIENTE");

    private String code;
}
