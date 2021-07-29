import { CadastroService } from './../services/cadastro.service';
import { EventEmitter, Output } from "@angular/core";
import { Component } from "@angular/core";
import { Cadastro } from '../models/cadastrar.model';
import { Router } from '@angular/router';

@Component ({
    selector: 'app-nova-transferencia',
    templateUrl: './nova-transferencia.component.html',
    styleUrls:['./nova-transferencia.component.css']
})
export class NovaTransferenciaComponent{

  @Output() aoCadastrar = new EventEmitter<any>();

  nome: String;
  email: String;
  senha: String;

  constructor(private service: CadastroService, private router: Router){}
 cadastrar(){
   const valorEmitir : Cadastro = {nome: this.nome, email: this.email,  password: this.senha}
   console.log(valorEmitir);
   this.service.adicionar(valorEmitir).subscribe(resultado => {
    alert("Cadastro efetuado com sucesso");
    this.limparCampos();
    this.router.navigateByUrl('ativos');
  }, (error) => {
    console.error(error)
    alert("Erro ao ao efetuar o cadastro");
    }
   );

  }
  limparCampos(){
    this.email="";
    this.nome="";
    this.senha="";
  }
}
