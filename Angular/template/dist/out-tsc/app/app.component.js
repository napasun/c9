var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
import { Component } from '@angular/core';
var AppComponent = (function () {
    function AppComponent() {
        this.title = 'app works!';
    }
    return AppComponent;
}());
AppComponent = __decorate([
    Component({
        selector: 'app-root',
        template: "\n  <div class=\"left-menu\">\n      <div class=\"menu\">\n        <a routerLink=\"/\">\n          <h1>\uD0EC\uD50C\uB9BF</h1>\n        </a>\n        <ol class=\"tree-list\">            \n          <li><a routerLink=\"/interpolation\">\uC0BD\uC785\uC2DD (interpolation)</a></li>\n          <li><a routerLink=\"/oneway-expression\">\uB2E8\uBC29\uD5A5 \uBC14\uC778\uB529 (\uD45C\uD604\uC2DD) </a></li>\n          <li><a routerLink=\"/oneway-statement\">\uB2E8\uBC29\uD5A5 \uBC14\uC778\uB529 (\uBA85\uB839\uC2DD)</a></li>\n          <li><a routerLink=\"/twoway-ngmodel\">\uC591\uBC29\uD5A5 \uBC14\uC778\uB529 (ngModel)</a></li>\n          <li><a routerLink=\"/ngclass\">\uC18D\uC131\uC9C0\uC2DC\uC790 (ngClass)</a></li>\n          <li><a routerLink=\"/ngstyle\">\uC18D\uC131\uC9C0\uC2DC\uC790 (ngStyle)</a></li>\n          <li><a routerLink=\"/ngif\">\uAD6C\uC870\uC9C0\uC2DC\uC790 (ngIf)</a></li>\n          <li><a routerLink=\"/ngswitch\">\uAD6C\uC870\uC9C0\uC2DC\uC790 (ngSwitch)</a></li>\n          <li><a routerLink=\"/ngfor\">\uAD6C\uC870\uC9C0\uC2DC\uC790 (ngFor)</a></li>\n          <li><a routerLink=\"/template-ngfor\">\uAD6C\uC870\uC9C0\uC2DC\uC790 (\uD0EC\uD50C\uB9BF ngFor)</a></li>\n          <li><a routerLink=\"/template-input-variables\">\uD0EC\uD50C\uB9BF \uC785\uB825\uBCC0\uC218</a></li>\n          <li><a routerLink=\"/template-reference-variables\">\uD0EC\uD50C\uB9BF \uCC38\uC870\uBCC0\uC218</a></li>\n        </ol>\n    </div>     \n  </div>\n  <div class=\"play-box\">\n    <router-outlet></router-outlet>\n  </div>",
        styles: [""]
    })
], AppComponent);
export { AppComponent };
//# sourceMappingURL=E:/git/Angular/template/src/app/app.component.js.map