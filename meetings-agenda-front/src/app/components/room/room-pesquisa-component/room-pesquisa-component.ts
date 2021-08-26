import { Component } from "@angular/core";
import { Room } from './../../../models/room.model';
import { RoomService } from './../room.service';

@Component({
    templateUrl: './room-pesquisa-component.html'
})
export class RoomPesquisaComponent {
    public rooms: Room[]
    
    constructor(private roomService: RoomService) { }
    
    find(room: Room) {
        // this.roomService.find(this.getParams(room))
        //     .subscribe(resp => this.rooms = resp);
        this.rooms = [
            {
                "id": 1,
                "name": "SPRING",
                "startAt": "2021-08-26T00:14:06.094",
                "endAt": "2021-08-26T00:14:06.094"
            },
            {
                "id": 2,
                "name": "RECRUTAMENTO",
                "startAt": "2021-08-26T00:14:06.094",
                "endAt": "2021-08-26T00:14:06.094"
            },
            {
                "id": 3,
                "name": "ANGULAR",
                "startAt": "2021-08-26T00:14:06.094",
                "endAt": "2021-08-26T00:14:06.094"
            }
        ]
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
        return params;
    }

    getEndingDateHour(date: string) { }
    getStartingDateHour(date: string) { }
}