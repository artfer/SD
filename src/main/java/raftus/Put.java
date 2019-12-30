package raftus;

import io.atomix.copycat.Command;

public class Put implements Command<Object> {

    public String key;
    public SeederStore value;

    public Put(String key,SeederStore value){
        this.key = key;
        this.value = value;
    }
}