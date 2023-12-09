package io.github.dflasso.transactions.models.dtos;

import io.github.dflasso.transactions.models.entities.TransactionEntity;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class TransactionDTO {
    private Long numTrx;

    private String bankAccountOrigin;

    private String bankAccountDestiny;

    private String description;

    private LocalDateTime date;

    private double amount;

    private double iva;

    private double commission;

    public static TransactionDTO buildFromTransactionEntity(TransactionEntity transactionEntity){
        TransactionDTO dto = new TransactionDTO();

        dto.setAmount(transactionEntity.getAmount());
        dto.setIva(transactionEntity.getIva());
        dto.setNumTrx(transactionEntity.getId());
        dto.setDate(transactionEntity.getCreatedDate());
        dto.setCommission(transactionEntity.getCommission());
        dto.setDescription(transactionEntity.getDescription());
        dto.setBankAccountDestiny(transactionEntity.getBankAccountDestiny().getAccount_number());
        dto.setBankAccountOrigin(transactionEntity.getBankAccountOrigin().getAccount_number());

        return dto;
    }

    public static Set<TransactionDTO> buildFromTransactionEntity(Set<TransactionEntity> transactions){
        return transactions.stream().map(TransactionDTO::buildFromTransactionEntity).collect(Collectors.toSet());
    }

    public static void sortByCreationDate(List<TransactionDTO> transactions){
        Comparator<TransactionDTO> comparatorAsc = (transactionCurrent, transactionNext) -> transactionCurrent.getDate().compareTo(transactionNext.getDate());
        transactions.sort(comparatorAsc);
    }
}
