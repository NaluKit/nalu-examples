package com.github.nalukit.nalu.complex.app.client.ui.common.block.version;

import com.github.nalukit.nalu.client.component.AbstractBlockComponentController;
import com.github.nalukit.nalu.client.component.annotation.BlockController;
import com.github.nalukit.nalu.complex.app.common.AppContext;
import org.gwtproject.i18n.client.DateTimeFormat;

@BlockController(name = "blockVersion",
                 condition = VersionCondition.class,
                 component = VersionComponent.class,
                 componentInterface = IVersionComponent.class)
public class VersionController
    extends AbstractBlockComponentController<AppContext, IVersionComponent>
    implements IVersionComponent.Controller {

  public VersionController() {
  }

  @Override
  public String doGetVersion() {
    return this.context.getApplicationVersion() + " - " + DateTimeFormat.getFormat("dd.MM.yyyy - HH:mm:ss")
                                                                        .format(this.context.getApplicationBuildTime());
  }
}
