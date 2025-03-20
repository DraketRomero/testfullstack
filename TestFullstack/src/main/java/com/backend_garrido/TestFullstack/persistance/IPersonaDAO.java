package com.backend_garrido.TestFullstack.persistance;

import com.backend_garrido.TestFullstack.entities.Persona;

import java.util.List;
import java.util.Optional;

public interface IPersonaDAO {
    Persona crearPersona(Persona persona);

    List<Persona> getAllPersonas();

    Optional<Persona> getById(Long Id);

    void eliminar(Long id);
}
