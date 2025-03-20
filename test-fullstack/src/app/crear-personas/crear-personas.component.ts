import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { PersonaService } from '../persona.service';

@Component({
  selector: 'app-crear-personas',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './crear-personas.component.html',
  styleUrl: './crear-personas.component.css'
})
export class CrearPersonasComponent {
  form: FormGroup;

  constructor(
    private readonly fb: FormBuilder,
    private readonly route: ActivatedRoute,
    private readonly router: Router,
    private readonly personaService: PersonaService
  ) {
    this.form = this.fb.group({
      nombre: ['', [Validators.required]],
      apellido: ['', [Validators.required]],
      fecha_nacimiento: ['', [Validators.required]],
      puesto: ['', [Validators.required]],
      sueldo: ['', [Validators.required]]
    });
  }

  guardarPersona() {
    if (this.form.valid) {
      this.personaService.createPersona(this.form.value);
    } else {
      console.log('Formulario inválido');
    }
  }
}
