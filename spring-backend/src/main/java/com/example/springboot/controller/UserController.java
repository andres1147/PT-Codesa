/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.springboot.controller;

import com.example.springboot.exception.ResourceNotFoundException;
import com.example.springboot.model.Usuario;
import com.example.springboot.repository.UsersRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import static org.springframework.http.converter.json.Jackson2ObjectMapperBuilder.json;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class UserController {

    @Autowired
    private UsersRepository userRepository;

    //Get a todos los usuarios
    @GetMapping("/usuarios")
    public List<Usuario> listar() {
        return userRepository.findAll();
    }

    //Get a los usuarios por filtro
    /*@GetMapping("/usuariosFiltrar")
    public List<Usuario> listarFiltrado(@RequestBody String term) {
        return userRepository.findByNombre("%" + term + "%");
    }*/

    //Crear un nuevo usuario
    @PostMapping("/usuarios")
    public Usuario insertar(@RequestBody Usuario usuario) {
        return userRepository.save(usuario);
    }

    //Traer un usuario por ID
    @GetMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> encontrar(@PathVariable Long id) {
        Usuario usuario = userRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Usuario no existe con id: " + id));
        return ResponseEntity.ok(usuario);
    }

    //actualizar un usuario
    @PutMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> actualizar(@PathVariable Long id, @RequestBody Usuario usuarioDetalles) {
        Usuario usuario = userRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Usuario no existe con id: " + id));

        usuario.setIdRol(usuarioDetalles.getIdRol());
        usuario.setNombre(usuarioDetalles.getNombre());
        usuario.setActivo(usuarioDetalles.getActivo());

        Usuario actualizarUsuario = userRepository.save(usuario);
        return ResponseEntity.ok(actualizarUsuario);
    }

    //eliminar un usuario
    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminar(@PathVariable Long id) {
        Usuario usuario = userRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Usuario no existe con id: " + id));

        userRepository.delete(usuario);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
