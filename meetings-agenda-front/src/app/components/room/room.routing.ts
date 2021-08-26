import { RoomPesquisaComponent } from './room-pesquisa-component/room-pesquisa-component';
import { RouterModule } from '@angular/router';
import { NgModule } from "@angular/core";

@NgModule({
    imports:[
        RouterModule.forRoot([
            {
                path: 'pesquisa',
                component: RoomPesquisaComponent
            }
        ])
    ]
})
export class RoomRouting {}