package com.dleinbach.npcprompt.npc;

import com.dleinbach.npcprompt.ability.AbilityRepositoryImpl;
import com.dleinbach.npcprompt.ability.AbilityServiceImpl;
import com.dleinbach.npcprompt.appearance.AppearanceRepository;
import com.dleinbach.npcprompt.appearance.AppearanceRepositoryMock;
import com.dleinbach.npcprompt.appearance.AppearanceServiceImpl;
import com.dleinbach.npcprompt.bond.BondRepository;
import com.dleinbach.npcprompt.bond.BondRepositoryMock;
import com.dleinbach.npcprompt.bond.BondServiceImpl;
import com.dleinbach.npcprompt.ideal.IdealRepository;
import com.dleinbach.npcprompt.ideal.IdealRepositoryMock;
import com.dleinbach.npcprompt.ideal.IdealServiceImpl;
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
import org.springframework.context.annotation.Import;

@Import({NpcServiceImpl.class, AppearanceServiceImpl.class, AbilityServiceImpl.class,
        AbilityRepositoryImpl.class, TalentServiceImpl.class, MannerismServiceImpl.class,
        InteractionServiceImpl.class, IdealServiceImpl.class, BondServiceImpl.class})
public class NpcTestConfiguration {
    @MockBean
    MannerismRepository mannerismRepository;
    @MockBean
    TalentRepository talentRepository;
    @MockBean
    AppearanceRepository appearanceRepository;
    @MockBean
    InteractionRepository interactionRepository;
    @MockBean
    IdealRepository idealRepository;
    @MockBean
    BondRepository bondRepository;

    @BeforeEach
    public void beforeEach(){
        AppearanceRepositoryMock.MOCK(appearanceRepository);
        TalentRepositoryMock.MOCK(talentRepository);
        MannerismRepositoryMock.MOCK(mannerismRepository);
        InteractionRepositoryMock.MOCK(interactionRepository);
        IdealRepositoryMock.MOCK(idealRepository);
        BondRepositoryMock.MOCK(bondRepository);
    }
}
