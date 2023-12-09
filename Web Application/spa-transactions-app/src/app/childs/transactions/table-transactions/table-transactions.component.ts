import { Component } from '@angular/core';
import { TransactionsServices } from '../../../services/trensactions.services';
import dataMock from './mock.json';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatTableModule } from '@angular/material/table';
import { CommonModule } from '@angular/common';
import { ITransactionsByCodeAndTypeResponse, Transaction } from '../../../types/responses/transactions-by-code-and-type-person.response';
import { FormControl, ReactiveFormsModule } from '@angular/forms';


@Component({
  selector: 'app-table-transactions',
  standalone: true,
  imports: [MatExpansionModule, MatTableModule, CommonModule, ReactiveFormsModule],
  templateUrl: './table-transactions.component.html',
  styleUrl: './table-transactions.component.css'
})
export class TableTransactionsComponent {
  codePerson = new FormControl('')
  typePerson = new FormControl('')

  hasData = false

  panelOpenState = false;

  transactions : ITransactionsByCodeAndTypeResponse = {
    header: {
      name: '',
      lastname: '',
      age: 0,
      workPosition: ''
    },
    payload: []
  }

  displayedColumns: string[] = ['NumTrx', 'description', 'type', 'amount'];

  constructor(private trxServices: TransactionsServices) { }

  onSearch() {
    this.trxServices.getAllByCodeAndTypePerson({ code: this.codePerson.value?.toString() || '', type: this.typePerson.value?.toString() || '' })
      .subscribe({
        next: (trxs) => {
          this.hasData = true
          this.transactions = trxs
        }
      })
  }

  getBalance(trxs: Transaction[]) {

    return trxs
      .map(trx => {
        let totalTrx = trx.amount + trx.iva + trx.commission

        if (trx.type === "DEBIT")
          totalTrx = (-1) * totalTrx

        return totalTrx;
      })
      .reduce((previousValue, currentValue) => previousValue + currentValue, 0);

  }

}
