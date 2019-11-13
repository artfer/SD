package server;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public class Database {

    public String getMovies() {
        return  "movie 1";
    }

    public String getSeeders() {
        return "movie 2";
    }
}