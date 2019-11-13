package server;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/app")
public class App {

    @GET
    @Path("/info")
    @Produces(MediaType.TEXT_PLAIN)
    public String Database(){
        return  "olá, eu sou a base de dados";
    }

    @GET
    @Path("/stream")
    @Produces(MediaType.TEXT_PLAIN)
    public String Streamer() {
        return  "olá, eu sou o streamer";
    }

}
