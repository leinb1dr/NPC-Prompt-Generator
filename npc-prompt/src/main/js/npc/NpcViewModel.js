import NpcModel from './NpcModel';
import { concatMap } from 'rxjs/operators';
import EventBus from '../eventBus/EventBus';

class NpcViewModel {

    static #INSTANCE;

    static getInstance(){
        if(!NpcViewModel.#INSTANCE) NpcViewModel.#INSTANCE = new NpcViewModel();
        return NpcViewModel.#INSTANCE;
    }

    constructor(){
        this.npcModel = new NpcModel();
        EventBus.on('NpcRefresh')
            .pipe(concatMap(()=>{
                console.log("NPC Refresh");
                return this.getNpc();
            }))
            .subscribe(npc=>EventBus.emit('NpcUpdate',npc));
    }


    getNpc = ()=> this.npcModel.getNpc();
}

export default NpcViewModel;