package com.dleinbach.npcprompt.race;

import reactor.core.publisher.Mono;

public interface RaceService {
    Mono<Race> getRace();
}
