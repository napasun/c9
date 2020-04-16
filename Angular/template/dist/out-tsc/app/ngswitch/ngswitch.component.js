var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
import { Component } from '@angular/core';
var NgswitchComponent = (function () {
    function NgswitchComponent() {
        this.grade = 'null';
    }
    return NgswitchComponent;
}());
NgswitchComponent = __decorate([
    Component({
        selector: 'app-ngswitch',
        template: "\n  <div>\n  <button (click)=\"grade='admin'\" \n  [style.font-weight]=\"grade=='admin'?'bold':'normal'\">\uC6B4\uC601\uC790</button>\n\n  <button (click)=\"grade='member'\" \n  [style.font-weight]=\"grade=='member'?'bold':'normal'\">\uD68C\uC6D0</button>\n\n  <button (click)=\"grade='guest'\" \n  [style.font-weight]=\"grade=='guest'?'bold':'normal'\">\uC190\uB2D8</button>\n  </div><br>\n  \n  <p *ngIf=\"grade=='null'\">\uD68C\uC6D0\uB4F1\uAE09\uC744 \uC120\uD0DD\uD574\uC8FC\uC138\uC694</p>\n  <p *ngIf=\"grade!='null'\">{{grade}} \uB4F1\uAE09\uC774 \uC120\uD0DD\uB428</p>\n\n  <div [ngSwitch]=\"grade\">\n    <h3 *ngSwitchCase=\"'null'\">\uD68C\uC6D0\uB4F1\uAE09\uC744 \uC120\uD0DD\uD574\uC8FC\uC138\uC694</h3>\n    <h3 *ngSwitchCase=\"'admin'\">\uC6B4\uC601\uC790\uAC00 \uC120\uD0DD\uB428</h3>\n    <h3 *ngSwitchCase=\"'member'\">\uD68C\uC6D0\uC774 \uC120\uD0DD\uB428</h3>\n    <h3 *ngSwitchDefault>\uC190\uB2D8 \uC120\uD0DD</h3>\n  </div>\n\n  <p [ngSwitch]=\"grade\">\n    <template ngSwitchCase=\"null\">\uD68C\uC6D0\uB4F1\uAE09\uC744 \uC120\uD0DD\uD574\uC8FC\uC138\uC694</template>\n    <template [ngSwitchCase]=\"'admin'\">\uC6B4\uC601\uC790\uAC00 \uC120\uD0DD\uB428</template>\n    <template [ngSwitchCase]=\"'member'\">\uD68C\uC6D0\uC774 \uC120\uD0DD\uB428</template>\n    <template ngSwitchDefault>\uC190\uB2D8 \uC120\uD0DD</template>\n  </p>"
    }),
    __metadata("design:paramtypes", [])
], NgswitchComponent);
export { NgswitchComponent };
//# sourceMappingURL=E:/git/Angular/template/src/app/ngswitch/ngswitch.component.js.map