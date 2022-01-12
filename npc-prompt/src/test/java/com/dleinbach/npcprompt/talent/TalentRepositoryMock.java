package com.dleinbach.npcprompt.talent;

import org.assertj.core.util.Lists;
import reactor.core.publisher.Flux;

import static org.mockito.Mockito.when;

public class TalentRepositoryMock {

    public static void MOCK(TalentRepository repository){
        when(repository.findAll())
                .thenReturn(Flux.fromIterable(Lists.newArrayList(new Talent(1L, "Plays a musical instrument"))));
    }
}
