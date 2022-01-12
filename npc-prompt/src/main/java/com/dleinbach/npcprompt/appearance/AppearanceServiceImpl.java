package com.dleinbach.npcprompt.appearance;

import com.dleinbach.npcprompt.utility.RandomItem;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public record AppearanceServiceImpl(AppearanceRepository appearanceRepository) implements AppearanceService {

    public Mono<Appearance> getAppearance() {
        return appearanceRepository.findAll()
                .collectList()
                .map(new RandomItem<>());
    }
}
