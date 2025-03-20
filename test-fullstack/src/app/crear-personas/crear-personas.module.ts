import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CrearPersonasComponent } from './crear-personas.component';



@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    CrearPersonasComponent
  ],
  exports: [CrearPersonasComponent]
})
export class CrearPersonasModule { }
