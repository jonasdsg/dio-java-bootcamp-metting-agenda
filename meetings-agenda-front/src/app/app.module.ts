import { RoomModule } from './components/room/room.module';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { RouterModule } from '@angular/router';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    RouterModule,
    RoomModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
