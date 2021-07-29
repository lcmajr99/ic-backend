import { AppComponent } from './../app.component';
import { Cadastro } from './../models/cadastrar.model';
import { Component, Input, OnInit } from '@angular/core';
import { CadastroService } from '../services/cadastro.service';

@Component({
  selector: 'app-ativos',
  templateUrl: './ativos.component.html',
  styleUrls: ['./ativos.component.css']
})
export class AtivosComponent implements OnInit {

  cadastro?: Cadastro;
  email?: String;
  constructor(private appcomponent: AppComponent, private service: CadastroService) { }

  mudaAtivoBBAS3(){
    localStorage.setItem('ativo', 'bbas3');
    window.location.href = "http://localhost:4200/transacao";
  }
  mudaAtivoPETR4(){
    localStorage.setItem('ativo','petr4');
    window.location.href = "http://localhost:4200/transacao";
  }
  ngOnInit() {
    this.email = this.appcomponent.mandaDados();
    localStorage.setItem('email', this.email.toString());

  }

}
