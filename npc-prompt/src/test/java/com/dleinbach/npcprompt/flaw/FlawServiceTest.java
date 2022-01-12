package com.dleinbach.npcprompt.flaw;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.test.StepVerifier;

@ExtendWith(SpringExtension.class)
@Import({FlawServiceImpl.class})
public class FlawServiceTest {

    @MockBean
    FlawRepository repository;

    @Autowired
    FlawService service;

    @Test
    public void getFlaw() {
        FlawRepositoryMock.MOCK(repository);
        var appearance = service.getFlaw();
        StepVerifier.create(appearance)
                .expectNext(new Flaw(1L, "Plays a musical instrument"))
                .verifyComplete();
    }
}
