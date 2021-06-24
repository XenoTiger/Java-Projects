import { Injectable } from '@angular/core';
import { Observable } from '../../node_modules/rxjs';
import { Customer } from 'customer';
import { HttpClient } from '../../node_modules/@angular/common/http';



@Injectable({
  providedIn: 'root'
})
export class BankServiceService {

  private baseUrl = 'http://localhost:9090/create';

  constructor(private http: HttpClient) { }

  createCustomer(customer) {
    alert(customer.name);
    alert('account Created Successfully');
    console.log(customer.name);
    return this.http.post<Customer>('http://localhost:9090/create', customer);
  }

  show(accountNo): Observable<number> {
 console.log(accountNo);
 return this.http.get<number>('http://localhost:9090/show/' + accountNo);
 }

  deposit(accountNo, balance): Observable<any> {
    alert('Balance Deposited Successfully');
    return this.http.put<number>('http://localhost:9090/deposit/'+ accountNo+'/'+ balance,'');
    }

    withdraw(accountNo, balance): Observable<any> {
      alert('Balance Withdrawl Successfully');
      return this.http.put<number>( 'http://localhost:9090/withdraw/' + accountNo + '/' + balance, '');
      }

      fundTransfer(accountNo1, accountNo2, balance): Observable<any> {
        alert('Fund Transferred Successfully');
        return this.http.put<number>('http://localhost:9090/transfer/' + accountNo1 + '/' + accountNo2 + '/' + balance, '');
        }
}
