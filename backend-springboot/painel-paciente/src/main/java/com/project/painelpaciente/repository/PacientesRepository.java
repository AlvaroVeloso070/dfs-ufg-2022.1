package com.project.painelpaciente.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.painelpaciente.entities.Paciente;

public interface PacientesRepository extends JpaRepository<Paciente, Long>{
    
}
