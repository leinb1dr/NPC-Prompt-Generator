package com.dleinbach.npcprompt.race;

import com.dleinbach.npcprompt.race.age.RaceAge;
import com.dleinbach.npcprompt.race.age.RaceAgeRepository;
import com.dleinbach.npcprompt.race.main.Race;
import com.dleinbach.npcprompt.race.main.RaceRepository;
import com.dleinbach.npcprompt.utility.RandomItem;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Comparator;

@Component
public record RaceServiceImpl(RaceRepository repository, RaceAgeRepository raceAgeRepository) implements RaceService {

    public Mono<Race> getRace() {
        return repository.findAll()
                .collectList()
                .map(new RandomItem<>())
                .flatMap(race -> raceAgeRepository.findByRaceId(race.id())
                        .collectList()
                        .map(list -> {
                            list.sort(Comparator.comparingDouble(RaceAge::bucketEnd));
                            return list;
                        })
                        .map(list->{
                            Double key = Math.random() * 100;
                            int low = 0;
                            int high = list.size()-1;

                            while (low <= high) {
                                int mid = (low + high) >>> 1;
                                RaceAge midVal = list.get(mid);
                                int start = key.compareTo(midVal.bucketStart());
                                int end = key.compareTo(midVal.bucketEnd());
                                if (start < 0)
                                    high = mid - 1;
                                else if (end > 0)
                                    low = mid + 1;
                                else
                                    return midVal; // key found
                            }
                            return null;  // key not found
                        })
                        .map(raceAge -> new Race(race.id(), race.name(), raceAge, race.characterSize())));
    }
}