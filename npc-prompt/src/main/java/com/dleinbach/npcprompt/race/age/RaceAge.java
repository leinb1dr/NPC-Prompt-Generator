package com.dleinbach.npcprompt.race.age;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;

@JsonIgnoreProperties({"bucketStart", "bucketEnd"})
public record RaceAge(@Id Long id, Long raceId, String stage, String ageRange, Double bucketStart, Double bucketEnd) {
}
