package com.github.nalukit.example.nalu.loginapplication.tracking;

import com.github.nalukit.example.nalu.loginapplication.core.client.NaluLoginApplicationContext;
import com.github.nalukit.example.nalu.loginapplication.core.client.tracking.event.ButtonPressedEvent;
import com.github.nalukit.example.nalu.loginapplication.core.client.tracking.event.LinkSelectedEvent;
import com.github.nalukit.nalu.client.tracker.AbstractTracker;
import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.*;

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

    this.eventBus.addHandler(ButtonPressedEvent.TYPE,
                             e -> this.sendTrackingMessageToServer(e.getMessage()));

    this.eventBus.addHandler(LinkSelectedEvent.TYPE,
                             e -> this.sendTrackingMessageToServer(e.getMessage()));
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
