import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { routing } from './app.routing';  //라우팅 모듈
import { HomeComponent } from './Component/HomeComponent';
import { ProductComponent } from './Component/ProductComponent'; 
import { ProductDetailComponent} from './Component/ProductDetailComponent'
import { ChatComponent } from './Component/Chat';

@NgModule({
  declarations: [
    AppComponent
    , HomeComponent
    , ProductComponent
    , ProductDetailComponent
    , ChatComponent
  ],
  imports: [
    BrowserModule
    , routing       //라우팅 모듈 임포트
  ],
  providers: [],
  bootstrap: [AppComponent]
}) 
export class AppModule { }
