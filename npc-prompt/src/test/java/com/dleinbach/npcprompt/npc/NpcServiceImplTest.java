package com.dleinbach.npcprompt.npc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
class NpcServiceImplTest extends NpcTestConfiguration{

    @Autowired
    NpcService npcService;

    @Test
    public void getNpcTest() {
        Mono<Npc> npc = npcService.getNpc();
        StepVerifier.create(npc)
                .expectNextMatches(actualNpc -> {
                    assertThat(actualNpc.appearance()).isNotNull();
                    assertThat(actualNpc.appearance().text()).isNotEmpty();
                    assertThat(actualNpc.talent()).isNotNull();
                    assertThat(actualNpc.talent().text()).isNotEmpty();
                    assertThat(actualNpc.mannerisms()).isNotNull();
                    assertThat(actualNpc.mannerisms().text()).isNotEmpty();
                    assertThat(actualNpc.interaction()).isNotNull();
                    assertThat(actualNpc.interaction().text()).isNotEmpty();
                    assertThat(actualNpc.ideal()).isNotNull();
                    assertThat(actualNpc.ideal().text()).isNotNull();
                    assertThat(actualNpc.ideal().alignment()).isNotNull();
                    assertThat(actualNpc.bond()).isNotNull();
                    assertThat(actualNpc.bond().text()).isNotEmpty();
                    assertThat(actualNpc.flaw()).isNotNull();
                    assertThat(actualNpc.flaw().text()).isNotEmpty();
                    return true;
                })
                .verifyComplete();
    }
}