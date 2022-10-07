package com.github.nalukit.nalu.simple.app.client.ui.common;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.modals.ModalDialog;
import org.jboss.elemento.Elements;

public class MessageFactory {

  /* instance of the MessageFactory */
  public static MessageFactory INSTANCE = new MessageFactory();

  /* ProgressBar  */
  private ModalDialog modalDialog;
  private boolean     open;

  private MessageFactory() {
    super();
  }

  public void hideProgressBar() {
    if (isOpen()) {
      modalDialog.close();
      modalDialog = null;
      open        = false;
    }
  }

  public void showProgressBar() {
    if (!isOpen()) {
      this.build();
      modalDialog.open();
      open = true;
    }
  }

  public boolean isOpen() {
    return open;
  }

  private void build() {
    modalDialog = ModalDialog.create()
                             .hideFooter()
                             .setAutoClose(false);
    modalDialog.getHeaderContainerElement()
               .setAttribute("style",
                             "display: none;");
    modalDialog.getBodyElement()
               .setAttribute("style",
                             "height: 62px");
    modalDialog.appendChild(Elements.img("images/loader.gif")
                                    .style("float: left; margin-right: 12px;"));
    HTMLDivElement messageElement = Elements.div()
                                            .attr("style",
                                                  "font-weight: bold; margin-top: 6px;")
                                            .element();
    messageElement.textContent = "Work in Progress ...";
    modalDialog.appendChild(messageElement);
  }

}
