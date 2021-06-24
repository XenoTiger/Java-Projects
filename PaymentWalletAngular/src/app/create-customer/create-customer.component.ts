import { Component, OnInit } from '@angular/core';
import { Customer } from 'customer';
import { BankServiceService } from '../bank-service.service';

@Component({
  selector: 'app-create-customer',
  templateUrl: './create-customer.component.html',
  styleUrls: ['./create-customer.component.css']
})
export class CreateCustomerComponent implements OnInit {

  customer: Customer = new Customer();

  constructor(private service: BankServiceService) { }

  ngOnInit() {
  }

  createCustomer(data) {
    this.customer.name = data.customerName;
    this.customer.mobileNo = data.customerMobileNo;
    this.service.createCustomer(this.customer).subscribe(data1 => console.log(data), error => console.log(error));
  }

}
