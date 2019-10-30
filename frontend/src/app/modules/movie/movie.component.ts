import {Component, Input, OnInit} from '@angular/core';
import IMovie from '../../interfaces/IMovie';

@Component({
  selector: 'app-movie',
  templateUrl: './movie.component.html',
  styleUrls: ['./movie.component.css']
})
export class MovieComponent implements OnInit {

  constructor() { }
  @Input('data') data: IMovie;

  myEvent(event){
    console.log('event');
  }

  ngOnInit() {
  }

}
