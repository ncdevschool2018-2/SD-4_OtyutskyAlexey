export class Login {
  login: string;
  password: string;

  static cloneBase(login: Login) : Login {
    let clonedLogin = new Login();
    clonedLogin.login = login.login;
    clonedLogin.password = login.password;
    return clonedLogin;
  }
}
