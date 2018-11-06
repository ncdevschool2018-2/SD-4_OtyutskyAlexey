/**
 * Created by Alexey on 01.11.2018.
 */
import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {UserAccount} from "../../model/user-account";

@Injectable({
  providedIn: 'root'
})
// Data service
export class UserAccountService { //todo create interface

  constructor(private http: HttpClient) {
  }

  // Ajax request for user account data
  getUserAccounts(): Observable<UserAccount[]> {
    return this.http.get<UserAccount[]>('/api/ua');
  }

  saveUserAccount(userAccount: UserAccount): Observable<UserAccount> {
    return this.http.post<UserAccount>('/api/ua', userAccount);
  }

  deleteUserAccount(userAccountId: string): Observable<void> {
    return this.http.delete<void>('/api/ua/' + userAccountId);
  }

}
