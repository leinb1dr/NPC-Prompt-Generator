package com.dleinbach.npcprompt.interaction;

import org.assertj.core.util.Lists;
import reactor.core.publisher.Flux;

import static org.mockito.Mockito.when;

public class InteractionRepositoryMock {

    public static void MOCK(InteractionRepository repository){
        when(repository.findAll())
                .thenReturn(Flux.fromIterable(Lists.newArrayList(new Interaction(1L, "Argumentative"))));
    }
}
