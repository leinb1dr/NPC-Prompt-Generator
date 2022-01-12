package com.dleinbach.npcprompt.ideal;

import com.dleinbach.npcprompt.utility.RandomItem;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public record IdealServiceImpl(IdealRepository talentRepository) implements IdealService {

    public Mono<Ideal> getIdeal() {
        return talentRepository.findAll()
                .collectList()
                .map(new RandomItem<>());
    }
}
