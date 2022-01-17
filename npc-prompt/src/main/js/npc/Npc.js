import NpcAttribute from './NpcAttribute'

class Npc{

    constructor(appearance, highAbility, lowAbility, talent, mannerisms,
                    interaction, ideal, bond, flaw){
        this.talent = talent;
        this.appearance = appearance;
        this.highAbility = highAbility;
        this.lowAbility = lowAbility;
        this.mannerisms = mannerisms;
        this.interaction = interaction;
        this.ideal = ideal;
        this.bond = bond;
        this.flaw = flaw;
    }

    static parse(npc){
        return new Npc(NpcAttribute.parse(npc.appearance), new NpcAttribute(0, npc.highAbility), new NpcAttribute(0,npc.lowAbility),
            NpcAttribute.parse(npc.talent), NpcAttribute.parse(npc.mannerisms), NpcAttribute.parse(npc.interaction),
            NpcAttribute.parse(npc.ideal), NpcAttribute.parse(npc.bond), NpcAttribute.parse(npc.flaw));
    }

    static empty(){
        return new Npc(new NpcAttribute(),new NpcAttribute(),new NpcAttribute(),new NpcAttribute(),
                       new NpcAttribute(),new NpcAttribute(),new NpcAttribute(),new NpcAttribute(),
                       new NpcAttribute());
    }

}

export default Npc;