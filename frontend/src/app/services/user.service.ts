import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";

import {IUser} from "../interfaces/IUser";

@Injectable({providedIn: 'root'})
export class UsersService {
  private readonly apiBaseUrl = 'http://localhost:8081/api';

  constructor(private http: HttpClient) { }

  getOne(id) {
    return this.http.get<IUser>(`${this.apiBaseUrl}/users/id/${id}`);
  }

}
