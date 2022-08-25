package com.project.painelpaciente.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.painelpaciente.entities.Medico;

public interface MedicosRepository extends JpaRepository<Medico, Long>{
    
}
