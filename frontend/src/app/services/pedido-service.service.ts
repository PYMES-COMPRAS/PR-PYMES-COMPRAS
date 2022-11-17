import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Pedido } from '../models/pedido';

@Injectable({
  providedIn: 'root'
})
export class PedidoService {

  private baseEndpoint='http://localhost:8080/api/pedidos/';

  private cabeceras:HttpHeaders=new HttpHeaders({'Content-Type': 'application/json'});
  constructor(private http: HttpClient) {}

  public obtenerPedido(id:number):Observable<Pedido>{
    return this.http.get<Pedido>(`${this.baseEndpoint}/${id}`);
  }

  public editarPedido(pedido:Pedido):Observable<Pedido>{
    return this.http.put<Pedido>(`${this.baseEndpoint}/${pedido.idPedido}`, pedido, 
    {headers: this.cabeceras});
  }
}
