import { Component } from "@angular/core";
import { faTrash } from "@fortawesome/free-solid-svg-icons";
import { Room } from './../../../models/room.model';
import { RoomService } from './../room.service';

@Component({
    templateUrl: './room-pesquisa-component.html'
})
export class RoomPesquisaComponent {
    public faTrash = faTrash;
    public rooms: Room[]
    private params:any;

    constructor(private roomService: RoomService) { }
    
    find(room: Room) {
        this.roomService.find(this.getParams(room))
            .subscribe(resp => this.rooms = resp);
    }

    private getParams(room:Room){
        let params: any = {}
        if(room?.name){
            params.name = room.name;
        }
        if(room?.startAt){
            params.startAt = room.startAt;
        }
        if(room?.endAt){
            params.endAt = room.endAt;
        }
        this.params = params;
        return params;
    }

    delete(id:number){
        this.roomService.delete(id).subscribe(()=>{
            this.find(this.params);
        });
    }
}