import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from "@angular/router";
import {FilmsComponent} from "./films.component";

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forRoot([
      {
        path: 'films',
        component: FilmsComponent
      }
    ])
  ],
  declarations: [
    FilmsComponent
  ]
})
export class FilmsModule { }
