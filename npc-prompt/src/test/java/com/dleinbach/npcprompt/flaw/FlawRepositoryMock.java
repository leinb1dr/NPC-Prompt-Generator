package com.dleinbach.npcprompt.flaw;

import org.assertj.core.util.Lists;
import reactor.core.publisher.Flux;

import static org.mockito.Mockito.when;

public class FlawRepositoryMock {

    public static void MOCK(FlawRepository repository){
        when(repository.findAll())
                .thenReturn(Flux.fromIterable(Lists.newArrayList(new Flaw(1L, "Plays a musical instrument"))));
    }
}
