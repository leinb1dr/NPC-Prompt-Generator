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
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@Import({NpcServiceImpl.class, AppearanceServiceImpl.class, AppearanceRepository.class,
        AbilityRepositoryImpl.class, AbilityServiceImpl.class, TalentServiceImpl.class,
        MannerismServiceImpl.class})
class NpcServiceImplTest {
    @MockBean
    MannerismRepository mannerismRepository;
    @MockBean
    TalentRepository talentRepository;
    @MockBean
    AppearanceRepository appearanceRepository;

    @Autowired
    NpcService npcService;

    @Test
    public void getNpcTest() {
        AppearanceRepositoryMock.MOCK(appearanceRepository);
        TalentRepositoryMock.MOCK(talentRepository);
        MannerismRepositoryMock.MOCK(mannerismRepository);

        Mono<Npc> npc = npcService.getNpc();
        StepVerifier.create(npc)
                .expectNextMatches(actualNpc -> {
                    assertThat(actualNpc.appearance()).isNotNull();
                    assertThat(actualNpc.appearance().text()).isNotEmpty();
                    assertThat(actualNpc.talent()).isNotNull();
                    assertThat(actualNpc.talent().text()).isNotEmpty();
                    assertThat(actualNpc.mannerisms()).isNotNull();
                    assertThat(actualNpc.mannerisms().text()).isNotEmpty();
                    return true;
                })
                .verifyComplete();
    }
}