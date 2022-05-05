package com.github.nalukit.nalu.complex.app.client.ui.common.block.version;

import com.github.nalukit.nalu.client.component.AbstractBlockComponent;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.TextNode;

public class VersionComponent
    extends AbstractBlockComponent<IVersionComponent.Controller>
    implements IVersionComponent {

  private DominoElement<HTMLDivElement> container;
  private DominoElement<HTMLDivElement> innerContainer;

  public VersionComponent() {
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
                                       .styler(style -> style.setColor(Color.INDIGO.getHex())
                                                             .setFontSize("14px")
                                                             .setPaddingTop("12px")
                                                             .setPaddingLeft("24px")
                                                             .setPaddingRight("24px"))
                                       .appendChild(TextNode.of(this.getController()
                                                                    .doGetVersion()));

    this.container = DominoElement.div()
                                  .appendChild(this.innerContainer)
                                  .setId("blockVersion")
                                  .styler(style -> style.setBackgroundColor(Color.WHITE.getHex())
                                                        .setTextAlign("center")
                                                        .setCssProperty("vertical-align",
                                                                        "middle")
                                                        .setBottom("0px")
                                                        .setRight("30px")
                                                        .setHeight("44px")
                                                        .setWidth("366px")
                                                        .setPosition("fixed")
                                                        .setZIndex(100)
                                                        .setCssProperty("border-color",
                                                                        Color.GREY_LIGHTEN_1.getHex())
                                                        .setCssProperty("border",
                                                                        "1px solid " + Color.GREY_LIGHTEN_1.getHex())
                                                        .setCssProperty("border-top-left-radius",
                                                                        "6px")
                                                        .setCssProperty("border-top-right-radius",
                                                                        "6px")
                                                        .setCssProperty("box-shadow",
                                                                        "2px 2px 2px 2px " + Color.GREY_LIGHTEN_1.getHex())
                                                        .setCssProperty("tab-index",
                                                                        "1000"));

  }

  private void createWidgets() {
  }
}
