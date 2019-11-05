import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-order-seats',
  templateUrl: './order-seats.component.html',
  styleUrls: ['./order-seats.component.css']
})
export class OrderSeatsComponent {
  seats: number[][] = new Array(8).fill(new Array(2).fill(0));

}
