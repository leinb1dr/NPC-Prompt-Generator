package com.dleinbach.npcprompt.npc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@WebFluxTest(NpcController.class)
public class NpcControllerTest extends NpcTestConfiguration {

    @Autowired
    private WebTestClient client;

    @Test
    void getNPCPrompt(){

        client.get()
                .uri("/npc")
                .exchange()
                .expectBody(Npc.class)
                .consumeWith(npcEntityExchangeResult -> {
                    var responseBody = npcEntityExchangeResult.getResponseBody();
                    assertThat(responseBody).isNotNull();
                    assertThat(responseBody.appearance()).isNotNull();
                    assertThat(responseBody.appearance().text()).isNotEmpty();
                    assertThat(responseBody.talent()).isNotNull();
                    assertThat(responseBody.talent().text()).isNotEmpty();
                    assertThat(responseBody.mannerisms()).isNotNull();
                    assertThat(responseBody.mannerisms().text()).isNotEmpty();
                    assertThat(responseBody.interaction()).isNotNull();
                    assertThat(responseBody.interaction().text()).isNotEmpty();
                    assertThat(responseBody.ideal()).isNotNull();
                    assertThat(responseBody.ideal().text()).isNotEmpty();
                    assertThat(responseBody.ideal().alignment()).isNotEmpty();
                    assertThat(responseBody.bond()).isNotNull();
                    assertThat(responseBody.bond().text()).isNotEmpty();
                    assertThat(responseBody.flaw()).isEmpty();

                });
    }
}
