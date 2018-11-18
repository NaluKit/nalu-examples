package com.github.nalukit.example.nalu.loginapplication.plugin.error.client.ui.error;

import com.github.nalukit.example.nalu.loginapplication.core.client.NaluLoginApplicationContext;
import com.github.nalukit.nalu.client.Router;
import com.github.nalukit.nalu.client.component.AbstractComponentController;
import com.github.nalukit.nalu.client.exception.RoutingInterceptionException;
import com.github.nalukit.nalu.client.internal.AbstractControllerCreator;
import com.github.nalukit.nalu.client.internal.ClientLogger;
import com.github.nalukit.nalu.client.internal.application.ControllerFactory;
import com.github.nalukit.nalu.client.internal.application.ControllerInstance;
import com.github.nalukit.nalu.client.internal.application.IsControllerCreator;
import java.lang.String;
import java.lang.StringBuilder;
import org.gwtproject.event.shared.SimpleEventBus;

public final class ErrorControllerCreatorImpl extends AbstractControllerCreator<NaluLoginApplicationContext> implements IsControllerCreator {
  public ErrorControllerCreatorImpl(Router router, NaluLoginApplicationContext context,
      SimpleEventBus eventBus) {
    super(router, context, eventBus);
  }

  public ControllerInstance create(String... parms) throws RoutingInterceptionException {
    StringBuilder sb01 = new StringBuilder();
    ControllerInstance controllerInstance = new ControllerInstance();
    controllerInstance.setControllerClassName("com.github.nalukit.example.nalu.loginapplication.plugin.error.client.ui.error.ErrorController");
    AbstractComponentController<?, ?, ?> storedController = ControllerFactory.get().getControllerFormStore("com.github.nalukit.example.nalu.loginapplication.plugin.error.client.ui.error.ErrorController");
    if (storedController == null) {
      sb01.append("controller >>com.github.nalukit.example.nalu.loginapplication.plugin.error.client.ui.error.ErrorController<< --> will be created");
      ClientLogger.get().logSimple(sb01.toString(), 3);
      ErrorController controller = new ErrorController();
      controllerInstance.setController(controller);
      controllerInstance.setChached(false);
      controller.setContext(context);
      controller.setEventBus(eventBus);
      controller.setRouter(router);
      controller.setRestored(false);
      sb01 = new StringBuilder();
      sb01.append("controller >>").append(controller.getClass().getCanonicalName()).append("<< --> created and data injected");
      ClientLogger.get().logDetailed(sb01.toString(), 4);
      IErrorComponent component = new ErrorComponent();
      sb01 = new StringBuilder();
      sb01.append("component >>com.github.nalukit.example.nalu.loginapplication.plugin.error.client.ui.error.ErrorComponent<< --> created using new");
      ClientLogger.get().logDetailed(sb01.toString(), 4);
      component.setController(controller);
      sb01 = new StringBuilder();
      sb01.append("component >>").append(component.getClass().getCanonicalName()).append("<< --> created and controller instance injected");
      ClientLogger.get().logDetailed(sb01.toString(), 4);
      controller.setComponent(component);
      sb01 = new StringBuilder();
      sb01.append("controller >>").append(controller.getClass().getCanonicalName()).append("<< --> instance of >>").append(component.getClass().getCanonicalName()).append("<< injected");
      ClientLogger.get().logDetailed(sb01.toString(), 4);
      component.render();
      sb01 = new StringBuilder();
      sb01.append("component >>").append(component.getClass().getCanonicalName()).append("<< --> rendered");
      ClientLogger.get().logDetailed(sb01.toString(), 4);
      component.bind();
      sb01 = new StringBuilder();
      sb01.append("component >>").append(component.getClass().getCanonicalName()).append("<< --> bound");
      ClientLogger.get().logDetailed(sb01.toString(), 4);
      ClientLogger.get().logSimple("controller >>com.github.nalukit.example.nalu.loginapplication.plugin.error.client.ui.error.ErrorComponent<< created for route >>/errorShell/error<<", 3);
    } else {
      sb01.append("controller >>").append(storedController.getClass().getCanonicalName()).append("<< --> found in cache -> REUSE!");
      ClientLogger.get().logDetailed(sb01.toString(), 4);
      controllerInstance.setController(storedController);
      controllerInstance.setChached(true);
      controllerInstance.getController().setRestored(true);
    }
    return controllerInstance;
  }
}
