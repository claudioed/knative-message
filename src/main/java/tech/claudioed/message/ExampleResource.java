package tech.claudioed.message;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.TimeUnit;

@Path("/message")
public class ExampleResource {

    @ConfigProperty(name = "application.message")
    String message;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String message(@HeaderParam("wgiait") String wait) throws InterruptedException {
        if (wait != null) {
            TimeUnit.MILLISECONDS.sleep(Long.valueOf(wait));
        }
        return this.message;
    }
}