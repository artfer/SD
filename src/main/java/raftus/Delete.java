package raftus;

import io.atomix.copycat.Command;

public class Delete implements Command<Object> {

    public String key;

    public Delete(String key){
        this.key = key;
    }
}