package com.dleinbach.npcprompt.appearance;

import reactor.core.publisher.Mono;

public interface AppearanceService {
    Mono<Appearance> getAppearance();
}
