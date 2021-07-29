import { AppComponent } from './../app.component';
import { Cadastro } from './../models/cadastrar.model';
import { LoginService } from './../services/login.service';
import { Component, OnInit, Output } from '@angular/core';
import { EventEmitter } from "@angular/core";
import { Router } from '@angular/router';
import { Login } from '../models/logar.model';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  @Output() aoLogar = new EventEmitter<any>();

  email: String;
  senha: String;


  cadastros: Cadastro;

  constructor(private service: LoginService, private router: Router ,  private appcomponent: AppComponent) {}

  logar(){
    const valorEmitir : Login = {email: this.email, password: this.senha}
    this.service.logar(valorEmitir).subscribe((cadastro : Cadastro) => {
      const valorEmitir2 : Cadastro = cadastro;
      alert("Login realizado com sucesso");
      this.appcomponent.guardaDados(cadastro);
      this.router.navigateByUrl('ativos');
    }, (error) => {
      console.error(error)
      alert("Erro ao efetuar login");
      }
     );
  }
  logout(){
    
  }

  ngOnInit() {
  }

}
