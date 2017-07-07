package com.my.Restful;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/restful/rest1")
public class Rest1 {
    
    @Produces("text/plain")
    public String getExampleMsg(){
        return "REST and be well.";
        //return Response.status(Status.OK).entity("Rest and be well.").build();
    }
}
