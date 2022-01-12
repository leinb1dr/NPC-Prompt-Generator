package com.dleinbach.npcprompt.bond;

import com.dleinbach.npcprompt.utility.RandomItem;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public record BondServiceImpl(BondRepository repository) implements BondService {

    public Mono<Bond> getBond() {
        return repository.findAll()
                .collectList()
                .map(new RandomItem<>());
    }
}
