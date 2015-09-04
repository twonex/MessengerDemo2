package se.sogeti.messengerDemo;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Appender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
    	Logger log = Logger.getLogger(this.getClass().getName());
    	try {
			log.addAppender(new FileAppender(new PatternLayout(), "logging1.txt"));
			log.setLevel(Level.INFO);
	    	log.fatal("First log4j log!");
	    	System.out.println("Logging success");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Exception: " + e.getMessage());
		}
    	
    	
    	
    	return "Hello World!";
        
        
    }
}
