package com.github.nalukit.example.nalu.loginapplication.plugin.error.client.shell.error;

import com.github.nalukit.example.nalu.loginapplication.core.client.NaluLoginApplicationContext;
import com.github.nalukit.nalu.client.Router;
import com.github.nalukit.nalu.client.internal.AbstractShellCreator;
import com.github.nalukit.nalu.client.internal.ClientLogger;
import com.github.nalukit.nalu.client.internal.application.IsShellCreator;
import com.github.nalukit.nalu.client.internal.application.ShellInstance;
import java.lang.StringBuilder;
import org.gwtproject.event.shared.SimpleEventBus;

public final class ErrorShellCreatorImpl extends AbstractShellCreator<NaluLoginApplicationContext> implements IsShellCreator {
  public ErrorShellCreatorImpl(Router router, NaluLoginApplicationContext context,
      SimpleEventBus eventBus) {
    super(router, context, eventBus);
  }

  public ShellInstance create() {
    StringBuilder sb01 = new StringBuilder();
    ShellInstance shellInstance = new ShellInstance();
    shellInstance.setShellClassName("com.github.nalukit.example.nalu.loginapplication.plugin.error.client.shell.error.ErrorShell");
    sb01.append("compositeModel >>com.github.nalukit.example.nalu.loginapplication.plugin.error.client.shell.error.ErrorShell<< --> will be created");
    ClientLogger.get().logSimple(sb01.toString(), 1);
    ErrorShell compositeModel = new ErrorShell();
    compositeModel.setContext(context);
    compositeModel.setEventBus(eventBus);
    compositeModel.setRouter(router);
    sb01 = new StringBuilder();
    sb01.append("compositeModel >>com.github.nalukit.example.nalu.loginapplication.plugin.error.client.shell.error.ErrorShell<< --> created and data injected");
    ClientLogger.get().logDetailed(sb01.toString(), 2);
    sb01 = new StringBuilder();
    sb01.append("compositeModel >>com.github.nalukit.example.nalu.loginapplication.plugin.error.client.shell.error.ErrorShell<< --> call bind()-method");
    ClientLogger.get().logDetailed(sb01.toString(), 2);
    compositeModel.bind();
    sb01 = new StringBuilder();
    sb01.append("compositeModel >>com.github.nalukit.example.nalu.loginapplication.plugin.error.client.shell.error.ErrorShell<< --> called bind()-method");
    ClientLogger.get().logDetailed(sb01.toString(), 2);
    shellInstance.setShell(compositeModel);
    return shellInstance;
  }
}
