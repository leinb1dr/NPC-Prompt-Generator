package com.dleinbach.npcprompt.race;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.test.StepVerifier;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@Import({RaceServiceImpl.class})
public class RaceServiceTest {

    @MockBean
    RaceRepository repository;

    @Autowired
    RaceService service;

    @BeforeEach
    public void beforeEach(){
        RaceRepositoryMock.MOCK(repository);
    }

    @Test
    public void getRace() {
        var appearance = service.getRace();
        StepVerifier.create(appearance)
                .expectNext(new Race(1L, "3d27","9d20+160", "8d6+50", "medium"))
                .verifyComplete();
    }

    @Test
    public void getCalculatedFields(){
        var appearance = service.getRace();
        StepVerifier.create(appearance)
                .consumeNextWith(race -> {
                    assertThat(race.getAge()).isBetween(3,81).describedAs("Age");
//                    assertThat(race.getWeight()).isBetween(169,340).describedAs("Weight");
//                    assertThat(race.getHeight()).isBetween(58,98).describedAs("Height");
                })
                .verifyComplete();
    }
}
