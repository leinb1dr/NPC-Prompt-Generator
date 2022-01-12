package com.dleinbach.npcprompt.interaction;

import com.dleinbach.npcprompt.utility.RandomItem;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public record InteractionServiceImpl(InteractionRepository InteractionRepository) implements InteractionService {

    public Mono<Interaction> getInteraction() {
        return InteractionRepository.findAll()
                .collectList()
                .map(new RandomItem<>());
    }
}
