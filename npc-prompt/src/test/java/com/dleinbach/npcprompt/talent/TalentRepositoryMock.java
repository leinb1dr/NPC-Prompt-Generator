package com.dleinbach.npcprompt.talent;

import com.dleinbach.npcprompt.appearance.Appearance;
import com.dleinbach.npcprompt.appearance.AppearanceRepository;
import com.dleinbach.npcprompt.talent.Talent;
import com.dleinbach.npcprompt.talent.TalentRepository;
import org.assertj.core.util.Lists;
import reactor.core.publisher.Flux;

import static org.mockito.Mockito.when;

public class TalentRepositoryMock {

    public static void MOCK(TalentRepository repository){
        when(repository.findAll())
                .thenReturn(Flux.fromIterable(Lists.newArrayList(new Talent(1L, "Plays a musical instrument"))));
    }
}
