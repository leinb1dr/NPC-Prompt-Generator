package com.dleinbach.npcprompt.ability;

import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
public record AbilityRepositoryImpl() implements AbilityRepository{

    @Override
    public Flux<Ability> findAll() {
        return Flux.fromArray(Ability.values());
    }
}
