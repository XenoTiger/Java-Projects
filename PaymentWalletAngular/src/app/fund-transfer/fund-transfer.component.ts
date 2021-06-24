import { Component, OnInit } from '@angular/core';
import { BankServiceService } from '../bank-service.service';

@Component({
  selector: 'app-fund-transfer',
  templateUrl: './fund-transfer.component.html',
  styleUrls: ['./fund-transfer.component.css']
})
export class FundTransferComponent implements OnInit {

  updatedBalance: any;
  constructor(private service: BankServiceService) { }

  ngOnInit() {
  }

  fundTransfer(data) {
    // tslint:disable-next-line:no-shadowed-variable
this.service.fundTransfer( data.accountNo1, data.accountNo2 , data.balance).subscribe(data =>{ this.updatedBalance = data ;} );
    }

}
