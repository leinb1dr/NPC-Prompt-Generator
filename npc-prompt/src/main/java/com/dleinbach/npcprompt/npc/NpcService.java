package com.dleinbach.npcprompt.npc;

import reactor.core.publisher.Mono;

public interface NpcService {
    Mono<Npc> getNpc();
}
