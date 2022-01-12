package com.dleinbach.npcprompt.talent;

import reactor.core.publisher.Mono;

public interface TalentService {
    Mono<Talent> getTalent();
}
