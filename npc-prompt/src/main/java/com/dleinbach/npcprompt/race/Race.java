package com.dleinbach.npcprompt.race;

import com.dleinbach.npcprompt.utility.DiceParser;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;

// Dragonborn x,9d20+160,3d27,medium
public record Race(@Id Long id, String ageFormula, String weightFormula, String heightFormula, String characterSize) {
//    @Transient
//    private DiceParser age = null;
//    @Transient
//    private DiceParser weight = null;
//    @Transient
//    private DiceParser height = null;

//    public Race(){
//        this.id = 0L;
//        this.ageFormula = "";
//        this.weightFormula = "";
//        this.characterSize = "";
//        this.heightFormula = "";
//    }

    @JsonProperty("age")
    public int getAge(){
        return DiceParser.parse((ageFormula)).calc();
    }

    @JsonGetter("weight")
    public int getWeight(){
            return DiceParser.parse(weightFormula).calc();
    }

    @JsonGetter("height")
    public int getHeight(){
            return DiceParser.parse(heightFormula).calc();
    }
}
