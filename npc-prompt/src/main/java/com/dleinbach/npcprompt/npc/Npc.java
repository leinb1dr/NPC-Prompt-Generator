package com.dleinbach.npcprompt.npc;

import com.dleinbach.npcprompt.ability.Ability;
import com.dleinbach.npcprompt.appearance.Appearance;
import com.dleinbach.npcprompt.mannerism.Mannerism;
import com.dleinbach.npcprompt.talent.Talent;

public record Npc(Appearance appearance, Ability highAbility, Ability lowAbility, Talent talent,
                  Mannerism mannerisms, String interaction, String ideal, String bond, String flaw) {
}
