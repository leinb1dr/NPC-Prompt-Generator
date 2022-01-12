package com.dleinbach.npcprompt.ability;

import com.dleinbach.npcprompt.utility.RandomItem;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;

@Component
public record AbilityServiceImpl(AbilityRepository repository) implements AbilityService{

    @Override
    public Mono<Ability> getAbility() {
        return repository.findAll()
                .collect(Collectors.toList())
                .map(new RandomItem<>());
    }
}
