package com.stefthedev.discordbot.utilities.general;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

import java.util.Set;

public class Manager<T> {

    private final Set<T> set;

    public Manager() {
        set = Sets.newHashSet();
    }

    public void add(T t) {
        set.add(t);
    }

    public void remove(T t) {
        set.remove(t);
    }

    public T get(String string) {
        return set.stream().filter(t -> t.toString().equals(string)).findFirst().orElse(null);
    }

    public Set<T> asSet() {
        return ImmutableSet.copyOf(set);
    }
}
