import NpcAttribute from './NpcAttribute';
import Race from './Race';

class Npc{

    constructor(appearance, highAbility, lowAbility, talent, mannerisms,
                    interaction, ideal, bond, flaw, race){
        this.talent = talent;
        this.appearance = appearance;
        this.highAbility = highAbility;
        this.lowAbility = lowAbility;
        this.mannerisms = mannerisms;
        this.interaction = interaction;
        this.ideal = ideal;
        this.bond = bond;
        this.flaw = flaw;
        this.race = race;
    }

    static parse(npc){
        return new Npc(NpcAttribute.parse(npc.appearance), new NpcAttribute(0, npc.highAbility), new NpcAttribute(0,npc.lowAbility),
            NpcAttribute.parse(npc.talent), NpcAttribute.parse(npc.mannerisms), NpcAttribute.parse(npc.interaction),
            NpcAttribute.parse(npc.ideal), NpcAttribute.parse(npc.bond), NpcAttribute.parse(npc.flaw), Race.parse(npc.race));
    }

    static empty(){
        return new Npc(new NpcAttribute(),new NpcAttribute(),new NpcAttribute(),new NpcAttribute(),
                       new NpcAttribute(),new NpcAttribute(),new NpcAttribute(),new NpcAttribute(),
                       new NpcAttribute(), new Race());
    }

}

export default Npc;