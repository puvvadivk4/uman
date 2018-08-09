import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  private hideElement;
  display: boolean = false;
  constructor(private router: Router){
    this.hideElement=false;
  }
 

    showDialog() {
        this.display = true;
        
    }
  goToLoginPage(){
  this.router.navigateByUrl("/login");
  this.hideElement=true;
  }
  anc()
  {
    this.router.navigateByUrl("/login");
    this.hideElement=true;
  }
}
