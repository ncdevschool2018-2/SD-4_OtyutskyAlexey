import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule }   from '@angular/forms';
import { RouterModule } from "@angular/router";
import {HttpClientModule} from '@angular/common/http';

import { BsDropdownModule } from 'ngx-bootstrap/dropdown';
import { TooltipModule } from 'ngx-bootstrap/tooltip';
import { ModalModule } from 'ngx-bootstrap/modal';
import {Ng4LoadingSpinnerModule} from "ng4-loading-spinner";


import { AppComponent } from './app.component';
import {UserAccountsComponent} from "./component/user-accounts/user-accounts.component";
import {FilmsComponent} from "./component/films/films.component";
import {LoginComponent} from "./component/login/login.component";
import { NavbarComponent } from "./component/navbar/navbar.component";

@NgModule({
  declarations: [
    AppComponent,
    UserAccountsComponent,
    FilmsComponent,
    LoginComponent,
    NavbarComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    Ng4LoadingSpinnerModule.forRoot(),
    BsDropdownModule.forRoot(),
    TooltipModule.forRoot(),
    ModalModule.forRoot(),
    RouterModule.forRoot(
     [
       { path: 'films', component: FilmsComponent },
       { path: 'user-accounts', component: UserAccountsComponent },
       { path: 'login', component: LoginComponent }
     ],
      { enableTracing: true }
    )
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
