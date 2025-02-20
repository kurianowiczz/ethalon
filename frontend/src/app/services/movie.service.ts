import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {IMovie} from '../interfaces/IMovie';

@Injectable({providedIn: 'root'})
export class MoviesService {
  private readonly apiBaseUrl = 'http://localhost:8081/api';

  constructor(private http: HttpClient) { }


  getAll() {
    return this.http.get<IMovie[]>(`${this.apiBaseUrl}/movies/all`);
  }

  getOne(id) {
    return this.http.get<IMovie>(`${this.apiBaseUrl}/movies/id/${id}`);
  }

  create(movie: IMovie) {
    return this.http.post<IMovie>(`${this.apiBaseUrl}/movies/add`, movie);
  }


  delete(id) {
    return this.http.delete(`${this.apiBaseUrl}/movies/id/${id}`);
  }

  update(movie: IMovie) {
    return this.http.put<IMovie>(`${this.apiBaseUrl}/movies/${movie.id}`, {movie});
  }

}
