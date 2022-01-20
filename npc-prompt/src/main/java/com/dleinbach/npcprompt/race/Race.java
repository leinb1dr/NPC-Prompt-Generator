package com.dleinbach.npcprompt.race;

import com.dleinbach.npcprompt.utility.DiceParser;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;

import java.util.Objects;

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

    @Id
    public Long id() {
        return id;
    }

    public String ageFormula() {
        return ageFormula;
    }

    public String weightFormula() {
        return weightFormula;
    }

    public String heightFormula() {
        return heightFormula;
    }

    public String characterSize() {
        return characterSize;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Race) obj;
        return Objects.equals(this.id, that.id) &&
                Objects.equals(this.ageFormula, that.ageFormula) &&
                Objects.equals(this.weightFormula, that.weightFormula) &&
                Objects.equals(this.characterSize, that.characterSize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ageFormula, weightFormula, characterSize);
    }

    @Override
    public String toString() {
        return "Race[" +
                "id=" + id + ", " +
                "ageFormula=" + ageFormula + ", " +
                "weightFormula=" + weightFormula + ", " +
                "characterSize=" + characterSize + ']';
    }


}
