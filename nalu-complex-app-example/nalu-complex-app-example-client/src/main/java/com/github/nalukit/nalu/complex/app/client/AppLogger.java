package com.github.nalukit.nalu.complex.app.client;

import com.github.nalukit.nalu.client.application.AbstractLogger;
import com.github.nalukit.nalu.complex.app.common.AppContext;
import com.github.nalukit.nalu.complex.app.shared.service.LoggingServiceFactory;
import com.github.nalukit.nalu.complex.app.shared.transport.request.LoggingRequest;

import java.util.List;

public class AppLogger
    extends AbstractLogger<AppContext> {

  @Override
  public void log(List<String> messages,
                  boolean sdmOnly) {
    LoggingRequest request = new LoggingRequest();
    request.setMessages(messages);
    LoggingServiceFactory.INSTANCE.log(request)
                                  .onSuccess(response -> {
                                  })
                                  .onFailed(failed -> {
                                  })
                                  .send();
  }

}
