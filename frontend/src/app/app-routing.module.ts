import { AtivosComponent } from './ativos/ativos.component';
import { LoginComponent } from './login/login.component';
import { ExtratoComponent } from './extrato/extrato.component';
import { NgModule } from '@angular/core';
import { RouterModule } from "@angular/router";

import { Routes } from '@angular/router';
import { NovaTransferenciaComponent } from './nova-transferencia/nova-transferencia.component';
import { TransacaoComponent } from './transacao/transacao.component';

export const routes: Routes = [
  {
    path:'', redirectTo: 'login', pathMatch: 'full'
  },
  {
    path: 'extrato', component: ExtratoComponent
  },
  {
    path: 'novo-cadastro', component: NovaTransferenciaComponent
  },
  {
    path: 'login', component: LoginComponent
  },
  {
    path: 'ativos', component: AtivosComponent
  },
  {
    path: 'transacao', component: TransacaoComponent
  }
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule{}
