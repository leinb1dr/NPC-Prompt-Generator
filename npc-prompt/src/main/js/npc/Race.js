import Age from './Age'

class Race {
    constructor(id, name, age){
        this.id = id;
        this.name = name;
        this.age = age;
    }
    
    static parse(race){
        return new Race(race.id, race.name, Age.parse(race.raceAge));
    }
}

export default Race;