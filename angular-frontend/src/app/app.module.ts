import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CabeceroComponent } from './componentes/cabecero/cabecero.component';
import { ListaUsuariosComponent } from './componentes/lista-usuarios/lista-usuarios.component';
import { VerUsuarioComponent } from './componentes/ver-usuario/ver-usuario.component';
import { NoEncontradoComponent } from './componentes/no-encontrado/no-encontrado.component';
import { BusquedaUsuarioComponent } from './componentes/busqueda-usuario/busqueda-usuario.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    CabeceroComponent,
    ListaUsuariosComponent,
    VerUsuarioComponent,
    NoEncontradoComponent,
    BusquedaUsuarioComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
