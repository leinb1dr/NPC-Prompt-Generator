package com.dleinbach.npcprompt.mannerism;

import org.assertj.core.util.Lists;
import reactor.core.publisher.Flux;

import static org.mockito.Mockito.when;

public class MannerismRepositoryMock {

    public static void MOCK(MannerismRepository repository){
        when(repository.findAll())
                .thenReturn(Flux.fromIterable(Lists.newArrayList(new Mannerism(1L,
                        "Prone to singing, whistling, or humming quietly"))));
    }
}
