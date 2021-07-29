import { Component } from '@angular/core';
import { Cadastro } from './models/cadastrar.model';
import { CadastroService } from './services/cadastro.service';




@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'bytebank';

  cadastros: any[] = [];

  email: any;
  constructor(private service: CadastroService){}
  guardaDados(usuario : Cadastro){
      this.email = usuario.email;
  }
  mandaDados(){
    return this.email;
  }



}
