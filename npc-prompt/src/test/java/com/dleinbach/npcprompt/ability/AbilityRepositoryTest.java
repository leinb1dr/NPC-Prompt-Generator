package com.dleinbach.npcprompt.ability;

import com.dleinbach.npcprompt.ability.*;
import com.dleinbach.npcprompt.appearance.Appearance;
import com.dleinbach.npcprompt.appearance.AppearanceRepository;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@Import(AbilityRepositoryImpl.class)
public class AbilityRepositoryTest {

    @Autowired
    AbilityRepository repository;

    @Test
    public void getAppearance() {
        var appearances = repository.findAll();
        StepVerifier.create(appearances)
                .expectNext(Ability.STR)
                .expectNextCount(5)
                .verifyComplete();
    }
}
