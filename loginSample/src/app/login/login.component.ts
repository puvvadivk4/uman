import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
ngOnInit(){}
  constructor(private router: Router) {
this.edited=false;
  }
  private userName = '';
  private password = '';
  private edited:boolean;
  title = 'app';
  check() {
  //this.edited=true;
    this.router.navigateByUrl('/main');
    
  }
 // reset(form: NgForm) {
 //   this.userName = "";
 //   this.password = "";
 // }
  registerUser(form: NgForm) {
    //this.router.navigateByUrl('/main');
    // if (form["userName"] == 'myname' && form["password"] == 'password') {
    //   this.router.navigateByUrl('/main');
    // }
    // else if(form["userName"] == 'myname' && form["password"] == 'password'){

    // }
    // else
    // alert("Wrong credentials:"+"UserName:"+form["userName"] +"Password:"+ form["password"]);

  }

}
