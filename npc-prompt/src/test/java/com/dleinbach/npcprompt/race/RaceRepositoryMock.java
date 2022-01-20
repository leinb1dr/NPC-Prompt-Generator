package com.dleinbach.npcprompt.race;

import org.assertj.core.util.Lists;
import reactor.core.publisher.Flux;

import static org.mockito.Mockito.when;

public class RaceRepositoryMock {

    public static void MOCK(RaceRepository repository){
        when(repository.findAll())
                .thenReturn(Flux.fromIterable(Lists.newArrayList(new Race(1L, "3d27",
                        "9d20+160", "8d6+50", "medium"))));
    }
}
