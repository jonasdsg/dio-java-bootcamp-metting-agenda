import { RoomPesquisaComponent } from './room-pesquisa-component/room-pesquisa-component';
import { CommonModule, DatePipe } from "@angular/common";
import { NgModule } from "@angular/core";
import { ReactiveFormsModule } from "@angular/forms";
import { HttpClientModule } from '@angular/common/http'
import { RoomComponent } from './room-component/room-component';
import { RoomRouting } from './room.routing';

@NgModule({
    declarations:[
        RoomComponent,
        RoomPesquisaComponent
    ],
    imports:[
        CommonModule,
        ReactiveFormsModule,
        HttpClientModule
    ],
    exports:[
        RoomRouting
    ]
})
export class RoomModule {}