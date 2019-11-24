import { Component, OnInit } from '@angular/core';
import { MoviesService } from "../../services/movie.service";
import { IMovie } from "../../interfaces/IMovie";
import { ActivatedRoute } from '@angular/router';
@Component({
  selector: 'app-movie-page',
  templateUrl: './movie-page.component.html',
  styleUrls: ['./movie-page.component.css']
})
export class MoviePageComponent implements OnInit{
  id: number;
  movie: IMovie | null = null;

  openOrder(event){
    // window.location.replace('http://localhost:4301/order');
  }

  constructor(private movieService: MoviesService, public route: ActivatedRoute) {

  }

  ngOnInit() {
    this.route.params.subscribe(async (params) => {
      this.id = +params['id']; // (+) converts string 'id' to a number
      const movie = await this.movieService.getOne(this.id).toPromise();
      // console.log(movie);
      this.movie = movie;

      // In a real app: dispatch action to load the details here.
    });
    // @ts-ignore
  }

}
