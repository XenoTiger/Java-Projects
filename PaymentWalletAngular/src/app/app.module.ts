import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { FormsModule } from '@angular/forms'
import { RouterModule,Routes } from '@angular/router'
import { HttpClientModule } from '@angular/common/http'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateCustomerComponent } from './create-customer/create-customer.component';
import { ShowBalanceComponent } from './show-balance/show-balance.component';
import { WithdrawComponent } from './withdraw/withdraw.component';
import { DepositComponent } from './deposit/deposit.component';
import { FundTransferComponent } from './fund-transfer/fund-transfer.component';
import { PrintTransactionComponent } from './print-transaction/print-transaction.component';

// const routes: Routes = [
//   {path:'createCustomer',component:CreateCustomerComponent},
//   {path:'showBalance',component:ShowBalanceComponent},
//   {path:'deposit',component:DepositComponent},
//   {path:'withdraw',component:WithdrawComponent},
//   {path:'fundTransfer',component:FundTransferComponent},
//   {path:'printTransaction',component:PrintTransactionComponent}
// ];

@NgModule({
  declarations: [
    AppComponent,
    CreateCustomerComponent,
    ShowBalanceComponent,
    WithdrawComponent,
    DepositComponent,
    FundTransferComponent,
    PrintTransactionComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    //RouterModule.forRoot(routes),
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
