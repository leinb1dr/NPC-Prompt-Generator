package com.dleinbach.npcprompt.appearance;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.test.StepVerifier;

@ExtendWith(SpringExtension.class)
@Import({AppearanceServiceImpl.class})
public class AppearanceServiceTest {

    @MockBean
    AppearanceRepository repository;

    @Autowired
    AppearanceService service;

    @Test
    public void getAppearance() {
        AppearanceRepositoryMock.MOCK(repository);
        var appearance = service.getAppearance();
        StepVerifier.create(appearance)
                .expectNextCount(1)
                .verifyComplete();
    }
}
