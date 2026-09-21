package com.studydays.studydays.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studydays.studydays.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    Optional<Usuario> buscarUsuario(String nome);
    // parece ser um shortcut para montar uma função que busca o atributo nome no banco
    // 
}
