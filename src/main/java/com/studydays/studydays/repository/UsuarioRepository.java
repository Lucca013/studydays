package com.studydays.studydays.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studydays.studydays.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

    // só por fazer isso já temos os seguintes métodos:
        // save()
        // findAll()
        // findById()
        // existsById()
        // deleteById()

}
