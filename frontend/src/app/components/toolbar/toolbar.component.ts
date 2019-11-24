import { Component, OnInit } from '@angular/core';
import {IUser} from "../../interfaces/IUser";
import {mockUser} from "../../mocks/user";

@Component({
  selector: 'app-toolbar',
  templateUrl: './toolbar.component.html',
  styleUrls: ['./toolbar.component.css']
})
export class ToolbarComponent {
  showSignUp: boolean = false;
  showSignIn: boolean = false;
  user: IUser = mockUser;

  openSignUp(){
    this.showSignUp = true;
  }

  closeSignUp = () => {
    this.showSignUp = false;
  };

  openSignIn(){
    this.showSignIn = true;
  }

  closeSignIn = () => {
    this.showSignIn = false;
  };
}
