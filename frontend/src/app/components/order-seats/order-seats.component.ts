import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from "@angular/router";
import { OrderService } from "../../services/seances.service";
import { TicketService } from "../../services/ticket.service"
import { ISeance } from "../../interfaces/ISeance";
import { ITicket } from "../../interfaces/ITicket";
import { mockUser } from '../../mocks/user';
import { IUser } from "../../interfaces/IUser";
import emitter from "../../utils/eventEmitter";
import {UsersService} from "../../services/user.service";


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
  processing: ITicket[] = [];
  user: IUser | null = localStorage.getItem("user") ? JSON.parse(localStorage.getItem("user")) : null;

  showConfirm: boolean = false;

  constructor(private orderService: OrderService,
              private ticketService: TicketService,
              public route: ActivatedRoute,
              private userService: UsersService) {

  }

  ngOnInit() {
    this.route.params.subscribe(async (params) => {
      this.id = +params['id']; // (+) converts string 'id' to a number
      const seances = await this.orderService.getOne(this.id).toPromise();
      this.seances = Array.isArray(seances) ? seances : [seances];
      if (this.seances.length) {
        // this.currentSeance = seances[0];
        this.onSeanceChange(seances[0]);
      }
    });

    emitter.subscribe('CHANGE_USER', () => {
      this.user = localStorage.getItem("user") ? JSON.parse(localStorage.getItem("user")) : null;
    });
  }

  async onSeanceChange(value) {
    this.currentSeance = value;
    // TODO: make service request to load
    // const result = await this.ticketService.getSeatForSeance(this.id).toPromise(); // все занятые места
    // console.log(result);
    this.tickets = await this.ticketService.getSeatForSeance(this.id).toPromise(); // все занятые места
    // this.tickets = [];
    this.seats = this.seats.map((row, rowIndex) => {
      return row.map((column, columnIndex) => {
        return this.tickets.some((ticket) => ticket.line === rowIndex && ticket.seat === columnIndex) ? 'reserved' : 'available';
      });
    });

  }

  processSeat(line, seat) {
    if (this.user) {
      switch (this.seats[line][seat]) {
        case 'available': {
          const tempSeats = [...this.seats];
          console.log(tempSeats);
          tempSeats[line][seat] = 'processing';
          this.seats = tempSeats;
          const tempProcessing = [...this.processing];
          tempProcessing.push({
            seanceid: this.id,
            line,
            seat,
            userid: this.user.id
          });
          this.processing = tempProcessing;
        }
          break;
        case 'processing': {
          const tempSeats = [...this.seats];
          tempSeats[line][seat] = 'available';
          this.seats = tempSeats;
          this.processing = this.processing
            .filter(
              (ticket) =>
                (
                  ticket.line !== line
                  && ticket.seat !== seat
                ) || ticket.seat !== seat
                || ticket.line !== line
            );
        }
          break;
        default:
          break;
      }
      console.log(this.processing);
    }
  }
  // processSeat(line, seat) {
  //   switch(this.seats[line][seat]) {
  //     case 'available': {
  //       const tempSeats = [...this.seats];
  //       tempSeats[line][seat] = 'processing';
  //       this.seats = tempSeats;
  //     } break;
  //     case 'processing': {
  //       const tempSeats = [...this.seats];
  //       tempSeats[line][seat] = 'available';
  //       this.seats = tempSeats;
  //     } break;
  //     default: break;
  //   }
  // }


    onOpenConfirm() {
    this.showConfirm = true;
  }

  onConfirmClose = () => {
    this.showConfirm = false;
  };

  onOrderTickets = async () => {
    await this.ticketService.sendTickets(this.processing).toPromise();
    if (this.user) {
      this.userService.getOne(this.user.id).subscribe((user) => {
        this.user = user;
        localStorage.setItem('user', JSON.stringify(user));
        emitter.emit('CHANGE_USER');

      });
    }
  }

}
