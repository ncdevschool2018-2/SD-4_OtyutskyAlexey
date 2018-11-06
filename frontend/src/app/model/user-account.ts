/**
 * Created by Alexey on 01.11.2018.
 */
export class UserAccount {
  id_AC: string;
  id_BA: string;
  id_ROLE: string;
  email: string;
  login: string;
  password: string;

  static cloneBase(userAccount: UserAccount): UserAccount {
    let clonedUserAccount: UserAccount = new UserAccount();
    clonedUserAccount.id_AC = userAccount.id_AC;
    clonedUserAccount.id_BA = userAccount.id_BA;
    clonedUserAccount.id_ROLE = userAccount.id_ROLE;
    clonedUserAccount.email = userAccount.email;
    clonedUserAccount.login = userAccount.login;
    clonedUserAccount.password = userAccount.password;
    return clonedUserAccount;
  }
}
