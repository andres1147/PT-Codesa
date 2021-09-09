/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.springboot.repository;

import com.example.springboot.model.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Usuario, Long>{

    //@Query("SELECT u FROM usuario WHERE u.nombre LIKE %?1%" )
    /*@Query("SELECT u FROM Usuario WHERE u.nombre LIKE :param_nombre" )
    public List<Usuario>findByNombre(@Param("param_nombre") String param_nombre);*/
}
