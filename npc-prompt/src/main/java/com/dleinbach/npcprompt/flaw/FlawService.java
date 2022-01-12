package com.dleinbach.npcprompt.flaw;

import reactor.core.publisher.Mono;

public interface FlawService {
    Mono<Flaw> getFlaw();
}
