package com.example.springboot.model;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //private int idUsuario;
    private Long idUsuario;
    
    @Column(name = "id_rol")
    private int idRol;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "activo")
    private char activo;

    public Usuario() {
    }

    /*public Usuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }*/

    public Usuario(int idRol, String nombre, char activo) {
        this.idRol = idRol;
        this.nombre = nombre;
        this.activo = activo;
    }

    /*public Usuario(int idUsuario, int idRol, String nombre, char activo) {
        this.idUsuario = idUsuario;
        this.idRol = idRol;
        this.nombre = nombre;
        this.activo = activo;
    }*/

    public Usuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(Long idUsuario, int idRol, String nombre, char activo) {
        this.idUsuario = idUsuario;
        this.idRol = idRol;
        this.nombre = nombre;
        this.activo = activo;
    }
    
    
    
    /*public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }*/

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public char getActivo() {
        return activo;
    }

    public void setActivo(char activo) {
        this.activo = activo;
    }



}
