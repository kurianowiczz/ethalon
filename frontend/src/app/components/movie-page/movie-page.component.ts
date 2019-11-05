import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-movie-page',
  templateUrl: './movie-page.component.html',
  styleUrls: ['./movie-page.component.css']
})
export class MoviePageComponent {

  openOrder(event){
    window.location.replace('http://localhost:4301/order');
  }


}
