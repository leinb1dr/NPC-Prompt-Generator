package com.dleinbach.npcprompt.interaction;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.test.StepVerifier;

@ExtendWith(SpringExtension.class)
@Import({InteractionServiceImpl.class})
public class InteractionServiceTest {

    @MockBean
    InteractionRepository repository;

    @Autowired
    InteractionService service;

    @Test
    public void getInteraction() {
        InteractionRepositoryMock.MOCK(repository);
        var appearance = service.getInteraction();
        StepVerifier.create(appearance)
                .expectNext(new Interaction(1L, "Argumentative"))
                .verifyComplete();
    }
}
