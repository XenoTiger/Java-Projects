import { Component, OnInit } from '@angular/core';
import { BankServiceService } from '../bank-service.service';

@Component({
 selector: 'app-show-balance',
 templateUrl: './show-balance.component.html',
 styleUrls: ['./show-balance.component.css']
})
export class ShowBalanceComponent implements OnInit {

 balance: number;

 constructor(private service: BankServiceService) { }

 ngOnInit() {
 }

 show(data) {
 // tslint:disable-next-line:no-shadowed-variable
 this.service.show(data.accountNo).subscribe(data => this.balance = data);
 }

}
