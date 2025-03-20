package com.backend_garrido.TestFullstack.service;

import com.backend_garrido.TestFullstack.entities.Persona;

import java.util.List;
import java.util.Optional;

public interface IPersonaService {
    Persona crearPersona(Persona persona);

    List<Persona> getAllPersonas();

    Optional<Persona> getById(Long Id);

    void eliminar(Long id);
}
