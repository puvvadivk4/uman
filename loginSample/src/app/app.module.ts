import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { RouterModule, Routes } from '@angular/router';
import { ComponentOneComponent } from './component-one/component-one.component';
import { HeaderComponent } from './header/header.component';
import { LoginComponent } from './login/login.component';
import { FooterComponent } from './footer/footer.component';
import { AppRoutingModule } from './/app-routing.module';
import { LoginSuccessComponent } from './login-success/login-success.component';
import {TooltipModule} from 'primeng/tooltip';
import {DialogModule} from 'primeng/dialog';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NavgridgridComponent } from './navgridgrid/navgridgrid.component';

const routes: Routes = [
  // {path:'' , component:LoginComponent },
  {
    path: 'dashboard', component: AppComponent
  },
  {
    path: 'heroes', component: LoginSuccessComponent
  },

  {
    path: 'login', component: LoginComponent
  },
  {
    path:'main', component:NavgridgridComponent
  }

];
@NgModule({
  declarations: [
    AppComponent,
    ComponentOneComponent,
    HeaderComponent,
    LoginComponent,
    FooterComponent,
    LoginSuccessComponent,
    NavgridgridComponent
  ],
  imports: [
    BrowserModule, FormsModule, RouterModule, AppRoutingModule, RouterModule.forRoot(routes),TooltipModule,
    DialogModule,BrowserAnimationsModule

  ],
  providers: [],
  bootstrap: [LoginComponent]
})
export class AppModule { }
