package com.github.nalukit.nalu.simple.app.client.ui.app.content.start;

import com.github.nalukit.nalu.client.component.IsController;
import com.github.nalukit.nalu.client.component.annotation.Controller;
import com.github.nalukit.nalu.simple.app.client.event.SelectEvent;
import com.github.nalukit.nalu.simple.app.client.event.StatusChangeEvent;
import com.github.nalukit.nalu.simple.app.client.ui.AbstractAppComponentController;
import com.github.nalukit.nalu.simple.app.client.ui.Routes;
import com.github.nalukit.nalu.simple.app.client.ui.Slots;
import com.github.nalukit.nalu.simple.app.client.ui.common.MessageFactory;

@Controller(route = Routes.ROUTE_HOME,
            selector = Slots.SELECTOR_CONTENT_APPLICATION,
            component = HomeComponent.class,
            componentInterface = IHomeComponent.class)
public class HomeController
    extends AbstractAppComponentController<IHomeComponent>
    implements IHomeComponent.Controller {

  public HomeController() {
  }

  @Override
  public void start() {
    this.eventBus.fireEvent(new SelectEvent(SelectEvent.Item.HOME));
    this.eventBus.fireEvent(new StatusChangeEvent("You are here: HOME!"));
    MessageFactory.INSTANCE
                  .hideProgressBar();
  }

  @Override
  public void bind(IsController.ControllerLoader loader) {
    MessageFactory.INSTANCE
                  .showProgressBar();
    super.checkToken(loader);
  }

}
