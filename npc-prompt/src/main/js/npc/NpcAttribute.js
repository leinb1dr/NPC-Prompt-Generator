class NpcAttribute{

    constructor(id, text){
        this.id = id;
        this.text = text;
    }

    static parse(attribute){
        return new NpcAttribute(attribute.id, attribute.text);
    }

}

export default NpcAttribute;