package com.dleinbach.npcprompt.mannerism;

import reactor.core.publisher.Mono;

public interface MannerismService {
    Mono<Mannerism> getMannerism();
}
