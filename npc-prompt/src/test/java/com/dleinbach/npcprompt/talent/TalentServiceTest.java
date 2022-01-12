package com.dleinbach.npcprompt.talent;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.test.StepVerifier;

@ExtendWith(SpringExtension.class)
@Import({TalentServiceImpl.class})
public class TalentServiceTest {

    @MockBean
    TalentRepository repository;

    @Autowired
    TalentService service;

    @Test
    public void getTalent() {
        TalentRepositoryMock.MOCK(repository);
        var appearance = service.getTalent();
        StepVerifier.create(appearance)
                .expectNext(new Talent(1L, "Plays a musical instrument"))
                .verifyComplete();
    }
}
