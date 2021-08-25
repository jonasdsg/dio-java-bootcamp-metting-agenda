import { RoomComponent } from './room-component/room-component';
import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { ReactiveFormsModule } from "@angular/forms";

@NgModule({
    declarations:[
        RoomComponent
    ],
    imports:[
        CommonModule,
        ReactiveFormsModule,
    ],
    exports:[RoomComponent]
})
export class RoomModule {}