package com.dleinbach.npcprompt.mannerism;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.test.StepVerifier;

@ExtendWith(SpringExtension.class)
@Import({MannerismServiceImpl.class})
public class MannerismServiceTest {

    @MockBean
    MannerismRepository repository;

    @Autowired
    MannerismService service;

    @Test
    public void getMannerism() {
        MannerismRepositoryMock.MOCK(repository);
        var appearance = service.getMannerism();
        StepVerifier.create(appearance)
                .expectNext(new Mannerism(1L, "Prone to singing, whistling, or humming quietly"))
                .verifyComplete();
    }
}
