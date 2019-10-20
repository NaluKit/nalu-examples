package com.github.nalukit.example.nalu.simpleapplication.client.ui.shell;

import com.github.nalukit.example.nalu.simpleapplication.client.NaluSimpleApplicationContext;
import com.github.nalukit.nalu.client.component.AbstractShell;
import com.github.nalukit.nalu.client.component.annotation.Shell;
import com.github.nalukit.nalu.plugin.gwt.client.annotation.Selector;
import com.github.nalukit.nalu.plugin.gwt.client.selector.IsSelectorProvider;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.client.ui.MaterialContainer;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialSideNavDrawer;
import gwt.material.design.client.ui.MaterialToast;

@Shell("application")
public class ApplicationShell
    extends AbstractShell<NaluSimpleApplicationContext> {

  private static ShellUiBinder uiBinder = GWT.create(ShellUiBinder.class);

  @UiField
  MaterialLabel userName;

  @UiField
  MaterialContainer content;

  // but should be extracted to a different component.
  // Selector already available for that extraction.
  @UiField
  MaterialSideNavDrawer sideNav;

  private Widget widget;

  public ApplicationShell() {
    super();
  }

  @UiHandler("logout")
  void onClick(ClickEvent e) {
    MaterialToast.fireToast("loging out!");
  }

  /**
   * The ShellPresenter has to implemented this method, because the framework can not do this. (It
   * does not know, what to use).
   * <p>
   * We append the ShellView to the browser body.
   */
  @Override
  public void attachShell() {

    widget = uiBinder.createAndBindUi(this);

    userName.setText("Nalu Simple Application");

    RootLayoutPanel.get()
                   .add(widget);
  }

  @Override
  public void bind(ShellLoader loader) {
    IsSelectorProvider<ApplicationShell> provider = new ApplicationShellSelectorProviderImpl();
    provider.initialize(this);
    loader.continueLoading();
  }

  @Override
  public void detachShell() {
    widget.removeFromParent();
  }

  @Selector("content")
  public void setContent(Widget widget) {
    if (this.content.getWidgetCount() > 0) {
      this.content.getChildren()
                  .forEach(c -> c.removeFromParent());
    }
    this.content.add(widget);
  }

  @Selector("sideNav")
  public void setNavigation(Widget widget) {
    if (this.sideNav.getWidgetCount() > 0) {
      this.sideNav.getChildren()
                  .forEach(c -> c.removeFromParent());
    }
    this.sideNav.add(widget);
  }

  interface ShellUiBinder
      extends UiBinder<Widget, ApplicationShell> {

  }

}
