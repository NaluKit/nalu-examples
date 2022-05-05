package com.github.nalukit.nalu.complex.app.client.ui.common.block.status;

import com.github.nalukit.nalu.client.component.AbstractBlockComponent;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.TextNode;

public class StatusComponent
    extends AbstractBlockComponent<IStatusComponent.Controller>
    implements IStatusComponent {

  private DominoElement<HTMLDivElement> container;
  private DominoElement<HTMLDivElement> innerContainer;

  public StatusComponent() {
  }

  @Override
  public void render() {
    this.createWidgets();
    this.build();
  }

  @Override
  public void append() {
    DomGlobal.document.body.appendChild(this.container.element());
  }

  @Override
  public void show() {
    this.container.styler(style -> style.setDisplay("block"));
  }

  @Override
  public void hide() {
    this.container.styler(style -> style.setDisplay("none"));
  }

  private void build() {
    this.innerContainer = DominoElement.div()
                                       .styler(style -> style.setColor(Color.WHITE.getHex())
                                                             .setFontSize("14px")
                                                             .setPaddingTop("12px")
                                                             .setPaddingLeft("24px")
                                                             .setPaddingRight("24px"));

    this.container = DominoElement.div()
                                  .appendChild(this.innerContainer)
                                  .setId("blockStatus")
                                  .styler(style -> style.setBackgroundColor(Color.WHITE.getHex())
                                                        .setTextAlign("center")
                                                        .setCssProperty("vertical-align",
                                                                        "middle")
                                                        .setBottom("0px")
                                                        .setLeft("312px")
                                                        .setHeight("44px")
                                                        .setWidth("calc(100% - 324px)")
                                                        .setPosition("fixed")
                                                        .setZIndex(100)
                                                        .setCssProperty("border-color",
                                                                        Color.GREY_LIGHTEN_1.getHex())
                                                        .setCssProperty("color",
                                                                        Color.WHITE.getHex())
                                                        .setCssProperty("background-color",
                                                                        Color.INDIGO.getHex())
                                                        .setCssProperty("border",
                                                                        "1px solid " + Color.INDIGO_DARKEN_4.getHex())
                                                        .setCssProperty("border-top-left-radius",
                                                                        "6px")
                                                        .setCssProperty("border-top-right-radius",
                                                                        "6px")
                                                        .setCssProperty("box-shadow",
                                                                        "2px 2px 2px 2px " + Color.INDIGO_DARKEN_4.getHex())
                                                        .setCssProperty("tab-index",
                                                                        "1000"));

  }

  private void createWidgets() {
  }

  @Override
  public void setMessage(String message) {
    this.innerContainer.clearElement();
    this.innerContainer.appendChild(TextNode.of(message));
  }
}
