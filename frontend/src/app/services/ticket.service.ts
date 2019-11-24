import { Injectable } from "@angular/core";
import { HttpClient } from '@angular/common/http';
import { ITicket } from "../interfaces/ITicket";

@Injectable({providedIn: 'root'})
export class TicketService{
  private readonly apiBaseUrl = 'http://localhost:8081/api';

  constructor(private http: HttpClient) {

  }

  getSeatForSeance(id){
    return this.http.get<ITicket[]>(`${this.apiBaseUrl}/tickets/all/${id}`);
  }

    sendTickets(tickets: ITicket[]){
    return this.http.post(`${this.apiBaseUrl}/tickets/`, tickets);
  }
}
