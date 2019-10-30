import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-order-seats',
  templateUrl: './order-seats.component.html',
  styleUrls: ['./order-seats.component.less']
})
export class OrderSeatsComponent implements OnInit {
  seats: number[][] = new Array(8).fill(new Array(2).fill(0));

  constructor() { }

  ngOnInit() {
  }

}
