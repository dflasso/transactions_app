package io.github.dflasso.transactions.daos;

import io.github.dflasso.transactions.models.dtos.PersonSummaryDTO;
import io.github.dflasso.transactions.models.dtos.ResponseDTO;
import io.github.dflasso.transactions.models.dtos.TransactionDTO;

import java.util.ArrayList;

/**
 * interfaces with all methods of transactions
 */
public interface ITransactionDAO {
    public ResponseDTO<PersonSummaryDTO, ArrayList<TransactionDTO>> getTransactionsByCodeAndTypePerson(String idPerson, String typePerson);
}
