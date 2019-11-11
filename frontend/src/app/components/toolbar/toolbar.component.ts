import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-toolbar',
  templateUrl: './toolbar.component.html',
  styleUrls: ['./toolbar.component.css']
})
export class ToolbarComponent {
  showSignUp: boolean = false;
  showSignIn: boolean = false;

  openSignUp(){
    this.showSignUp = true;
  }

  closeSignUp(){
    this.showSignUp = false;
    console.log(this.showSignUp);
  }

  openSignIn(){
    this.showSignIn = true;
  }

  closeSignIn(){
    this.showSignIn = false;
  }
}
