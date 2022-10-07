package com.github.nalukit.nalu.complex.app.common.ui.common.popup;

import com.github.nalukit.nalu.client.plugin.IsCustomConfirmPresenter;
import com.github.nalukit.nalu.client.plugin.IsNaluProcessorPlugin.ConfirmHandler;
import com.github.nalukit.nalu.complex.app.common.ui.UiConstants;
import com.github.nalukit.nalu.complex.app.common.ui.common.MessageFactory;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.dialogs.MessageDialog;
import org.dominokit.domino.ui.dialogs.MessageDialogStyles;
import org.dominokit.domino.ui.style.Color;

public class ShowDirtyDialog
    implements IsCustomConfirmPresenter {

  private ConfirmHandler confirmHandler;

  public ShowDirtyDialog() {
  }

  @Override
  public void confirm(String message) {
    MessageDialog messageDialog = MessageDialog.createMessage("You will lost all your changes!",
                                                              "This can not reverted!");
    Button cancelButton = Button.create("Cancel")
                                .linkify()
                                .styler(style -> style.addCss(MessageDialogStyles.DIALOG_BUTTON)
                                                      .setWidth(UiConstants.BUTTON_WIDTH))
                                .addClickListener(e -> {
                                  messageDialog.close();
                                  confirmHandler.onCancel();
                                  MessageFactory.INSTANCE
                                                .hideProgressBar();
                                });
    Button revertButton = Button.create("Revert")
                                .linkify()
                                .setColor(Color.RED)
                                .styler(style -> style.addCss(MessageDialogStyles.DIALOG_BUTTON)
                                                      .setWidth(UiConstants.BUTTON_WIDTH))
                                .addClickListener(e -> {
                                  messageDialog.close();
                                  confirmHandler.onOk();
                                });

    messageDialog.setAutoClose(false)
                 .setModal(true)
                 .warning()
                 .getFooterElement()
                 .clearElement()
                 .appendChild(revertButton)
                 .appendChild(cancelButton);
    messageDialog.open();
  }

  @Override
  public void addConfirmHandler(ConfirmHandler confirmHandler) {
    this.confirmHandler = confirmHandler;
  }

}
