package com.dleinbach.npcprompt.race.age;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface RaceAgeRepository extends ReactiveCrudRepository<RaceAge, Long> {
    Flux<RaceAge> findByRaceId(long raceId);
}
