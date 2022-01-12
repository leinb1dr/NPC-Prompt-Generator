package com.dleinbach.npcprompt.npc;

import com.dleinbach.npcprompt.ability.Ability;
import com.dleinbach.npcprompt.appearance.Appearance;

public record Npc(Appearance appearance, Ability highAbility, Ability lowAbility, com.dleinbach.npcprompt.talent.Talent talent,
                  String mannerisms, String interaction, String ideal, String bond, String flaw) {
}
