import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";
import { AppComponent } from "./app.component";
import {HttpClientModule} from "@angular/common/http";
import {RouterModule, Routes} from "@angular/router";
import {MoviesListComponent} from "./modules/movies-list/movies-list.component";
import {OrderSeatsComponent} from "./modules/order-seats/order-seats.component";
import {MoviePageComponent} from "./modules/movie-page/movie-page.component";
import {ToolbarComponent} from "./modules/toolbar/toolbar.component";
import {MovieComponent} from "./modules/movie/movie.component";

const routes: Routes = [
  {path: '', component: MoviesListComponent},
  {path: 'movie', component: MoviePageComponent},
  {path: 'order', component: OrderSeatsComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    MoviesListComponent,
    MovieComponent,
    ToolbarComponent,
    MoviePageComponent,
    OrderSeatsComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(routes )
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
