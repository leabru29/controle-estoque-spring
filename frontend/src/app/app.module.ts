import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './layouts/header/header.component';
import { FooterComponent } from './layouts/footer/footer.component';
import { SideNavComponent } from './layouts/side-nav/side-nav.component';
import { MainComponent } from './layouts/main/main.component';
import { TopWidgetsComponent } from './layouts/top-widgets/top-widgets.component';
import { SalesByMonthComponent } from './layouts/sales-by-month/sales-by-month.component';
import { SalesByCategoryComponent } from './layouts/sales-by-category/sales-by-category.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    SideNavComponent,
    MainComponent,
    TopWidgetsComponent,
    SalesByMonthComponent,
    SalesByCategoryComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
