package de.gishmo.example.devk.server.filter;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import java.io.IOException;

public class LoggingResponseFilter
    implements ContainerResponseFilter {

  @Override
  public void filter(ContainerRequestContext requestContext,
                     ContainerResponseContext responseContext)
      throws IOException {
    String method = requestContext.getMethod();
    System.out.println("=====================================================================================================================");
    System.out.println("Kulani Application: Requesting " +
                       method +
                       " for path " +
                       requestContext.getUriInfo()
                                     .getPath());
    Object entity = responseContext.getEntity();
    System.out.println("=====================================================================================================================");
  }

}
