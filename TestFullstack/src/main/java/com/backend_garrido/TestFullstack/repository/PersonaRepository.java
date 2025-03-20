package com.backend_garrido.TestFullstack.repository;

import com.backend_garrido.TestFullstack.entities.Persona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends CrudRepository<Persona, Long> { }
