package com.dleinbach.npcprompt.appearance;

import org.assertj.core.util.Lists;
import reactor.core.publisher.Flux;

import static org.mockito.Mockito.when;

public class AppearanceRepositoryMock {

    public static void MOCK(AppearanceRepository repository){
        when(repository.findAll())
                .thenReturn(Flux.fromIterable(Lists.newArrayList(new Appearance(1L, "Distinctive jewelry: earrings, necklace, circlet, bracelets"))));
    }
}
