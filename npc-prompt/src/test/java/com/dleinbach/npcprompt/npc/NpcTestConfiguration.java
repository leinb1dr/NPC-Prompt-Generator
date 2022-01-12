package com.dleinbach.npcprompt.npc;

import com.dleinbach.npcprompt.ability.AbilityRepositoryImpl;
import com.dleinbach.npcprompt.ability.AbilityServiceImpl;
import com.dleinbach.npcprompt.appearance.AppearanceRepository;
import com.dleinbach.npcprompt.appearance.AppearanceRepositoryMock;
import com.dleinbach.npcprompt.appearance.AppearanceServiceImpl;
import com.dleinbach.npcprompt.interaction.InteractionRepository;
import com.dleinbach.npcprompt.interaction.InteractionRepositoryMock;
import com.dleinbach.npcprompt.interaction.InteractionServiceImpl;
import com.dleinbach.npcprompt.mannerism.MannerismRepository;
import com.dleinbach.npcprompt.mannerism.MannerismRepositoryMock;
import com.dleinbach.npcprompt.mannerism.MannerismServiceImpl;
import com.dleinbach.npcprompt.talent.TalentRepository;
import com.dleinbach.npcprompt.talent.TalentRepositoryMock;
import com.dleinbach.npcprompt.talent.TalentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import({NpcServiceImpl.class, AppearanceServiceImpl.class, AbilityServiceImpl.class,
        AbilityRepositoryImpl.class, TalentServiceImpl.class, MannerismServiceImpl.class,
        InteractionServiceImpl.class})
public class NpcTestConfiguration {
    @MockBean
    MannerismRepository mannerismRepository;
    @MockBean
    TalentRepository talentRepository;
    @MockBean
    AppearanceRepository appearanceRepository;
    @MockBean
    InteractionRepository interactionRepository;

    @BeforeEach
    public void beforeEach(){
        AppearanceRepositoryMock.MOCK(appearanceRepository);
        TalentRepositoryMock.MOCK(talentRepository);
        MannerismRepositoryMock.MOCK(mannerismRepository);
        InteractionRepositoryMock.MOCK(interactionRepository);
    }
}