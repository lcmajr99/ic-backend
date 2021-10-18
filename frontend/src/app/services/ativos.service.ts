import { Observable } from 'rxjs';
import { Transacao } from './../models/transacao.model';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Ativo } from '../models/ativo.model';
import { Console } from 'console';

@Injectable({
  providedIn: 'root'
})
export class AtivoService {

  private url = 'http://localhost:8080/projetoIC/petraprevisao';
  private url11 = 'http://localhost:8080/projetoIC/bbas3previsao/valores/';
  private url10 = 'http://localhost:8080/projetoIC/bbas3/valores/';
  private url20 = 'http://localhost:8080/projetoIC/petr4/valores/';
  private url21 = 'http://localhost:8080/projetoIC/petraprevisao/valores/';
constructor(private httpClient: HttpClient) { }

  todas(): Observable<Ativo[]>{
    return this.httpClient.get<Ativo[]>(this.url)
  }
  palpite(momento): Observable<Ativo[]>{
    return this.httpClient.get<Ativo[]>(this.url20+momento);
  }
  palpiteBBAS3(momento): Observable<Ativo[]>{
    return this.httpClient.get<Ativo[]>(this.url10+momento);
  }
  valorReal(momento): Observable<Ativo[]>{
    return this.httpClient.get<Ativo[]>(this.url21+momento);
  }
  valorRealBBAS3(momento): Observable<Ativo[]>{
    console.log("teste");
    return this.httpClient.get<Ativo[]>(this.url11+momento);
  }

// efetuar(transacao: Transacao): Observable<Transacao>{
//   return this.httpClient.get<Transacao>(this.url,transacao);
// }
}
