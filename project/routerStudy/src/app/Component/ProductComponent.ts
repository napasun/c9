import { Component, ViewEncapsulation } from '@angular/core';

@Component({
	selector : 'product',
	template : '<h1 class="product">Product Details Component</h1>',
	styles : [':host { backgroud : yellow}']
	, encapsulation : ViewEncapsulation.Emulated
	
})
export class ProductComponent {}
