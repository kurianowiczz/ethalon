import {Component, Input, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {OrderService} from "../../services/seances.service";
import {TicketService} from "../../services/ticket.service"
import {ISeance} from "../../interfaces/ISeance";
import {ITicket} from "../../interfaces/ITicket";

@Component({
  selector: 'app-order-seats',
  templateUrl: './order-seats.component.html',
  styleUrls: ['./order-seats.component.css']
})
export class OrderSeatsComponent implements OnInit{
  id: number;
  seances: ISeance[] = [];
  tickets: ITicket[] = [];
  seats: string[][] = new Array(5).fill(new Array(5).fill('available'));
  currentSeance: ISeance;

  constructor(private orderService: OrderService,
              private ticketService: TicketService,
              public route: ActivatedRoute) {

  }

  ngOnInit() {
    this.route.params.subscribe(async (params) => {
      this.id = +params['id']; // (+) converts string 'id' to a number
      const seances = await this.orderService.getOne(this.id).toPromise();
      seances.forEach(el => console.log(el));
      this.seances = seances;
      if (seances.length) {
        // this.currentSeance = seances[0];
        this.onSeanceChange(seances[0]);
      }
    });

    // this.route.params.subscribe(async (params) => {
    //   this.id = +params['id']; // (+) converts string 'id' to a number
    //   const movies = await this.ticketService.getMovieById(this.id).toPromise();
    //   movies.forEach(el => console.log(el));
    //   this.movies = movies;
    //   });
  }

  async onSeanceChange(value) {
    this.currentSeance = value;
    // TODO: make service request to load
    this.tickets = await this.ticketService.getSeatForSeance(this.id).toPromise(); // все занятые места
    this.seats = this.seats.map((row, rowIndex) => {
      return row.map((column, columnIndex) => {
        return this.tickets.some((ticket) => ticket.line === rowIndex && ticket.seat === columnIndex) ? 'reserved' : 'available';
      });
    });

  }

  processSeat(line, seat) {
    switch(this.seats[line][seat]) {
      case 'available': {
        const tempSeats = [...this.seats];
        tempSeats[line][seat] = 'processing';
        this.seats = tempSeats;
      } break;
      case 'processing': {
        const tempSeats = [...this.seats];
        tempSeats[line][seat] = 'available';
        this.seats = tempSeats;
      } break;
      default: break;
    }
  }

}
