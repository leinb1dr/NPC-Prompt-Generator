package com.dleinbach.npcprompt.flaw;

import com.dleinbach.npcprompt.utility.RandomItem;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public record FlawServiceImpl(FlawRepository repository) implements FlawService {

    public Mono<Flaw> getFlaw() {
        return repository.findAll()
                .collectList()
                .map(new RandomItem<>());
    }
}
