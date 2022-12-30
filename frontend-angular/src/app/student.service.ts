import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { student } from './student';
@Injectable({
  providedIn: 'root'
})
export class studentService {

  private baseURL = "http://localhost:8080/ap1/v1/students";

  constructor(private httpClient: HttpClient) { }
  
  getStudentsList(): Observable<student[]>{
    return this.httpClient.get<student[]>(`${this.baseURL}`);
  }

  createStudent(student: student): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`, student);
  }

  getStudentById(id: number): Observable<student>{
    return this.httpClient.get<student>(`${this.baseURL}/${id}`);
  }

  updateStudent(id: number, student: student): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${id}`, student);
  }

  deleteStudent(id: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${id}`);
  }
}
