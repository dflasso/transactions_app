package io.github.dflasso.transactions.models.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AppErrorsCodesAndMessages {
    FIELD_VALIDATION("U0001", "Field validation"),
    PERSON_NOT_FOUND("D001", "PERSON WASN'T FOUND");

    private String code;
    private String message;
}
