/**
 * Created by Alexey on 01.11.2018.
 */
export class UserAccount {
  id_AC: string;
  is_admin: string;
  id_BA: string;
  email: string;
  login: string;
  password: string;

  static cloneBase(userAccount: UserAccount): UserAccount {
    let clonedUserAccount: UserAccount = new UserAccount();
    clonedUserAccount.id_AC = userAccount.id_AC;
    clonedUserAccount.id_BA = userAccount.id_BA;
    clonedUserAccount.is_admin = userAccount.is_admin;
    clonedUserAccount.email = userAccount.email;
    clonedUserAccount.login = userAccount.login;
    clonedUserAccount.password = userAccount.password;
    return clonedUserAccount;
  }
}
