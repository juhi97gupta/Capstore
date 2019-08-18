import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent }  from './component/component';
import { AddProductClass } from './addproduct/addProduct';
import { FormsModule} from '@angular/forms';
import { HttpClientModule} from '@angular/common/http';
import { RouterModule,Routes } from '@angular/router';
import { ShowProductClass } from './showproduct/showAll';



    const routes: Routes = [
        { path: '', redirectTo: 'showProduct', pathMatch: 'full' },
       { path: 'addProduct', component:AddProductClass },
       { path: 'showProduct', component:ShowProductClass }
    ];

@NgModule({
    imports: [
        BrowserModule, RouterModule.forRoot(routes),HttpClientModule,FormsModule    
    ],
    
    declarations: [
        AppComponent, ShowProductClass, AddProductClass    
		],
    providers: [ ],
    bootstrap: [AppComponent]
})

export class AppModule { }