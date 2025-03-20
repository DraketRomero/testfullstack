package com.backend_garrido.TestFullstack.service.impl;

import com.backend_garrido.TestFullstack.entities.Persona;
import com.backend_garrido.TestFullstack.persistance.IPersonaDAO;
import com.backend_garrido.TestFullstack.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImpl implements IPersonaService {

    @Autowired
    private IPersonaDAO iPersonaDAO;


    @Override
    public Persona crearPersona(Persona persona) {
        return iPersonaDAO.crearPersona(persona);
    }

    @Override
    public List<Persona> getAllPersonas() {
        return iPersonaDAO.getAllPersonas();
    }

    @Override
    public Optional<Persona> getById(Long Id) {
        return iPersonaDAO.getById(Id);
    }

    @Override
    public void eliminar(Long id) {
        iPersonaDAO.eliminar(id);
    }
}
