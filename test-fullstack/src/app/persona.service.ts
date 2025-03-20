import { Injectable } from '@angular/core';
import { IPersona } from './interfaces/IPersona';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { IRespuesta } from './interfaces/IRespuesta';

@Injectable({
  providedIn: 'root'
})
export class PersonaService {

  private baseUrl: string = "http://localhost/";

  constructor(
    private readonly http: HttpClient
  ) { }

  createPersona(dataPersona: IPersona): Observable<IRespuesta> {
    return this.http.post<IRespuesta>(`${this.baseUrl}/personas`, dataPersona); 
  }

  getPersonas(): Observable<IRespuesta> {
    return this.http.get<IRespuesta>(`${this.baseUrl}/personas`); 
  }

  getPersona(id: number): Observable<IRespuesta> {
    return this.http.get<IRespuesta>(`${this.baseUrl}/persona/${id}`); 
  }

  updatePersona(data: any): Observable<IRespuesta> {
    return this.http.put<IRespuesta>(`${this.baseUrl}/personas`, data); 
  }

  deletePersona(id: number): Observable<IRespuesta> {
    return this.http.delete<IRespuesta>(`${this.baseUrl}/persona/${id}`); 
  }
}
