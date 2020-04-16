var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
import { Component } from '@angular/core';
var TemplateReferenceVariablesComponent = (function () {
    function TemplateReferenceVariablesComponent() {
    }
    Object.defineProperty(TemplateReferenceVariablesComponent.prototype, "init", {
        get: function () {
            return { num1: 10, num2: 20 };
        },
        enumerable: true,
        configurable: true
    });
    return TemplateReferenceVariablesComponent;
}());
TemplateReferenceVariablesComponent = __decorate([
    Component({
        selector: 'app-template-reference-variables',
        template: "\n  <input #num1 type=\"number\" value=\"{{init.num1}}\" (input)=\"0\">  + \n  <input #num2 type=\"number\" value=\"{{init.num2}}\" (input)=\"0\">\n  = {{num1.valueAsNumber + num2.valueAsNumber}}<br>\n\n  <input ref-number1 type=\"number\" value=\"{{init.num1}}\" (input)=\"0\">  + \n  <input ref-number2 type=\"number\" value=\"{{init.num2}}\" (input)=\"0\">\n  = {{number1.valueAsNumber + number2.valueAsNumber}}"
    })
], TemplateReferenceVariablesComponent);
export { TemplateReferenceVariablesComponent };
//# sourceMappingURL=E:/git/Angular/template/src/app/template-reference-variables/template-reference-variables.component.js.map