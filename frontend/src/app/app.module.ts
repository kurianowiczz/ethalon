import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";
import { AppComponent } from "./app.component";
import {HttpClientModule} from "@angular/common/http";
import {RouterModule, Routes} from "@angular/router";
import {MoviesListComponent} from "./components/movies-list/movies-list.component";
import {OrderSeatsComponent} from "./components/order-seats/order-seats.component";
import {MoviePageComponent} from "./components/movie-page/movie-page.component";
import {ToolbarComponent} from "./components/toolbar/toolbar.component";
import {MovieComponent} from "./components/movie/movie.component";
import { FormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { PopupComponent } from './components/popup/popup.component';


const routes: Routes = [
  {path: '', component: MoviesListComponent},
  {path: 'movie/:id', component: MoviePageComponent},
  {path: 'order/:id', component: OrderSeatsComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    MoviesListComponent,
    MovieComponent,
    ToolbarComponent,
    MoviePageComponent,
    OrderSeatsComponent,
    PopupComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(routes),
    FormsModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
