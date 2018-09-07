package de.gishmo.gwt.example.nalu.simpleapplication.client.ui.onroutemap;

import com.github.mvp4g.nalu.client.component.AbstractComponentController;
import com.github.mvp4g.nalu.client.component.annotation.Controller;
import com.google.gwt.user.client.ui.Widget;

import de.gishmo.gwt.example.nalu.simpleapplication.client.NaluSimpleApplicationContext;

@Controller(route = "/onroutemap", selector = "content", componentInterface = IOnRouteMapComponent.class, component = OnRouteMapComponent.class)
public class OnRouteMapController extends
        AbstractComponentController<NaluSimpleApplicationContext, IOnRouteMapComponent, Widget> implements
        IOnRouteMapComponent.Controller {

    public OnRouteMapController() {
    }

    @Override
    public void start() {
    }
}
