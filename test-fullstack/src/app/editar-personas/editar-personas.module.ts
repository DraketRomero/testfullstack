import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EditarPersonasComponent } from './editar-personas.component';
import { ReactiveFormsModule } from '@angular/forms';



@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    EditarPersonasComponent,
    ReactiveFormsModule
  ],
  exports: [EditarPersonasComponent]
})
export class EditarPersonasModule { }
