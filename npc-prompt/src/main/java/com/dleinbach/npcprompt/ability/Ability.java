package com.dleinbach.npcprompt.ability;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Ability {
    STR("Strength"),
    DEX("Dexterity"),
    CON("Constitution"),
    CHA("Charisma"),
    WIS("Wisdom"),
    INT("Intelligence");

    private final String text;

    Ability(String text){
        this.text = text;
    }

    @JsonValue
    public String getText() {
        return text;
    }
}
