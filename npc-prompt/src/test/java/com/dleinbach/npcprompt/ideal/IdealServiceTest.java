package com.dleinbach.npcprompt.ideal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.test.StepVerifier;

@ExtendWith(SpringExtension.class)
@Import({IdealServiceImpl.class})
public class IdealServiceTest {

    @MockBean
    IdealRepository repository;

    @Autowired
    IdealService service;

    @Test
    public void getIdeal() {
        IdealRepositoryMock.MOCK(repository);
        var appearance = service.getIdeal();
        StepVerifier.create(appearance)
                .expectNext(new Ideal(1L, "Beauty", "Good"))
                .verifyComplete();
    }
}
