import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LlenarPedidoComponent } from './components/llenar-pedido/llenar-pedido.component';
import { PedidoComponent } from './components/pedido/pedido.component';
import { PedidoDetalle } from './models/pedido-detalle';

const routes: Routes = [
  {path:'', pathMatch:'full', redirectTo:'pedidos'},
  {path:'pedidos', component: LlenarPedidoComponent},
  {path:'pedidoDetalle', component: PedidoComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
