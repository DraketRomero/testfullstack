package com.backend_garrido.TestFullstack.controllers.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PersonaDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private LocalDate fecha_nacimiento;
    private String puesto;
    private BigDecimal sueldo;
    private boolean enabled;
}
