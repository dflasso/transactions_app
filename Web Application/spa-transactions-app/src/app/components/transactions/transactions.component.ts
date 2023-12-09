import { Component } from '@angular/core';
import { HeaderComponent } from '../../shared/header/header.component';
import { TableTransactionsComponent } from '../../childs/transactions/table-transactions/table-transactions.component';

@Component({
  selector: 'app-transactions',
  standalone: true,
  imports: [HeaderComponent,  TableTransactionsComponent],
  templateUrl: './transactions.component.html',
  styleUrl: './transactions.component.css'
})
export class TransactionsComponent {

}
