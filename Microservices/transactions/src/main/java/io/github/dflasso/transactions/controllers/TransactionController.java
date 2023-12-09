package io.github.dflasso.transactions.controllers;

import io.github.dflasso.transactions.daos.imp.TransactionsDAO;
import io.github.dflasso.transactions.models.dtos.BankAccountSummaryDTO;
import io.github.dflasso.transactions.models.dtos.PersonSummaryDTO;
import io.github.dflasso.transactions.models.dtos.ResponseDTO;
import io.github.dflasso.transactions.models.dtos.TransactionDTO;
import io.github.dflasso.transactions.services.IHandlerGetTransactionsByCodeAndTypePerson;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Set;

@Tag(name = "Transaction")
@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private IHandlerGetTransactionsByCodeAndTypePerson handlerGetTransactionsByCodeAndTypePerson;

    @GetMapping("/{codePerson}/{typePerson}/by-code-and-type-person")
    @ResponseBody
    public ResponseDTO<PersonSummaryDTO, Set<BankAccountSummaryDTO>> getTransactionsByCodePerson(@PathVariable String codePerson, @PathVariable String typePerson){

        return handlerGetTransactionsByCodeAndTypePerson.execute(codePerson, typePerson);
    }
}
