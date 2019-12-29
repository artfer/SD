package raftus;

import io.atomix.copycat.Command;

public class Put implements Command<Object> {

    public Integer key;
    public SeederStore value;

    public Put(Integer key,SeederStore value){
        this.key = key;
        this.value = value;
    }
}