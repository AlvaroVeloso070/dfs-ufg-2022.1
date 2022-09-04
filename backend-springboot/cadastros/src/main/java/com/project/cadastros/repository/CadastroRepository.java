package com.project.cadastros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.cadastros.entities.Cadastros;

public interface CadastroRepository extends JpaRepository<Cadastros, Long>{
    
}
