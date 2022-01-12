package com.dleinbach.npcprompt.bond;

import reactor.core.publisher.Mono;

public interface BondService {
    Mono<Bond> getBond();
}
