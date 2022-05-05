package com.github.nalukit.nalu.complex.app.module.person;

import com.github.nalukit.nalu.client.module.AbstractModuleLoader;
import com.github.nalukit.nalu.complex.app.common.AppContext;

public class PersonModuleLoader
    extends AbstractModuleLoader<AppContext> {

  @Override
  public void load(FinishLoadCommand finishLoadCommand) {
    //    ModelFactory.get()
    //                .register(this.router,
    //                          this.eventBus);
    finishLoadCommand.finishLoading();
  }

}
