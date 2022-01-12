package com.dleinbach.npcprompt.talent;

import com.dleinbach.npcprompt.utility.RandomItem;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public record TalentServiceImpl(TalentRepository talentRepository) implements TalentService {

    public Mono<Talent> getTalent() {
        return talentRepository.findAll()
                .collectList()
                .map(new RandomItem<>());
    }
}
