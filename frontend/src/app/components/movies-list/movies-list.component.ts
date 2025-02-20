import {Component, OnInit} from '@angular/core';
import {IMovie} from '../../interfaces/IMovie';
import {MoviesService} from '../../services/movie.service';
import {IUser} from "../../interfaces/IUser";
import emitter from "../../utils/eventEmitter";

@Component({
  selector: 'app-movies-list',
  templateUrl: './movies-list.component.html',
  styleUrls: ['./movies-list.component.css'],

})
export class MoviesListComponent implements OnInit {
  movies: IMovie[] = [
    // {id: 1, name: 'Малефисента',
    //   description: 'Действие происходит через несколько лет после того, ' +
    //     'как Малефисента наложила злые чары на принцессу Аврору. ' +
    //     'Фильм рассказывает про сложную взаимосвязь между тёмной феей и будущей королевой, ' +
    //     'о новых союзниках и противниках в деле защиты волшебного леса и магических существах, которые в нем обитают.',
    //   type: 'adventure',
    //   image: 'https://s4.afisha.ru/mediastorage/41/b6/3158a31280e24feba2f188b8b641.jpg'},
    //
    // {id: 2, name: 'Джокер',
    //   description: 'Готэм, начало 1980-х годов. Комик Артур Флек живет с больной матерью, ' +
    //     'которая с детства учит его «ходить с улыбкой». ' +
    //     'Пытаясь нести в мир хорошее и дарить людям радость, ' +
    //     'Артур сталкивается с человеческой жестокостью и постепенно приходит к выводу,' +
    //     ' что этот мир получит от него не добрую улыбку, а ухмылку злодея Джокера.',
    //   type: 'horror',
    //   image: 'https://img.afisha.tut.by/static/media/340x0s/cover/05/2/joker-ru-sub-415552.jpg'},
    //
    // {id: 3, name: 'Эверест',
    //   description: 'Путешествие на самую высокую точку мира? Что может быть круче! ' +
    //     'Так решает Лу, когда случайно находит огромное, но очень милое чудовище посреди шумного мегаполиса. ' +
    //     'Пусть их преследуют ученые из сверхсекретной лаборатории, зато её новый друг умеет смешить и творить чудеса. ' +
    //     'Лу уверена, что поможет дружелюбному йети вернуться домой – на Эверест.',
    //   type: 'cartoon',
    //   image: 'https://s3.afisha.ru/mediastorage/63/d2/603a3e8886d549b7bf5d1a3fd263.jpg'},
    //
    // {id: 4, name: 'Терминатор 2',
    //   description: 'Легенда вернулась. Новейшие 3D-технологии от команды, работавшей над «Аватаром», ' +
    //     'и революционные спецэффекты в одном из лучших фантастических фильмов всех времен. ' +
    //     'Неуязвимый киборг нового поколения прибывает в наше время с миссией убить молодого Джона Коннора, ' +
    //     'будущего лидера сопротивления, которому суждено окончить войну людей и машин. ' +
    //     'Но на защиту Джона успевают отправить перепрограммированного терминатора Т-800. ' +
    //     'Теперь будущее всего человечества зависит от исхода схватки, разворачивающейся в наши дни.',
    //   type: 'militant',
    //   image: 'http://lamafilm.club/wp-content/uploads/2017/10/terminator-2.jpg'},
    //
    // {id: 5, name: 'Поменяться местами',
    //   description: 'Однажды утром он и она меняются местами. ' +
    //     'Он просыпается не успешным писателем в лучах славы, а простым учителем с непомерно завышенным эго. ' +
    //     'Его девушка, наоборот, теперь известная пианистка, которую зовет замуж крутой музыкальный продюсер. ' +
    //     'Он знает про нее все, а она — не помнит про него ничего. ' +
    //     'Чтобы разобраться в происходящем и вернуть свою прежнюю жизнь, ему нужно вновь завоевать ее сердце.',
    //   type: 'drama',
    //   image: 'https://kassir.kz/files/events/7207-M3KBEarj-1571893702.jpg '},
    //
    // {id: 6, name: 'Арахисовый сокол',
    //   description: 'Большое путешествие начинается с шага, а легендарное — с полета. ' +
    //     'Вылетев в окно, герой очутился в мире, где чего-то не хватало. ' +
    //     'Его новому другу — крупной суммы денег. Паре головорезов — головы друга. Молодой медсестре — любви. ' +
    //     'А ему — путешествий на плоту, погонь, пылающих костров и немного арахисового масла.',
    //   type: 'comedy',
    //   image: 'https://st.cherinfo.ru/afisha/main/4085.jpg'}
  ];

  showAdding: boolean = false;
  showDel: boolean = false;
  success: boolean = false;
  fail: boolean = false;

  id: number;
  name: string;
  type: string;
  description: string;
  price: number;
  image: string;

  user: IUser | null = localStorage.getItem("user") ? JSON.parse(localStorage.getItem("user")) : null;

  constructor(private movieService: MoviesService) {

  }

  openAdding = () => {
    this.showAdding = true;
  };

  closeAdding = () => {
    this.showAdding = false;
  };

  openDel = () => {
    this.showDel = true;
  };

  closeDel = () => {
    this.showDel = false;
  };

  openSuccess = () => {
    this.success = true;
  };

  closeSuccess = () => {
    this.success = false;
    this.closeAdding();
  };

  openFail = () => {
    this.fail = true;
  };

  closeFail = () => {
    this.fail = false;
    this.closeAdding();
  };

  addMovie = async() => {
    await this.movieService.create({
      name: this.name,
      type: this.type,
      description: this.description,
      price: this.price,
      image: this.image
    }).toPromise();
    this.ngOnInit();
    this.openSuccess();

  };

  deleteMovie = async() => {
    await this.movieService.delete(this.id).toPromise();
    this.ngOnInit();

  };


  async ngOnInit() {
    this.movies = await this.movieService.getAll().toPromise();
    emitter.subscribe('CHANGE_USER', () => {
      this.user = localStorage.getItem("user") ? JSON.parse(localStorage.getItem("user")) : null;
    });
  }

}
