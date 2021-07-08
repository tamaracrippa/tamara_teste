import { NgModule } from '@angular/core';
import { MatMenuModule } from '@angular/material/menu';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [];

@NgModule({
  imports: [RouterModule.forRoot(routes),
    MatMenuModule],
  exports: [RouterModule]
})
export class AppRoutingModule { }
