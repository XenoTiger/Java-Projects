import { Component, OnInit } from '@angular/core';
import { BankServiceService } from '../bank-service.service';

@Component({
  selector: 'app-deposit',
  templateUrl: './deposit.component.html',
  styleUrls: ['./deposit.component.css']
})
export class DepositComponent implements OnInit {
  [x: string]: Object;

  updatedBalance: any;

  constructor(private service: BankServiceService) { }

  ngOnInit() {
  }


  deposit(data) {
    // tslint:disable-next-line:no-shadowed-variable
    this.service.deposit( data.accountNo, data.balance).subscribe(data => this.updatedBalance = data);
    }

}
