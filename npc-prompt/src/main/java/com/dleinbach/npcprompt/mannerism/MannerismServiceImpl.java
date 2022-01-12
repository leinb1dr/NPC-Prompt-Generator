package com.dleinbach.npcprompt.mannerism;

import com.dleinbach.npcprompt.utility.RandomItem;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public record MannerismServiceImpl(MannerismRepository MannerismRepository) implements MannerismService {

    public Mono<Mannerism> getMannerism() {
        return MannerismRepository.findAll()
                .collectList()
                .map(new RandomItem<>());
    }
}
