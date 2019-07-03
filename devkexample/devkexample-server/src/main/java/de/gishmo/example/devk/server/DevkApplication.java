package de.gishmo.example.devk.server;

import de.gishmo.example.devk.server.filter.LoggingRequestFilter;
import de.gishmo.example.devk.server.filter.LoggingResponseFilter;

import javax.ws.rs.core.Application;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DevkApplication
    extends Application {

  @Override
  public Set<Class<?>> getClasses() {
    final Set<Class<?>> classes = new HashSet<>();
    // register resources and features
    //      classes.add(MultiPartFeature.class);
    //      classes.add(MultiPartResource.class);

    //
    classes.add(LoggingRequestFilter.class);
    classes.add(LoggingResponseFilter.class);
    //    classes.add(CustomLoggingFilter.class);
    //    //    classes.add(LoggingResponseFilter.class);
    //
    //    classes.add(TaaApplicationEventListener.class);
    return classes;
  }

  @Override
  public Map<String, Object> getProperties() {
    Map<String, Object> properties = new HashMap<>();
    //    properties.put(ServerProperties.MONITORING_STATISTICS_MBEANS_ENABLED,
    //                   true);
    return properties;
  }

}