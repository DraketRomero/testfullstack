import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { IPersona } from '../interfaces/IPersona';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { PersonaService } from '../persona.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-editar-personas',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './editar-personas.component.html',
  styleUrl: './editar-personas.component.css'
})
export class EditarPersonasComponent {

  personaId: number = 0;
  persona: IPersona[] = [];

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

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.personaId = +params['id'];

      this.personaService.getPersona(this.personaId).subscribe(userData => {
        this.form.setValue(userData.data);
      })
    });
  }

  guardarPersona() {
    if (this.form.valid) {
      console.log(this.form.value);
      this.personaService.createPersona(this.form.value);
      this.router.navigate(['/personas']);
    } else {
      console.log('Formulario inválido');
    }
  }
}
