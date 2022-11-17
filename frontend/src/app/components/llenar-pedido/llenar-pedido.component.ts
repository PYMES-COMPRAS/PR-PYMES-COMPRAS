import { Component, OnInit } from '@angular/core';
import { Pedido } from 'src/app/models/pedido';
import { PedidoService } from 'src/app/services/pedido-service.service';

@Component({
  selector: 'app-llenar-pedido',
  templateUrl: './llenar-pedido.component.html',
  styleUrls: ['./llenar-pedido.component.css']
})
export class LlenarPedidoComponent implements OnInit {

  pedido:Pedido; 
  condicionesPago:number=0;
  tipoPago:number=0;
  divisa:number=0;
  fechaEntrega:string="";
  constructor(private service: PedidoService) { }
  ngOnInit(): void {
    this.service.obtenerPedido(2).subscribe({
      next:(res:Pedido)=>{
        this.pedido=res;
        console.log(res);
        this.condicionesPago=this.pedido.condicionesPago;
        this.tipoPago=this.tipoPago;
        this.divisa=this.pedido.divisa;
        this.fechaEntrega=this.fechaEntrega;
      }
    });
    
    
  }

  RealizarPedido():void{
    console.log(this.pedido);
    this.service.editarPedido(this.pedido).subscribe({
      next:(res:Pedido)=>{
        alert(res.estado)
      },
      error:(e)=>alert(e.error)
      

    });
  }

}
