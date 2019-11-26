package requests;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/getSeeders")
public class GetMoviesList {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String response() {
        String test = "test";
        return test;
    }

}
