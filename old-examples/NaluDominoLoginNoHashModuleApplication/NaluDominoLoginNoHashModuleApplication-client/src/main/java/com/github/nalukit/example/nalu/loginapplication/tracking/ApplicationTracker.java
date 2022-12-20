package com.github.nalukit.example.nalu.loginapplication.tracking;

import com.github.nalukit.example.nalu.loginapplication.NaluLoginApplicationContext;
import com.github.nalukit.nalu.client.event.NaluApplicationEvent;
import com.github.nalukit.nalu.client.tracker.AbstractTracker;
import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.http.client.URL;

import java.util.Arrays;

/**
 * Tracking class of the Nalu application
 * <p>
 * Important Note:
 * <p>
 * Keep in mind when you think about tracking, that you have
 * to respect local laws regarding data protection and privacy!
 * <p>
 * OD NOT LOG DATA THAT ENABLES YOU OT IDENTIFY A USER!
 * <p>
 * If you want to do so, you need the permission of the user!
 */
public class ApplicationTracker
    extends AbstractTracker<NaluLoginApplicationContext> {

  private String         url;
  private RequestBuilder builder;

  @Override
  public void bind() {
    url = GWT.getModuleBaseURL();
    url = url + "tracking";
    url = URL.encode(url);

    this.builder = new RequestBuilder(RequestBuilder.POST,
                                      url);

    this.eventBus.addHandler(NaluApplicationEvent.TYPE,
                             e -> {
                               if ("ButtonPressedEvent".equals(e.getEvent())) {
                                 this.sendTrackingMessageToServer((String) e.get("message"));
                               } else if ("LinkSelectedEvent".equals(e.getEvent())) {
                                 this.sendTrackingMessageToServer((String) e.get("message"));
                               }
                             });
  }

  @Override
  public void track(String route,
                    String... params) {
    StringBuilder sb = createLogMessage(route,
                                        params);
    this.logActionInBrowser("Tracker: " + sb.toString());
    sendTrackingMessageToServer(sb.toString());
  }

  private void sendTrackingMessageToServer(String trackingMessage) {
    try {
      builder.sendRequest("Tracker: " + trackingMessage,
                          new RequestCallback() {
                            public void onError(Request request,
                                                Throwable exception) {
                              // no doubt ... we will ignore every error!
                            }

                            public void onResponseReceived(Request request,
                                                           Response response) {
                              // oh ... success ... but who concerns ... :-)
                            }
                          });
    } catch (RequestException e) {
      // no doubt ... we will ignore every error!
    }
  }

  private void logActionInBrowser(String message) {
    GWT.log(message);
  }

  private StringBuilder createLogMessage(String route,
                                         String... params) {
    StringBuilder sb = new StringBuilder();
    sb.append("route -> >>")
      .append(route)
      .append("<<");
    if (params != null && params.length > 0) {
      sb.append("  --  Parameter: ");
      Arrays.asList(params)
            .forEach(p -> sb.append(">>")
                            .append(p)
                            .append("<<   "));
    }
    return sb;
  }

}
