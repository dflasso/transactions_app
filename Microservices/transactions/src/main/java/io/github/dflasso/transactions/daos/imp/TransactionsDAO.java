package io.github.dflasso.transactions.daos.imp;

import io.github.dflasso.transactions.daos.ITransactionDAO;
import io.github.dflasso.transactions.models.dtos.PersonSummaryDTO;
import io.github.dflasso.transactions.models.dtos.ResponseDTO;
import io.github.dflasso.transactions.models.dtos.TransactionDTO;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Implementation of ITransactionDAO
 * @version 1.0
 * @author dany lasso
 */
@Service
@Primary
public class TransactionsDAO  implements ITransactionDAO {

    @Override
    public ResponseDTO<PersonSummaryDTO, ArrayList<TransactionDTO>> getTransactionsByCodeAndTypePerson(String idPerson, String typePerson) {
        ResponseDTO<PersonSummaryDTO, ArrayList<TransactionDTO>> response = new ResponseDTO<PersonSummaryDTO, ArrayList<TransactionDTO>>();

        return response;
    }
}
