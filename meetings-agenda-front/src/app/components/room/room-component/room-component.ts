import { Component, EventEmitter, Input, OnChanges, Output, SimpleChanges } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Room } from './../../../models/room.model';

@Component({
    selector: 'room-component',
    templateUrl: 'room-component.html'
})
export class RoomComponent implements OnChanges {
    @Input()
    public nomeDaTela: string;
    @Input()
    public nomeDoBotao: string;
    @Input()
    public room: Room = null;
    @Output()
    public whenEmitRoom: EventEmitter<Room> = new EventEmitter<Room>();

    public form: FormGroup;
    constructor(private fb: FormBuilder) { }

    ngOnChanges(changes: SimpleChanges): void {
        this.form = this.createForm(this.room);
    }

    emitter() {
        this.whenEmitRoom.emit(this.getParams());
    }

    private createForm(model?: Room): FormGroup {
        return this.fb.group({
            id: model?.id || null,
            name: model?.name || null,
            startAt: [model?.startAt || null, Validators.pattern('((\d\d\/){2}\d{4})')],
            endAt: model?.endAt || null,
            stHour:null,
            edHour:null,
        });
    }

    private getParams():Room {
        //Recurso técnico para converter hora kk
        let startAt:string = this.form.get('startAt').value;
        let endAt:string = this.form.get('endAt').value;
        let room:Room = this.form.getRawValue();

        if(startAt){
            let sdate:string[] = startAt.split('/');
            let startAtFullDate:string = `${sdate[2]}-${sdate[1]}-${sdate[0]}T`+this.form.get('stHour').value;
            room.startAt = startAtFullDate;
        }
        if(endAt){
            let edate:string[] = endAt.split('/');
            let endAtFullDate:string = `${edate[2]}-${edate[1]}-${edate[0]}T`+this.form.get('edHour').value;
            room.endAt = endAtFullDate;
        }
        return room;
    }
}