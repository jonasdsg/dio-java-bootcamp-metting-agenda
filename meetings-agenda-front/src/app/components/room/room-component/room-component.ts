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
        return this.form.getRawValue();
    }
}