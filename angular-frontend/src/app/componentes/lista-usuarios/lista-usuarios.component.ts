import { Component, EventEmitter, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { UsuarioService } from 'src/app/servicios/usuario.service';
import { Usuario } from 'src/app/usuario';

@Component({
  selector: 'app-lista-usuarios',
  templateUrl: './lista-usuarios.component.html',
  styleUrls: ['./lista-usuarios.component.css']
})
export class ListaUsuariosComponent implements OnInit {

  visualizar: boolean;
  editar: boolean;
  formulario: boolean;
  id: number;
  usuarios: Usuario[];
  usuario: Usuario = new Usuario();

  constructor(private usuarioService: UsuarioService,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.getUsuarios();
  }

  private getUsuarios() {
    this.usuarioService.getListaUsuarios().subscribe(data => {
      this.usuarios = data;
    });
  }

  crearUsuario() {
    this.formulario = false;
    this.editar = false;
    this.visualizar = true;
    this.usuario = new Usuario();
  }

  visualizarUsuario(id: number) {
    this.id = this.route.snapshot.params['id'];
    this.usuarioService.getUsuarioById(id).subscribe(data => {
      console.log("HOLA ANDRES");
      console.log(data);
      this.usuario = data;
      this.editar = true;
      this.visualizar = false;
      this.formulario = true;
    }, error => console.log(error));

  }

}
