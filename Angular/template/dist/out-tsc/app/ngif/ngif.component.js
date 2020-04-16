var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
import { Component } from '@angular/core';
var NgifComponent = (function () {
    function NgifComponent() {
        this.gender = 1;
    }
    return NgifComponent;
}());
NgifComponent = __decorate([
    Component({
        selector: 'app-ngif',
        template: "  \n  <select [(ngModel)]=\"gender\">      \n      <option value=1>\uB0A8\uC790</option>\n      <option value=2>\uC5EC\uC790</option>\n  </select>\n\n  <h2 *ngIf=\"gender == 1\">\uB0A8\uC790\uAC00 \uC120\uD0DD\uB428</h2>\n  <h2 *ngIf=\"gender == 2\">\uC5EC\uC790\uAC00 \uC120\uD0DD\uB428</h2>\n\n  <h3>    \n    <span template=\"ngIf gender == 1\">\uB0A8\uC790\uAC00 \uC120\uD0DD\uB428</span>\n    <span template=\"ngIf gender == 2\">\uC5EC\uC790\uAC00 \uC120\uD0DD\uB428</span>\n  </h3>  \n\n  <h4>\n    <template [ngIf]=\"gender == 1\">\uB0A8\uC790\uAC00 \uC120\uD0DD\uB428</template>\n    <template [ngIf]=\"gender == 2\">\uC5EC\uC790\uAC00 \uC120\uD0DD\uB428</template>    \n  </h4>"
    })
], NgifComponent);
export { NgifComponent };
//# sourceMappingURL=E:/git/Angular/template/src/app/ngif/ngif.component.js.map