package com.dleinbach.npcprompt.npc;

import com.dleinbach.npcprompt.ability.AbilityRepositoryImpl;
import com.dleinbach.npcprompt.ability.AbilityServiceImpl;
import com.dleinbach.npcprompt.appearance.AppearanceRepository;
import com.dleinbach.npcprompt.appearance.AppearanceRepositoryMock;
import com.dleinbach.npcprompt.appearance.AppearanceServiceImpl;
import com.dleinbach.npcprompt.mannerism.MannerismRepository;
import com.dleinbach.npcprompt.mannerism.MannerismRepositoryMock;
import com.dleinbach.npcprompt.mannerism.MannerismServiceImpl;
import com.dleinbach.npcprompt.talent.TalentRepository;
import com.dleinbach.npcprompt.talent.TalentRepositoryMock;
import com.dleinbach.npcprompt.talent.TalentServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@WebFluxTest(NpcController.class)
@Import({NpcServiceImpl.class, AppearanceServiceImpl.class, AbilityServiceImpl.class,
        AbilityRepositoryImpl.class, TalentServiceImpl.class, MannerismServiceImpl.class})
public class NpcControllerTest {
    @MockBean
    MannerismRepository mannerismRepository;
    @MockBean
    TalentRepository talentRepository;
    @MockBean
    AppearanceRepository repository;

    @Autowired
    private WebTestClient client;

    @Test
    void getNPCPrompt(){
        AppearanceRepositoryMock.MOCK(repository);
        TalentRepositoryMock.MOCK(talentRepository);
        MannerismRepositoryMock.MOCK(mannerismRepository);

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
                });
    }
}
