
class Race {
    constructor(id, name, ageFormula, weightFormula, heightFormula, age, height, weight){
        this.id = id;
        this.name = name;
        this.ageFormula = ageFormula;
        this.weightFormula = weightFormula;
        this.heightFormula = heightFormula;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }
    
    static parse(race){
            return new Race(race.id, race.name, race.ageFormula, race.weightFormula, race.heightFormula,
                race.age, race.height, race.weight);
        }
}

export default Race;