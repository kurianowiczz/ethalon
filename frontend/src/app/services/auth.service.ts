import {StorageService} from "./storage.service";
import {Injectable} from "@angular/core";

@Injectable({providedIn: "root"})
export class AuthService {

  constructor(private storageService: StorageService) {
  }

  public isAuthenticated(): boolean {
    const token = localStorage.getItem("token");
    return token && token !== "null" && !!this.storageService.getCurrentUser(); // todo it would be better to add parsing toke. Check expiration!
  }

}
