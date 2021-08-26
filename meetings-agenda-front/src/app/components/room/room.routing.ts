import { RoomPesquisaComponent } from './room-pesquisa-component/room-pesquisa-component';
import { RouterModule } from '@angular/router';
import { NgModule } from "@angular/core";
import { RoomCadastroComponent } from './room-cadastro-component/room-cadastro-component';

@NgModule({
    imports:[
        RouterModule.forRoot([
            {
                path: 'pesquisa',
                component: RoomPesquisaComponent
            },
            {
                path: 'cadastrar',
                component: RoomCadastroComponent
            }
        ])
    ]
})
export class RoomRouting {}