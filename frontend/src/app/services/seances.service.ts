import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ISeance } from "../interfaces/ISeance";

@Injectable({providedIn: 'root'})
export class OrderService {
  private readonly apiBaseUrl = 'http://localhost:8081/api';

  constructor(private http: HttpClient) { }

  getOne(id) {
    return this.http.get<ISeance[]>(`${this.apiBaseUrl}/seances/id/${id}`);
  }


}
