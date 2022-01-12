package com.dleinbach.npcprompt.ability;

import reactor.core.publisher.Mono;

public interface AbilityService {
    Mono<Ability> getAbility();
}
