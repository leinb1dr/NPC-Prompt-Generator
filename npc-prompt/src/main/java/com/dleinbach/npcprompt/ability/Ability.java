package com.dleinbach.npcprompt.ability;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Ability {
    STR("Strength"),
    DEX("Dexterity"),
    CON("Constitution"),
    CHA("Charisma"),
    WIS("Wisdom"),
    INT("Intelligence");

    private final String name;

    Ability(String name){
        this.name = name;
    }

    @JsonValue
    public String getName() {
        return name;
    }
}
