package raftus;

import io.atomix.copycat.Query;

public class Get implements Query<Object> {

    public String key;

    public Get(String key){ this.key = key; }
}