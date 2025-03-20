package com.backend_garrido.TestFullstack.controllers;

import com.backend_garrido.TestFullstack.controllers.DTO.PersonaDTO;
import com.backend_garrido.TestFullstack.entities.Persona;
import com.backend_garrido.TestFullstack.orchestrator.PersonaStoreOrchestrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {

    @Autowired
    private PersonaStoreOrchestrator personaStoreOrchestrator;

    public PersonaController(PersonaStoreOrchestrator personaStoreOrchestrator) {
        this.personaStoreOrchestrator = personaStoreOrchestrator;
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseWrapper<Persona>> crearPersona(@RequestBody PersonaDTO personaDTO) {
        return this.personaStoreOrchestrator.crearPersona(personaDTO);
    }

    @GetMapping("/getAll")
    public ResponseEntity<ResponseWrapper<PersonaDTO>> getAllPersonas() {
        return this.personaStoreOrchestrator.getAllPersonas();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseWrapper<PersonaDTO>> updatePersona(@PathVariable Long id, @RequestBody PersonaDTO personaDTO) {
        return this.personaStoreOrchestrator.getAllPersonas();
    }

    @GetMapping("/persona/{id}")
    public ResponseEntity<?> getPersona(@PathVariable Long id) {
        return this.personaStoreOrchestrator.getPersona(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePersona(@PathVariable Long id) {
        return this.personaStoreOrchestrator.deletePersona(id);
    }
}
