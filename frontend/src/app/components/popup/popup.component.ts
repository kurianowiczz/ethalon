import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-popup',
  templateUrl: './popup.component.html',
  styleUrls: ['./popup.component.css']
})
export class PopupComponent implements OnInit {

  @Input('onClose') onClose: Function;
  _isVisible: boolean = false;

  get isVisible() {
    return this._isVisible;
  }

  @Input ()
  set isVisible(isVisible: boolean) {
    this._isVisible = isVisible;
  }

  stopPropagation(event) {
    event.stopPropagation()
  }

  ngOnInit() {
  }

}
