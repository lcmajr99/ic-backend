import { Observable } from 'rxjs';
import { Transacao } from './../models/transacao.model';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TransacaoService {

  private url = 'http://localhost:8080/projetoIC/transferencia';
  private urlResultado = 'http://localhost:8080/projetoIC/transferencia/resultado/';
  private urlMaisResultado = 'http://localhost:8080/projetoIC/transferencia/resultado2/';
  private urlMaisResultadoPredicao = 'http://localhost:8080/projetoIC/transferencia/resultado3/';


constructor(private httpClient: HttpClient) { }


efetuar(transacao: Transacao): Observable<Transacao>{
  return this.httpClient.post<Transacao>(this.url,transacao);
}
gerarResultado(id): Observable<Number[]>{
  return this.httpClient.get<Number[]>(this.urlResultado+id);
}
gerarMaisResultado(id): Observable<Number>{
  return this.httpClient.get<Number>(this.urlMaisResultado+id);
}
predicaoGerarMaisResultado(id): Observable<Number>{
  return this.httpClient.get<Number>(this.urlMaisResultadoPredicao+id);
}

}
