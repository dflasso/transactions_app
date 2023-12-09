package io.github.dflasso.transactions.services;

import io.github.dflasso.transactions.models.dtos.BankAccountSummaryDTO;
import io.github.dflasso.transactions.models.dtos.PersonSummaryDTO;
import io.github.dflasso.transactions.models.dtos.ResponseDTO;

import java.util.ArrayList;
import java.util.Set;

/**
 * Handle request of API /transaction/{codePerson}/{typePerson}/by-code-and-type-person
 */
public interface IHandlerGetTransactionsByCodeAndTypePerson {

    public ResponseDTO<PersonSummaryDTO, Set<BankAccountSummaryDTO>> execute(String codePerson, String typePerson);
}
