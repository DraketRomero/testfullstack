import { CommonModule } from "@angular/common";
import { Component } from "@angular/core";
import { IPersona } from "../interfaces/IPersona";
import { Router, RouterModule } from "@angular/router";

@Component({
  selector: 'personas',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './personas.component.html',
  styleUrl: './personas.component.css'
})

export class PersonasComponent {
    personas: IPersona[] = [];

    constructor(
      // private readonly personaService: PersonaService
      private readonly router: Router
    ) { }
  
    ngOnInit() {
      // this.personaService.getPersonas().subscribe((response) => {
      //   this.personas = response
      // });
  
      this.personas = [
        {
          id: 1, 
          nombre: "Dirgo",
          apellido: "Garrido",
          fecha_nacimiento: new Date(),
          sueldo: 1000,
          puesto: "Boss"
        }
      ]
    }

    editarPersona() {
        this.router.navigate(['/personas/editar/1']); 
    }
  
}