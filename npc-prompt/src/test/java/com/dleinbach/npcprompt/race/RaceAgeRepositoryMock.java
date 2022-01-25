package com.dleinbach.npcprompt.race;

import com.dleinbach.npcprompt.race.age.RaceAge;
import com.dleinbach.npcprompt.race.age.RaceAgeRepository;
import com.dleinbach.npcprompt.race.main.Race;
import com.dleinbach.npcprompt.race.main.RaceRepository;
import org.assertj.core.util.Lists;
import reactor.core.publisher.Flux;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

public class RaceAgeRepositoryMock {

    public static void MOCK(RaceAgeRepository repository){
        when(repository.findByRaceId(anyLong()))
                .thenReturn(Flux.fromIterable(Lists.newArrayList(new RaceAge(1L, 1L, "Child", "0-3", 0.0, 100.0))));
    }
}
