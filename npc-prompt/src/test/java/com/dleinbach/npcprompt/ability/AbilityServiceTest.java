package com.dleinbach.npcprompt.ability;

import com.dleinbach.npcprompt.ability.AbilityRepository;
import com.dleinbach.npcprompt.ability.AbilityRepositoryImpl;
import com.dleinbach.npcprompt.ability.AbilityService;
import com.dleinbach.npcprompt.ability.AbilityServiceImpl;
import com.dleinbach.npcprompt.appearance.AppearanceRepository;
import com.dleinbach.npcprompt.appearance.AppearanceService;
import com.dleinbach.npcprompt.appearance.AppearanceServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.test.StepVerifier;

@ExtendWith(SpringExtension.class)
@Import({AbilityServiceImpl.class, AbilityRepositoryImpl.class})
public class AbilityServiceTest {

    @Autowired
    AbilityRepository repository;

    @Autowired
    AbilityService service;

    @Test
    public void getAppearance() {
        var ability = service.getAbility();
        StepVerifier.create(ability)
                .expectNextCount(1)
                .verifyComplete();
    }
}
