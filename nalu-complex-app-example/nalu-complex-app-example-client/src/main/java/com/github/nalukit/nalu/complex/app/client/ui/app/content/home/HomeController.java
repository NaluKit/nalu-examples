package com.github.nalukit.nalu.complex.app.client.ui.app.content.home;

import com.github.nalukit.nalu.client.component.IsController;
import com.github.nalukit.nalu.client.component.annotation.Controller;
import com.github.nalukit.nalu.complex.app.common.event.SelectEvent;
import com.github.nalukit.nalu.complex.app.common.event.StatusChangeEvent;
import com.github.nalukit.nalu.complex.app.common.ui.AbstractAppComponentController;
import com.github.nalukit.nalu.complex.app.common.ui.Routes;
import com.github.nalukit.nalu.complex.app.common.ui.Slots;
import com.github.nalukit.nalu.complex.app.common.ui.common.MessageFactory;

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
    MessageFactory.get()
                  .hideProgressBar();
  }

  @Override
  public void bind(IsController.ControllerLoader loader) {
    MessageFactory.get()
                  .showProgressBar();
    super.checkToken(loader);
  }

}
