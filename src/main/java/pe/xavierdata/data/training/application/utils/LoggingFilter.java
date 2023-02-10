package pe.xavierdata.data.training.application.utils;

import io.vertx.core.http.HttpServerRequest;
import java.io.IOException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.Provider;
import org.jboss.logging.Logger;

@Provider
public class LoggingFilter implements ContainerRequestFilter, ContainerResponseFilter {

  private static final Logger LOG = Logger.getLogger(LoggingFilter.class);

  @Context
  UriInfo info;

  @Context
  HttpServerRequest request;

  @Override
  public void filter(ContainerRequestContext context) {
    final String method = context.getMethod();
    final String path = info.getPath();
    final String
            address =
            request.remoteAddress()
                    .toString();
    LOG.infof("Request %s %s from IP %s", method, path, address);
  }

  @Override
  public void filter(ContainerRequestContext context,
                     ContainerResponseContext containerResponseContext)
          throws IOException {
    final String method = context.getMethod();
    final String path = info.getPath();
    final String
            address =
            request.remoteAddress()
                    .toString();
    LOG.infof("Response %s %s from IP %s", method, path, address);
  }
}