import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PersonasComponent } from './personas.component';
import { EditarPersonasComponent } from './../editar-personas/editar-personas.component';
import { CrearPersonasComponent } from '../crear-personas/crear-personas.component';

const routes: Routes = [
  { path: '', component: PersonasComponent },
  { path: 'crear', component: CrearPersonasComponent },
  { path: 'editar/:id', component: EditarPersonasComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PersonasRoutingModule {}