package io.github.dflasso.transactions.services.imp;

import io.github.dflasso.transactions.daos.IPersonDAO;
import io.github.dflasso.transactions.models.dtos.BankAccountSummaryDTO;
import io.github.dflasso.transactions.models.dtos.PersonSummaryDTO;
import io.github.dflasso.transactions.models.dtos.ResponseDTO;
import io.github.dflasso.transactions.models.dtos.TransactionDTO;
import io.github.dflasso.transactions.models.entities.BankAccountEntity;
import io.github.dflasso.transactions.models.entities.PersonEntity;
import io.github.dflasso.transactions.services.IHandlerGetTransactionsByCodeAndTypePerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Set;

@Service
@Primary
public class HandlerGetTransactionsByCodeAndTypePerson implements IHandlerGetTransactionsByCodeAndTypePerson {

    @Autowired
    private IPersonDAO personDAO;

    @Override
    public ResponseDTO<PersonSummaryDTO, Set<BankAccountSummaryDTO>> execute(String codePerson, String typePerson) {
        PersonEntity personEntity = personDAO.findByCodeAndType(codePerson, typePerson);

        PersonSummaryDTO header = new PersonSummaryDTO();
        header.buildFromPersonEntity(personEntity);

        Set<BankAccountEntity> bankAccounts = personEntity.getBankAccounts();
        Set<BankAccountSummaryDTO> payload = BankAccountSummaryDTO.buildFromBankAccountEntities(bankAccounts);

        ResponseDTO<PersonSummaryDTO, Set<BankAccountSummaryDTO>> response = new ResponseDTO<PersonSummaryDTO, Set<BankAccountSummaryDTO>>();
        response.setHeader(header);
        response.setPayload(payload);


        return response;
    }
}
