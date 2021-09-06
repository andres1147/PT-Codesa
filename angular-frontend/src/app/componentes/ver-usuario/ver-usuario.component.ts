import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { UsuarioService } from 'src/app/servicios/usuario.service';
import { Usuario } from 'src/app/usuario';

@Component({
  selector: 'app-ver-usuario',
  templateUrl: './ver-usuario.component.html',
  styleUrls: ['./ver-usuario.component.css']
})
export class VerUsuarioComponent implements OnInit {

  @Input() usuario: Usuario;
  @Input() visualizar:boolean;
  @Input() editar:boolean;
  @Input() formulario:boolean;

  id: number;

  constructor(private usuarioService: UsuarioService,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.formulario = true;
    this.editar = true;
    this.visualizar = true;
   
  }

  crearUsuario(){
    this.usuarioService.crearUsuario(this.usuario).subscribe( data =>{
      console.log(data);
      window.location.reload();
      console.log("CORRECTO");
    },
    error => console.log(error));
    console.log("HOLA ANDRES");
  }
 
  eliminarUsuario(id: number){
    this.usuarioService.eliminarUsuario(id).subscribe(data => {
      window.location.reload();
      console.log("HOLA ANDRES");
      console.log(data);
    },error => console.log(error));
  }

  editarUsuario(){
    this.formulario = false;
    this.editar = false;
    this.visualizar = true;
 
  }

  onSubmit(){
    this.crearUsuario();
  }

}
