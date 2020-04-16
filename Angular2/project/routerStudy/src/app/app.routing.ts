import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './Component/HomeComponent';
import { ProductComponent } from './Component/ProductComponent';
import { ProductDetailComponent } from './Component/ProductDetailComponent';
import { ChatComponent } from './Component/Chat';

const routes : Routes = [
	{ path : '', component : HomeComponent }
	, { path : 'product', component : ProductComponent }
	, { path : 'productDetail/:id', component : ProductDetailComponent }
	, { path : 'chat', component : ChatComponent, outlet : 'aux' }
	, { path : 'luxury', loadChildren : './lazy.module' }	//지연 로딩
	//** 모든 페이지
	//
];
export const routing = RouterModule.forRoot(routes);
