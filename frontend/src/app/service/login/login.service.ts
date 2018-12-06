import {HttpClient} from "@angular/common/http";
import {Login} from "../../model/login";
import {Observable} from "rxjs";
import {Injectable} from "@angular/core";
import {Token} from "../../model/token";

@Injectable({
  providedIn: 'root'
})

export class LoginService{

  constructor(private http: HttpClient){
  }

  logIn(login: Login): Observable<Token> {
    return this.http.post<Token>("/token/generate-token", login);
  }

  /*
  logIn(login: Login): Observable<Token> {
    return this.http.post<Token>("/token/generate-token", login);
  }
  */

}
