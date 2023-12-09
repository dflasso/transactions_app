package io.github.dflasso.transactions.models.dtos;

import io.github.dflasso.transactions.models.entities.BankAccountEntity;
import io.github.dflasso.transactions.models.entities.TransactionEntity;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class BankAccountSummaryDTO {

    private String bankAccount;

    private LocalDateTime creationDateAccount;

    private List<TransactionDTO> transactions;

    public static Set<BankAccountSummaryDTO> buildFromBankAccountEntities(Set<BankAccountEntity> entities){
        return entities.stream().map( bankAccountEntity -> {
            BankAccountSummaryDTO bankAccountDTO = new BankAccountSummaryDTO();

            bankAccountDTO.setBankAccount(bankAccountEntity.getAccount_number());
            bankAccountDTO.setCreationDateAccount(bankAccountEntity.getCreatedDate());

            List<TransactionDTO> transactions = new ArrayList<>();

            Set<TransactionEntity> trxs = bankAccountEntity.getTrxsAccredited();

            if(!trxs.isEmpty()){
                transactions.addAll(TransactionDTO.buildFromTransactionEntity(trxs));
                trxs.clear();
            }

            trxs = bankAccountEntity.getTrxsDebited();

            if(!trxs.isEmpty()){
                transactions.addAll(TransactionDTO.buildFromTransactionEntity(trxs));
                trxs.clear();
            }

            TransactionDTO.sortByCreationDate(transactions);
            bankAccountDTO.setTransactions(transactions);

            return  bankAccountDTO;
        })
        .collect(Collectors.toSet());
    }
}
