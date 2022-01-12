package com.dleinbach.npcprompt.bond;

import com.dleinbach.npcprompt.talent.TalentRepository;
import org.assertj.core.util.Lists;
import reactor.core.publisher.Flux;

import static org.mockito.Mockito.when;

public class BondRepositoryMock {

    public static void MOCK(BondRepository repository){
        when(repository.findAll())
                .thenReturn(Flux.fromIterable(Lists.newArrayList(new Bond(1L, "Dedicated to fulfilling a personal life goal"))));
    }
}
