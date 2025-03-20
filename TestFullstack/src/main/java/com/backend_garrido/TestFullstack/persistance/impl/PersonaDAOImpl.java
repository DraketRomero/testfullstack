package com.backend_garrido.TestFullstack.persistance.impl;

import com.backend_garrido.TestFullstack.entities.Persona;
import com.backend_garrido.TestFullstack.persistance.IPersonaDAO;
import com.backend_garrido.TestFullstack.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PersonaDAOImpl implements IPersonaDAO {
    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public Persona crearPersona(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public List<Persona> getAllPersonas() {
        return (List<Persona>) personaRepository.findAll();
    }

    @Override
    public Optional<Persona> getById(Long Id) {
        return personaRepository.findById(Id);
    }

    @Override
    public void eliminar(Long id) {
        Persona persona = personaRepository.findById(id).orElse(null);

        if (persona != null) {
            persona.setEnabled(false);
            personaRepository.save(persona);
        }
    }
}
