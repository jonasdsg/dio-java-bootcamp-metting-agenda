import { Room } from './../../../models/room.model';
import { RoomService } from './../room.service';
import { Component } from "@angular/core";

@Component({
    templateUrl:'room-cadastro-component.html'
})
export class RoomCadastroComponent{
    constructor(private roomService:RoomService){}

    create(room:Room){
        console.log(room)
        this.roomService.save(room).subscribe(console.log);
    }
}