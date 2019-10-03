package com.github.nalukit.example.nalu.simpleapplication.client.ui.error;

import com.github.nalukit.example.nalu.simpleapplication.client.NaluSimpleApplicationContext;
import com.github.nalukit.nalu.client.component.AbstractErrorPopUpComponentController;

public class ErrorController
    extends AbstractErrorPopUpComponentController<NaluSimpleApplicationContext, IErrorComponent>
    implements IErrorComponent.Controller {

  public ErrorController() {
  }

  @Override
  public void onBeforeShow() {
    this.component.clear();
  }

  @Override
  protected void show() {
    this.component.edit(this.errorEventType,
                        this.route,
                        this.message,
                        this.dataStore);
    this.component.show();
  }

}