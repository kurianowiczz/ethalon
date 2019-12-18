import {Injectable} from "@angular/core";
import {IUser} from "../interfaces/IUser";

@Injectable()
export class StorageService {
  private readonly TOKEN_KEY: string = "token";
  private readonly CURRENT_USER: string = "user";

  private currentUser: IUser;

  public setToken(token: string): void {
    localStorage.setItem(this.TOKEN_KEY, token);
  }

  public setCurrentUser(currentUser: IUser): void {
    this.currentUser = currentUser;
    localStorage.setItem(this.CURRENT_USER, JSON.stringify(currentUser));
  }

  public getCurrentUser(): IUser {
    return this.currentUser || JSON.parse(localStorage.getItem(this.CURRENT_USER));
  }

  public getToken(): string {
    return localStorage.getItem(this.TOKEN_KEY);
  }

  public clearToken(): void {
    localStorage.setItem(this.TOKEN_KEY, null);
  }
}
