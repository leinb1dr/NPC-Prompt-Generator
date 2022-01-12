package com.dleinbach.npcprompt.utility;

import java.util.List;
import java.util.function.Function;

public class RandomItem<T> implements Function<List<T>, T>  {
    @Override
    public T apply(List<T> o) {
        return o.get((int)Math.round(Math.random()*(o.size()-1)));
    }
}
