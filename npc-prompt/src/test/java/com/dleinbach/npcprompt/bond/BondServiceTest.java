package com.dleinbach.npcprompt.bond;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.test.StepVerifier;

@ExtendWith(SpringExtension.class)
@Import({BondServiceImpl.class})
public class BondServiceTest {

    @MockBean
    BondRepository repository;

    @Autowired
    BondService service;

    @Test
    public void getBond() {
        BondRepositoryMock.MOCK(repository);
        var appearance = service.getBond();
        StepVerifier.create(appearance)
                .expectNext(new Bond(1L, "Dedicated to fulfilling a personal life goal"))
                .verifyComplete();
    }
}
