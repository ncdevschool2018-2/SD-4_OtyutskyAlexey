import {Component, OnInit} from "@angular/core";
import {LoginService} from "../../service/login/login.service";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {Login} from "../../model/login";
import {TokenStorage} from "../../storage/token.storage";
import {Token} from "../../model/token";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
})

export class LoginComponent implements OnInit{

  public login: Login = new Login();

  constructor(     private loginService: LoginService,
      private loadingService: Ng4LoadingSpinnerService,
      private tokenStorage: TokenStorage,
      private  router: Router) {
  }

  ngOnInit(){
  }

  private authenticate(): void{
    this.loadingService.show();
    this.loginService.logIn(this.login).subscribe(res => {
          this.tokenStorage.saveToken(res.token);
          this.router.navigate(['/films']);
      },
      error => console.log("Error occured. Wrong login or password."));
    this.loadingService.hide();
  }

  private signOut(): void{
    this.loadingService.show();
    this.tokenStorage.signOut();
    this.loadingService.hide();
  }

  ngOnDestroy(): void {
  }

}
