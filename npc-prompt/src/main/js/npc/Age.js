class Age {
    constructor(stage, ageRange){
        this.stage = stage;
        this.ageRange = ageRange;
    }

    static parse(age){
        return new Age(age.stage, age.ageRange);
    }
}

export default Age;