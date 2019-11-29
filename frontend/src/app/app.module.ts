import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";
import { AppComponent } from "./app.component";
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {RouterModule, Routes} from "@angular/router";
import {MoviesListComponent} from "./components/movies-list/movies-list.component";
import {OrderSeatsComponent} from "./components/order-seats/order-seats.component";
import {MoviePageComponent} from "./components/movie-page/movie-page.component";
import {ToolbarComponent} from "./components/toolbar/toolbar.component";
import {MovieComponent} from "./components/movie/movie.component";
import { FormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { PopupComponent } from './components/popup/popup.component';
import { FooterComponent } from './components/footer/footer.component';
import {APIInterceptor} from "./interceptors/api-interceptor";
import {UsersService} from "./services/user.service";

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
    PopupComponent,
    FooterComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(routes),
    FormsModule,
    BrowserAnimationsModule
  ],
  //providers: [],
  providers: [UsersService, APIInterceptor, {
    provide: HTTP_INTERCEPTORS,
    useClass: APIInterceptor,
    multi: true
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
