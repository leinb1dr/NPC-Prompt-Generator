package com.dleinbach.npcprompt.npc;

import com.dleinbach.npcprompt.ability.Ability;
import com.dleinbach.npcprompt.appearance.Appearance;
import com.dleinbach.npcprompt.bond.Bond;
import com.dleinbach.npcprompt.flaw.Flaw;
import com.dleinbach.npcprompt.ideal.Ideal;
import com.dleinbach.npcprompt.interaction.Interaction;
import com.dleinbach.npcprompt.mannerism.Mannerism;
import com.dleinbach.npcprompt.race.Race;
import com.dleinbach.npcprompt.talent.Talent;

public record Npc(Appearance appearance, Ability highAbility, Ability lowAbility, Talent talent,
                  Mannerism mannerisms, Interaction interaction, Ideal ideal, Bond bond, Flaw flaw, Race race) {
}
