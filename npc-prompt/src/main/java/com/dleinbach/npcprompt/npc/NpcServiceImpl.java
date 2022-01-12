package com.dleinbach.npcprompt.npc;

import com.dleinbach.npcprompt.ability.Ability;
import com.dleinbach.npcprompt.ability.AbilityService;
import com.dleinbach.npcprompt.appearance.Appearance;
import com.dleinbach.npcprompt.appearance.AppearanceService;
import com.dleinbach.npcprompt.ideal.Ideal;
import com.dleinbach.npcprompt.ideal.IdealService;
import com.dleinbach.npcprompt.interaction.Interaction;
import com.dleinbach.npcprompt.interaction.InteractionService;
import com.dleinbach.npcprompt.mannerism.Mannerism;
import com.dleinbach.npcprompt.mannerism.MannerismService;
import com.dleinbach.npcprompt.mannerism.MannerismServiceImpl;
import com.dleinbach.npcprompt.talent.Talent;
import com.dleinbach.npcprompt.talent.TalentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public record NpcServiceImpl(AppearanceService appearanceService, AbilityService abilityService,
                             TalentService talentService, MannerismService mannerismService,
                             InteractionService interactionService, IdealService idealService) implements NpcService {

    private static final Logger LOGGER = LoggerFactory.getLogger(NpcServiceImpl.class);

    @Override
    public Mono<Npc> getNpc() {
        return Mono.zip(attributes ->
                        new Npc((Appearance) attributes[0], (Ability) attributes[1], (Ability) attributes[2],
                                (Talent) attributes[3], (Mannerism) attributes[4], (Interaction)attributes[5],
                                (Ideal) attributes[6], "", ""),
                appearanceService.getAppearance(), abilityService.getAbility(), abilityService.getAbility(),
                talentService.getTalent(), mannerismService.getMannerism(), interactionService.getInteraction(),
                idealService.getIdeal());
    }
}
