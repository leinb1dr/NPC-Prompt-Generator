package com.dleinbach.npcprompt.interaction;

import reactor.core.publisher.Mono;

public interface InteractionService {
    Mono<Interaction> getInteraction();
}
