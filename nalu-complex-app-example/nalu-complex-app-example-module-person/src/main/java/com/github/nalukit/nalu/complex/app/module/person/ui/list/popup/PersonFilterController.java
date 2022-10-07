package com.github.nalukit.nalu.complex.app.module.person.ui.list.popup;

import com.github.nalukit.nalu.client.component.annotation.PopUpController;
import com.github.nalukit.nalu.complex.app.common.ui.AbstractAppPopUpController;
import com.github.nalukit.nalu.complex.app.common.ui.UiConstants;
import com.github.nalukit.nalu.complex.app.common.ui.common.MessageFactory;
import com.github.nalukit.nalu.complex.app.module.person.event.PersonListEvent;
import com.github.nalukit.nalu.complex.app.shared.model.PersonSearch;

@PopUpController(name = UiConstants.POPUP_PERSON_FILTER,
                 componentInterface = IPersonFilterComponent.class,
                 component = PersonFilterComponent.class)
public class PersonFilterController
    extends AbstractAppPopUpController<IPersonFilterComponent>
    implements IPersonFilterComponent.Controller {

  public PersonFilterController() {
  }

  @Override
  public void show() {
    MessageFactory.INSTANCE
                  .hideProgressBar();
    this.component.show();
    this.component.lock();
    this.component.edit(this.context.getPersistance()
                                    .getPersonSearch());
    this.component.unlock();
  }

  @Override
  public void doSearch(PersonSearch model) {
    MessageFactory.INSTANCE
                  .showProgressBar();
    this.context.setFilterPersonUsed(true);
    this.context.getPersistance()
                .setPersonSearch(model);
    this.eventBus.fireEvent(new PersonListEvent(PersonListEvent.Task.REFRESH));
  }

}
