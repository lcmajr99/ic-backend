import { CadastroService } from './../services/cadastro.service';
import { Component, Input, OnInit } from '@angular/core';
import { Cadastro } from '../models/cadastrar.model';

@Component({
  selector: 'app-extrato',
  templateUrl: './extrato.component.html',
  styleUrls: ['./extrato.component.css']
})
export class ExtratoComponent implements OnInit {

  cadastros: any [];

  constructor(private service: CadastroService) { }

  ngOnInit(): void {
    this.service.todas().subscribe((cadastros: Cadastro[]) => {
      console.table(cadastros);
      this.cadastros = cadastros;

    });
  }

}
