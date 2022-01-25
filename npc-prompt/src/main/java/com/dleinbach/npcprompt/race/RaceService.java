package com.dleinbach.npcprompt.race;

import com.dleinbach.npcprompt.race.main.Race;
import reactor.core.publisher.Mono;

public interface RaceService {
    Mono<Race> getRace();
}
