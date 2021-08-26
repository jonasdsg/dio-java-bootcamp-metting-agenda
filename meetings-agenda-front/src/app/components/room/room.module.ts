import { RoomCadastroComponent } from './room-cadastro-component/room-cadastro-component';
import { RoomPesquisaComponent } from './room-pesquisa-component/room-pesquisa-component';
import { CommonModule, DatePipe } from "@angular/common";
import { NgModule } from "@angular/core";
import { ReactiveFormsModule } from "@angular/forms";
import { HttpClientModule } from '@angular/common/http'
import { RoomComponent } from './room-component/room-component';
import { RoomRouting } from './room.routing';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';

@NgModule({
    declarations:[
        RoomComponent,
        RoomPesquisaComponent,
        RoomCadastroComponent
    ],
    imports:[
        CommonModule,
        ReactiveFormsModule,
        HttpClientModule,
        FontAwesomeModule
    ],
    exports:[
        RoomRouting
    ]
})
export class RoomModule {}