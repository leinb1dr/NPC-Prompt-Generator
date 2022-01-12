package com.dleinbach.npcprompt.npc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class NpcController {

    private final NpcService npcService;

    @Autowired
    public NpcController(NpcService npcService){
        this.npcService=npcService;
    }

    @GetMapping("/npc")
    public Mono<Npc> getNpc(){
        return npcService.getNpc();
    }
}
