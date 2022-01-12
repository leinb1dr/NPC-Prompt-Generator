package com.dleinbach.npcprompt.ideal;

import reactor.core.publisher.Mono;

public interface IdealService {
    Mono<Ideal> getIdeal();
}
