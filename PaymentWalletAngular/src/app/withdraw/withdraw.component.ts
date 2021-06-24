import { Component, OnInit } from '@angular/core';
import { BankServiceService } from '../bank-service.service';

@Component({
  selector: 'app-withdraw',
  templateUrl: './withdraw.component.html',
  styleUrls: ['./withdraw.component.css']
})
export class WithdrawComponent implements OnInit {
  updatedBalance: any;

  constructor(private service: BankServiceService) { }

  ngOnInit() {
  }

  withdraw(data) {
    // tslint:disable-next-line:no-shadowed-variable
    this.service.withdraw( data.accountNo, data.balance).subscribe(data => this.updatedBalance = data);
    }

}
