package com.dleinbach.npcprompt.ability;

import reactor.core.publisher.Flux;

public interface AbilityRepository {
    Flux<Ability> findAll();
}
