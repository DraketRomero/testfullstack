package com.backend_garrido.TestFullstack.orchestrator;

import com.backend_garrido.TestFullstack.controllers.DTO.PersonaDTO;
import com.backend_garrido.TestFullstack.controllers.ResponseWrapper;
import com.backend_garrido.TestFullstack.entities.Persona;
import com.backend_garrido.TestFullstack.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public class PersonaStoreOrchestrator {
    private final IPersonaService iPersonaService;

    @Autowired
    public PersonaStoreOrchestrator(IPersonaService iPersonaService) {
        this.iPersonaService = iPersonaService;
    }

    public ResponseEntity<ResponseWrapper<Persona>> crearPersona(PersonaDTO personaDTO) {
        try {
            if(personaDTO.getNombre().isBlank() || personaDTO.getApellido().isBlank() || personaDTO.getFecha_nacimiento() == null || personaDTO.getPuesto().isBlank() || personaDTO.getSueldo() == null) {
                ResponseWrapper<Persona> response = new ResponseWrapper<>(true, "Hay errores en tu solicitud",null);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
            }

            Persona persona = iPersonaService.crearPersona(
                    Persona.builder()
                            .nombre(personaDTO.getNombre())
                            .apellido(personaDTO.getApellido())
                            .fecha_nacimiento(personaDTO.getFecha_nacimiento())
                            .puesto(personaDTO.getPuesto())
                            .sueldo(personaDTO.getSueldo())
                            .build()
            );

            ResponseWrapper<Persona> response = new ResponseWrapper<>(true, "Persona guardada correctamente", List.of(persona));
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            ResponseWrapper<Persona> response = new ResponseWrapper<>(false, "Error al guardar la persona", null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    public ResponseEntity<ResponseWrapper<PersonaDTO>> getAllPersonas() {
        try {
            List<PersonaDTO> personaList = iPersonaService.getAllPersonas()
                    .stream()
                    .map(persona -> PersonaDTO.builder()
                            .id(persona.getId())
                            .nombre(persona.getNombre())
                            .apellido(persona.getApellido())
                            .fecha_nacimiento(persona.getFecha_nacimiento())
                            .puesto(persona.getPuesto())
                            .sueldo(persona.getSueldo())
                            .build()
                    ).toList();

            ResponseWrapper<PersonaDTO> response = new ResponseWrapper<>(true, "Operación exitosa", personaList);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            ResponseWrapper<PersonaDTO> response = new ResponseWrapper<>(false, "Error al obtener las personas", null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    public ResponseEntity<ResponseWrapper<PersonaDTO>> getPersona(Long id) {
        try {
            Optional<Persona> personaOptional = iPersonaService.getById(id);

            if (personaOptional.isEmpty()) {
                ResponseWrapper<PersonaDTO> response = new ResponseWrapper<>(false, "Persona no encontrada", null);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }

            Persona persona = personaOptional.get();

            PersonaDTO personaDTO = PersonaDTO.builder()
                    .id(persona.getId())
                    .nombre(persona.getNombre())
                    .apellido(persona.getApellido())
                    .fecha_nacimiento(persona.getFecha_nacimiento())
                    .puesto(persona.getPuesto())
                    .sueldo(persona.getSueldo())
                    .build();

            ResponseWrapper<PersonaDTO> response = new ResponseWrapper<>(true, "Persona encontrada", List.of(personaDTO));
            return ResponseEntity.status(HttpStatus.OK).body(response);

        } catch (Exception e) {
            ResponseWrapper<PersonaDTO> response = new ResponseWrapper<>(false, "Error al obtener la persona", null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    public ResponseEntity<ResponseWrapper<Persona>> updatePersona(Long id, PersonaDTO personaDTO) {
        try {
            Optional<Persona> personaOptional = iPersonaService.getById(id);

            if (personaOptional.isEmpty()) {
                ResponseWrapper<Persona> response = new ResponseWrapper<>(false, "Persona no encontrada", null);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }

            Persona persona = personaOptional.get();
            persona.setNombre(personaDTO.getNombre());
            persona.setApellido(personaDTO.getApellido());
            persona.setFecha_nacimiento(personaDTO.getFecha_nacimiento());
            persona.setPuesto(personaDTO.getPuesto());
            persona.setSueldo(personaDTO.getSueldo());

            iPersonaService.crearPersona(persona);

            ResponseWrapper<Persona> response = new ResponseWrapper<>(true, "Persona actualizada", List.of(persona));
            return ResponseEntity.status(HttpStatus.OK).body(response);

        } catch (Exception e) {
            ResponseWrapper<Persona> response = new ResponseWrapper<>(false, "Error al obtener la persona", null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    public ResponseEntity<ResponseWrapper<Persona>> deletePersona(Long id) {
        try {
            Optional<Persona> personaOptional = iPersonaService.getById(id);

            if (personaOptional.isEmpty()) {
                ResponseWrapper<Persona> response = new ResponseWrapper<>(false, "Persona no encontrada", null);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }

            Persona persona = personaOptional.get();
            persona.setEnabled(false);
            iPersonaService.crearPersona(persona);

            ResponseWrapper<Persona> response = new ResponseWrapper<>(true, "Persona eliminada", List.of(persona));
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            ResponseWrapper<Persona> response = new ResponseWrapper<>(false, "Error al obtener la persona", null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
