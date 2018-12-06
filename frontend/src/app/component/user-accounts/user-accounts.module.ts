import {NgModule} from "@angular/core";
import {RouterModule} from "@angular/router";
import {CommonModule} from "@angular/common";
import {UserAccountsComponent} from "./user-accounts.component";

@NgModule({
  imports:[
    CommonModule,
    RouterModule.forRoot([
        {
          path: "/user-accounts",
          component: UserAccountsComponent
        }
    ]
    )
  ],
  declarations:[
    UserAccountsComponent
  ]
})

export class UserAccountsModule {}
