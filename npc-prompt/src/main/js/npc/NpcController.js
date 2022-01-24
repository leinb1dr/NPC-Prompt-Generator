import React from 'react';
import NpcView from './NpcView';
import NpcViewModel from './NpcViewModel';
import Npc from './Npc';
import NpcAttribute from './NpcAttribute';
import Race from './Race';
import { Subscriber, Observable } from 'rxjs';
import EventBus from '../eventBus/EventBus';

class NpcController extends React.Component {

    constructor(props) {
        super(props);
        this.state = {npc: new Npc(new NpcAttribute(),new NpcAttribute(),new NpcAttribute(),new NpcAttribute(),
                                    new NpcAttribute(),new NpcAttribute(),new NpcAttribute(),new NpcAttribute(),
                                    new NpcAttribute(), new Race())};
        NpcViewModel.getInstance()
    }

    componentDidMount() {
        EventBus.on('NpcUpdate').subscribe(this.updateNpc);
        EventBus.emit('NpcRefresh');
        console.log("NPC Controller Mounted");
    }

    updateNpc = (npc) => this.setState({npc: npc});

    render(){
        return(<NpcView npc={this.state.npc}></NpcView>);
    }
}

export default NpcController;