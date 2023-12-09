package io.github.dflasso.transactions.models.constants;

public enum PersonTypes {
    CLIENT("CLIENTE"),
    EMPLOYEE("EMPLEADO");

    private String code;

    PersonTypes(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
