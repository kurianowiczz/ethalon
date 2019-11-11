import {Component, Input, OnInit} from '@angular/core';
import {IMovie} from '../../interfaces/IMovie';
import {MoviesService} from "../../services/movie.service";

@Component({
  selector: 'app-movie',
  templateUrl: './movie.component.html',
  styleUrls: ['./movie.component.css']
})
export class MovieComponent{


  focused: boolean = false;

  @Input('data') data: IMovie;

  onFocus() {
    this.focused = true;
  }

  onBlur() {
    this.focused = false;
  }


}
