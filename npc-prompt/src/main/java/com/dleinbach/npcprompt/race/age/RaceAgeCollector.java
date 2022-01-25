package com.dleinbach.npcprompt.race.age;

import java.util.ArrayList;
import java.util.List;

public class RaceAgeCollector {
    private Integer total;
    private final List<RaceAge> raceAges;

    public RaceAgeCollector(){
        this.total = 0;
        this.raceAges = new ArrayList<>();
    }

    public Integer getTotal() {
        return total;
    }

    public void incrementTotal(Integer total) {
        this.total += total;
    }

    public List<RaceAge> getRaceAges() {
        return raceAges;
    }
}
