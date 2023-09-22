import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MenuComponent } from './menu/menu.component';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatCardModule } from '@angular/material/card';
import { MatMenuModule } from '@angular/material/menu';
import { FornecedorComponent } from './pages/cadastro/fornecedor/fornecedor.component';
import { ProdutoComponent } from './pages/cadastro/produto/produto.component';
import { GrupoProdutoComponent } from './pages/cadastro/grupo-produto/grupo-produto.component';
import { MarcaComponent } from './pages/cadastro/marca/marca.component';
import { UnidadeMedidaComponent } from './pages/cadastro/unidade-medida/unidade-medida.component';
import { LocalArmazenamentoComponent } from './pages/cadastro/local-armazenamento/local-armazenamento.component';

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    DashboardComponent,
    FornecedorComponent,
    ProdutoComponent,
    GrupoProdutoComponent,
    MarcaComponent,
    UnidadeMedidaComponent,
    LocalArmazenamentoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatButtonModule,
    MatSidenavModule,
    MatIconModule,
    MatListModule,
    MatGridListModule,
    MatCardModule,
    MatMenuModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
