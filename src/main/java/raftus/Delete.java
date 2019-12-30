package raftus;

import io.atomix.copycat.Command;

public class Delete implements Command<Object> {

    public Integer key;

    public Delete(Integer key){
        this.key = key;
    }
}