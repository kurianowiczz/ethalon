import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";

import {IUser} from "../interfaces/IUser";
import {Observable} from "rxjs";
import {ILoginModel} from "../interfaces/ILoginModel";

@Injectable({providedIn: 'root'})
export class UsersService {
  private readonly apiBaseUrl = 'http://localhost:8081/api';

  constructor(private http: HttpClient) {

  }

  getOne(id) {
    return this.http.get<IUser>(`${this.apiBaseUrl}/users/id/${id}`);
  }

  create(user:{userName: string; password: string}) {
    return this.http.post<IUser>(`${this.apiBaseUrl}/users/add`,
      {password: user.password, username: user.userName, role: 'user', cash: 1});
  }

  generateToken(login: ILoginModel): Observable<AuthToken> {
    return this.http.post<AuthToken>('/api/token/generate-token', login);
  }

  getAuthorizedUser(): Observable <IUser> {
    return this.http.get<IUser>('/api/users/current');
  }

}

export interface AuthToken {
  readonly token: string;
}
