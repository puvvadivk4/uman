import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  private show = true;
  constructor() { }

  ngOnInit() {
    this.show=true;
  }
  shw() {
    this.show = false;
  }
}
