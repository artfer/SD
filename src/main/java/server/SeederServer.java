package server;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;

public class SeederServer {

    private LinkedList<String> seeders;
    private LinkedList<String> seedingTo;
    private boolean seeding = (seedingTo.size() > 0);

    public String getSeeder(){
        return seeders.getFirst();
    }

    public void removeSeeder(String seeder){
        seeders.remove(seeder);
        // if seeders.size == 0
        // warn client
        // else
        // switch seeder
        //      warn seeder

    }

    public void switchSeeder(){

    }



}
