var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
import { Component } from '@angular/core';
var OnewayExpressionComponent = (function () {
    function OnewayExpressionComponent() {
        this.greeting = "hello";
    }
    return OnewayExpressionComponent;
}());
OnewayExpressionComponent = __decorate([
    Component({
        selector: 'app-oneway-expression',
        template: "\n  {{greeting}}<br>\n  <input type=\"text\" [value]=\"greeting\">\n  <input type=\"text\" bind-value=\"greeting\">\n  <input type=\"text\" [attr.value]=\"greeting\">"
    })
], OnewayExpressionComponent);
export { OnewayExpressionComponent };
//# sourceMappingURL=E:/git/Angular/template/src/app/oneway-expression/oneway-expression.component.js.map