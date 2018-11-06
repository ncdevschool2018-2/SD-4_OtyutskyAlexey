/**
 * Created by Alexey on 01.11.2018.
 */
import {Component, OnInit, TemplateRef} from "@angular/core";
import {UserAccount} from "../model/user-account"
import {UserAccountService} from "../service/user/user-account.service";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {Subscription} from "rxjs/internal/Subscription";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";

@Component({
  selector: 'app-user-accounts',
  templateUrl: './user-accounts.component.html'
})

export class UserAccountsComponent implements OnInit{

  public editMode = false;

  public userAccounts: UserAccount[];
  public editableBa: UserAccount = new UserAccount();
  public modalRef: BsModalRef; //we need a variable to keep a reference of our modal. This is going to be used to close the modal.

  private subscriptions: Subscription[] = [];


  constructor(private userAccountService: UserAccountService,
              private loadingService: Ng4LoadingSpinnerService,
              private modalService: BsModalService) { //to show the modal, we also need the ngx-bootstrap service
  }

  ngOnInit(){
    this.loadUserAccounts();
  }

  public _closeModal(): void {
    this.modalRef.hide();
  }

  public _openModal(template: TemplateRef<any>, userAccount: UserAccount): void {

    if (userAccount) {
      this.editMode = true;
      this.editableBa = UserAccount.cloneBase(userAccount);
    } else {
      this.refreshBa();
      this.editMode = false;
    }

    this.modalRef = this.modalService.show(template); // and when the user clicks on the button to open the popup
                                                      // we keep the modal reference and pass the template local name to the modalService.
  }

  public _addUserAccount(): void {
    this.loadingService.show();
    this.subscriptions.push(this.userAccountService.saveUserAccount(this.editableBa).subscribe(() => {
      this._updateUserAccounts();
      this.refreshBa();
      this._closeModal();
      this.loadingService.hide();

    }));
  }

  public _updateUserAccounts(): void {
    this.loadUserAccounts();
  }

  public _deleteUserAccount(userAccountId: string): void {
    this.loadingService.show();
    this.subscriptions.push(this.userAccountService.deleteUserAccount(userAccountId).subscribe(() => {
      this._updateUserAccounts();
    }));
  }

  private refreshBa(): void {
    this.editableBa = new UserAccount();
  }

  private loadUserAccounts(): void {
    this.loadingService.show();
    // Get data from UserAccountService
    this.subscriptions.push(this.userAccountService.getUserAccounts().subscribe(accounts => {
      // Parse json response into local array
      this.userAccounts = accounts as UserAccount[];
      // Check data in console
      console.log(this.userAccounts);// don't use console.log in angular :)
      this.loadingService.hide();
    }));
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }

}
