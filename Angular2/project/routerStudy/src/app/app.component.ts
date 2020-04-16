import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ChatComponent } from './Component/Chat';

@Component({
	selector : 'app-root',
	template : `
        <a [routerLink]="['/']">Home</a>
        <a [routerLink]="['/product']">Product</a>
        <a [routerLink]="['/productDetail/100']">Product Details</a>
        <a [routerLink]="[{ outlets : { aux : 'chat' }}]">Open Chat</a>
        <a [routerLink]="[{ outlets : { aux : null }}]">Close Chat</a>
        <a [routerLink]="['/luxury']">Luxury Items</a>
        
        <input type="button" value="Product" (click)="navigate()" /> 
        <router-outlet></router-outlet>
        <router-outlet name="aux"></router-outlet>
    `
})// router-outlet 컴포넌트를 렌더링 하는 영역 
export class AppComponent {
	constructor (private router : Router) {}

	navigate () {
		this.router.navigate(['/product']);
	}
}