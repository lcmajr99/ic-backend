import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Login } from '../models/logar.model';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private listaDeCadastro: any[];
  private url = 'http://localhost:8080/projetoIC/login';

constructor(private httpClient: HttpClient) {


 }

 logar(login : Login): Observable<Login> {
   console.log(login);
   return this.httpClient.post<Login>(this.url, login)
 }




}
