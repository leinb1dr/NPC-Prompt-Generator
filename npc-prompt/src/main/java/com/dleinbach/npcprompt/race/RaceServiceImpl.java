package com.dleinbach.npcprompt.race;

import com.dleinbach.npcprompt.utility.RandomItem;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public record RaceServiceImpl(RaceRepository repository) implements RaceService {

    public Mono<Race> getRace() {
        return repository.findAll()
                .collectList()
                .map(new RandomItem<>());
    }
}
