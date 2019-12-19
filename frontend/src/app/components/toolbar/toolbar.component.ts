import {Component, OnInit} from '@angular/core';
import {IUser} from "../../interfaces/IUser";
// import {mockUser} from "../../mocks/user";
import {UsersService, AuthToken} from "../../services/user.service";
import {ILoginModel} from "../../interfaces/ILoginModel";
import {StorageService} from "../../services/storage.service";
import {HttpParams} from "@angular/common/http";
import emitter from "../../utils/eventEmitter";

@Component({
  selector: 'app-toolbar',
  templateUrl: './toolbar.component.html',
  styleUrls: ['./toolbar.component.css']
})
export class ToolbarComponent implements OnInit {
  showSignUp: boolean = false;
  showSignIn: boolean = false;
  success: boolean = false;
  fail: boolean = false;
  showTickets: boolean = false;
  successLogin: boolean = false;
  failLogin: boolean = false;
  showLogout: boolean = false;
  successLogout: boolean = false;
  failLogout: boolean = false;

  user: IUser | null = localStorage.getItem("user") ? JSON.parse(localStorage.getItem("user")) : null;
  userName: string;
  password: string;

  public loginModel: ILoginModel = {};
  public showCheckYourSetDataAlert: boolean = false;

  constructor(private userService: UsersService,
              private storageService: StorageService) {

  }

  openSignUp() {
    this.showSignUp = true;
  }

  closeSignUp = () => {
    this.showSignUp = false;
  };

  openSignIn() {
    this.showSignIn = true;
  }

  closeSignIn = () => {
    this.showSignIn = false;
  };

  openSuccess = () => {
    this.success = true;
  };

  closeSuccess = () => {
    this.success = false;
    this.closeSignUp();
  };

  openFail = () => {
    this.fail = true;
  };

  closeFail = () => {
    this.fail = false;
    this.closeSignUp();
  };

  openTickets = () => {
    this.showTickets = true;
  };

  closeTickets = () => {
    this.showTickets = false;
  };

  openSuccessLogin = () => {
    this.successLogin = true;
  };

  closeSuccessLogin = () => {
    this.successLogin = false;
    this.closeSignUp();
  };

  openFailLogin = () => {
    this.failLogin = true;
  };

  closeFailLogin = () => {
    this.failLogin = false;
    this.closeSignUp();
  };

  openLogout() {
    this.showLogout = true;
  }

  closeLogout = () => {
    this.showLogout = false;
  };

  openSuccessLogout = () => {
    this.success = true;
  };

  closeSuccessLogout = () => {
    this.success = false;
    this.closeSignUp();
  };

  openFailLogout = () => {
    this.fail = true;
  };

  closeFailLogout = () => {
    this.fail = false;
    this.closeSignUp();
  };

  reg() {
    if (!this.validate(this.userName, this.password)){
      this.openFail();
      return;
    }
    this.userService.create({
      username: this.userName,
      password: this.password
    })
      .subscribe(
        (user) => {
          localStorage.setItem('user', JSON.stringify(user));
          emitter.emit('CHANGE_USER');
          this.user = user;
          this.openSuccess();
        },
        (error) => {
          console.log(error);
          this.openFail();
        });

  }

  validate(userName: string, password: string) {
    return userName.match(/[a-zA-Z_]+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}/) &&
      password.match(/^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}/);
  }

  // register = async() => {
  //   const user = await this.userService.create({
  //     userName: this.userName,
  //     password: this.password
  //   }).toPromise();
  //   localStorage.setItem('user', JSON.stringify(user));
  //   this.closeSignIn();
  //   //this.ngOnInit();
  //
  // };

  login() {
    if (!this.validate(this.loginModel.username, this.loginModel.password)){
      this.openFailLogin();
      return;
    }
    this.userService.generateToken(this.loginModel)
      .subscribe((authToken: AuthToken) => {
        if (authToken.token) {
          this.storageService.setToken(authToken.token);
          this.userService.getAuthorizedUser()
            .subscribe((userModel: IUser) => {
              this.storageService.setCurrentUser(userModel);
              emitter.emit('CHANGE_USER');
              this.user = userModel;
            });
          this.closeSignIn();
          this.openSuccessLogin();

        }
      }, (error) => {
        if (error.status === 401) {
          this.showCheckYourSetDataAlert = true;
        } else {
          this.openFailLogin();
        }
      });
  }

  logout() {
    this.user = null;
    this.storageService.clearToken();
    this.storageService.setCurrentUser(null);
    this.showLogout = false;
    emitter.emit('CHANGE_USER');
    this.openSuccessLogout();
  }


  async ngOnInit() {
    emitter.subscribe('CHANGE_USER', () => {
      this.user = localStorage.getItem("user") ? JSON.parse(localStorage.getItem("user")) : null;
    });
  }

  // update(id: number, user: IUser){
  //   const urlParams = new HttpParams().set("id", id.toString());
  //   return this.http.put(this.url)
  // }

}
