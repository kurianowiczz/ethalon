import {Component, OnInit} from '@angular/core';
import {IUser} from "../../interfaces/IUser";
import {mockUser} from "../../mocks/user";
import {UsersService, AuthToken} from "../../services/user.service";
import {ILoginModel} from "../../interfaces/ILoginModel";
import {StorageService} from "../../services/storage.service";

@Component({
  selector: 'app-toolbar',
  templateUrl: './toolbar.component.html',
  styleUrls: ['./toolbar.component.css']
})
export class ToolbarComponent {
  showSignUp: boolean = false;
  showSignIn: boolean = false;
  success: boolean = false;
  fail: boolean = false;
  user: IUser = mockUser;

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

  reg() {
    this.userService.create({
      userName: this.userName,
      password: this.password
    })
      .subscribe(
        (user) => {
          localStorage.setItem('user', JSON.stringify(user));
          this.openSuccess();
        },
        (error) => {
          console.log(error);
          this.openFail();
        });

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
    this.userService.generateToken(this.loginModel)
      .subscribe((authToken: AuthToken) => {
        if (authToken.token) {
          this.storageService.setToken(authToken.token);
          this.userService.getAuthorizedUser()
            .subscribe((userModel: IUser) => {
              this.storageService.setCurrentUser(userModel);
            });
          this.closeSignIn();
        }
      }, (error) => {
        if (error.status === 401) {
          this.showCheckYourSetDataAlert = true;
        } else {
          alert(error.message);
        }
      });
  }

  logout() {
    this.storageService.clearToken();
    this.storageService.setCurrentUser(null);
  }

  /*test() {
    this.userService.getOne(1).subscribe(value =>
    localStorage.setItem("token", value);
    this.userService.getCurentuser().sbcrive()

    )
  }*/


  async ngOnInit() {
    //this.user = await this.userService.getOne(id).toPromise();
  }

}
