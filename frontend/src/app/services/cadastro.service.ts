import { Usuario } from './../models/usuario.model';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Cadastro } from '../models/cadastrar.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CadastroService {

  private listaDeCadastro: any[];
  private url = 'http://localhost:8080/projetoIC/usuario';
  private findeUser = 'http://localhost:8080/projetoIC/usuario/find/';
  private url2 = 'http://localhost:8080/projetoIC/usuario/momento';


  constructor(private httpCLient: HttpClient) {
    this.listaDeCadastro = [];

  }

  get cadastros() {
    return this.listaDeCadastro;
  }

  todas(): Observable<Cadastro[]>{
    return this.httpCLient.get<Cadastro[]>(this.url)
  }

  especifico(email): Observable<Usuario>{
    return this.httpCLient.get<Usuario>(this.findeUser+email)
  }

  adicionar(cadastro: Cadastro): Observable<Cadastro> {
    console.log(cadastro);
    return this.httpCLient.post<Cadastro>(this.url, cadastro);
  }

  alterarTempo(cadastro: Usuario): Observable<Usuario>{
    return this.httpCLient.post<Usuario>(this.url2, cadastro);

  }


}
