package com.dleinbach.npcprompt.ideal;

import org.assertj.core.util.Lists;
import reactor.core.publisher.Flux;

import static org.mockito.Mockito.when;

public class IdealRepositoryMock {

    public static void MOCK(IdealRepository repository){
        when(repository.findAll())
                .thenReturn(Flux.fromIterable(Lists.newArrayList(new Ideal(1L, "Beauty", "Good"))));
    }
}
