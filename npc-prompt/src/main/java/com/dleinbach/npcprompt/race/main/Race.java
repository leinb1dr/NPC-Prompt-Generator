package com.dleinbach.npcprompt.race.main;

import com.dleinbach.npcprompt.race.age.RaceAge;
import org.springframework.data.annotation.Id;

public record Race(@Id Long id, String name, RaceAge raceAge, String characterSize) {
}
