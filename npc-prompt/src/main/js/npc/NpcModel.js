import axios from 'axios';
import { Subscriber, from, Observable } from 'rxjs';
import { map } from 'rxjs/operators'
import Npc from './Npc';

class NpcModel {

    constructor(){
        this.client = axios.create({
          baseURL: 'http://localhost:8080/',
          timeout: 1000
        });
    }

    getNpc = ()=> {
    console.log("Get NPC");
    return from(this.client.get('/npc'))
        .pipe(map(resp => resp.data))
        .pipe(map(Npc.parse))
        };

}

export default NpcModel;