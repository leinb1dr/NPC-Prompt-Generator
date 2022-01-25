package com.dleinbach.npcprompt.race;

import com.dleinbach.npcprompt.race.age.RaceAge;
import com.dleinbach.npcprompt.race.main.Race;
import com.dleinbach.npcprompt.race.main.RaceRepository;
import org.assertj.core.util.Lists;
import reactor.core.publisher.Flux;

import static org.mockito.Mockito.when;

public class RaceRepositoryMock {

    public static void MOCK(RaceRepository repository){
        when(repository.findAll())
                .thenReturn(Flux.fromIterable(Lists.newArrayList(new Race(1L, "Dragonborn", null, "medium"))));
    }
}
