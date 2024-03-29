package com.github.nalukit.nalu.complex.app.client.ui.app.content.home;

import com.github.nalukit.nalu.complex.app.common.ui.AbstractAppComponent;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.utils.DominoElement;

public class HomeComponent
    extends AbstractAppComponent<IHomeComponent.Controller>
    implements IHomeComponent {

  public HomeComponent() {
  }

  @Override
  public void render() {
    DominoElement<HTMLDivElement> container = DominoElement.div();

    //    container.appendChild(Row.create()
    //                             .appendChild(Column.span12()
    //                                                .setId("composite01")))
    //             .appendChild(Row.create()
    //                             .appendChild(Column.span12()
    //                                                .setId("composite02")))
    //             .appendChild(Row.create()
    //                             .appendChild(Column.span12()
    //                                                .setId("composite03")))
    //             .appendChild(Row.create()
    //                             .appendChild(Column.span12()
    //                                                .setId("composite04")))
    //             .appendChild(Row.create()
    //                             .appendChild(Column.span6()
    //                                                .setId("composite05"))
    //                             .appendChild(Column.span6()
    //                                                .setId("composite06")));

    initElement(container.element());
  }

}
