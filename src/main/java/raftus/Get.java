package raftus;

import io.atomix.copycat.Query;

public class Get implements Query<Object> {

    public Integer key;

    public Get(Integer key){ this.key = key; }
}