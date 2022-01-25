package com.dleinbach.npcprompt.race;

import com.dleinbach.npcprompt.race.age.RaceAge;
import com.dleinbach.npcprompt.race.age.RaceAgeRepository;
import com.dleinbach.npcprompt.race.main.Race;
import com.dleinbach.npcprompt.race.main.RaceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.test.StepVerifier;

@ExtendWith(SpringExtension.class)
@Import({RaceServiceImpl.class})
public class RaceServiceTest {

    @MockBean
    RaceAgeRepository raceAgeRepository;

    @MockBean
    RaceRepository repository;

    @Autowired
    RaceService service;

    @BeforeEach
    public void beforeEach(){
        RaceRepositoryMock.MOCK(repository);
        RaceAgeRepositoryMock.MOCK(raceAgeRepository);
    }

    @Test
    public void getRace() {
        var appearance = service.getRace();
        StepVerifier.create(appearance)
                .expectNext(new Race(1L, "Dragonborn", new RaceAge(1L, 1L, "Child", "0-3", 0.0, 100.0), "medium"))
                .verifyComplete();
    }
}
