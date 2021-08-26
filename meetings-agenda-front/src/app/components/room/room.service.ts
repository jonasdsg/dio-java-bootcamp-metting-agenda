import { Room } from './../../models/room.model';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

const BACKEND_URL = "http://localchost:8080";

@Injectable({
    providedIn: 'root'
})
export class RoomService {
    private baseUrl: string;
    private options:any = { headers: new HttpHeaders({ 'Content-Type': 'application/json', 'Access-Control-Allow-Origin':'*' }), };

    constructor(private http: HttpClient) {
        this.baseUrl = BACKEND_URL + '/room';
    }

    findById(id:number){
        return this.http.get(`${this.baseUrl}/${id}`, this.options) as unknown as Observable<Room>;
    }

    find(params:any): Observable<Room[]>{
        this.options.params = params;
        return this.http.get(this.baseUrl, this.options) as unknown as Observable<Room[]>;
    }

    save(room:Room){
        this.options.body = room;
        return this.http.post(`${this.baseUrl}`,this.options) as unknown as Observable<Room>;
    }

}