/*
 * Copyright (c) 2018 - Frank Hossfeld
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not
 *  use this file except in compliance with the License. You may obtain a copy of
 *  the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 *  WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 *  License for the specific language governing permissions and limitations under
 *  the License.
 *
 */

package de.gishmo.gwt.example.nalu.simpleapplication.client.ui.content.detail;

import com.github.mvp4g.nalu.client.component.AbstractComponent;
import de.gishmo.gwt.example.nalu.simpleapplication.client.data.model.dto.Person;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;

public class DetailComponent
        extends AbstractComponent<IDetailComponent.Controller, HTMLElement>
        implements IDetailComponent {

    private TextBox detailFirstName;

    private TextBox detailName;

    private TextBox detailStreet;

    private TextBox detailZip;

    private TextBox detailCity;

    public DetailComponent() {
    }

    @Override
    public void render() {
        this.detailFirstName = TextBox.create("First name");
        this.detailName = TextBox.create("Name");
        this.detailStreet = TextBox.create("Name");
        this.detailZip = TextBox.create("Name");
        this.detailCity = TextBox.create("Name");


        initElement(Card.create("Details")
                .appendChild(Row.create()
                        .addColumn(Column.span12()
                                .appendChild(this.detailFirstName)))
                .appendChild(Row.create()
                        .addColumn(Column.span12()
                                .appendChild(this.detailName)))
                .appendChild(Row.create()
                        .addColumn(Column.span12()
                                .appendChild(this.detailStreet)))
                .appendChild(Row.create()
                        .addColumn(Column.span12()
                                .appendChild(this.detailZip)))
                .appendChild(Row.create()
                        .addColumn(Column.span12()
                                .appendChild(this.detailCity)))
                .appendChild(Row.create()
                        .addColumn(Column.span12()
                                .appendChild(Button.createPrimary("Save")
                                        .style()
                                        .setMarginRight("20px")
                                        .get()
                                        .addClickListener(e -> getController().doUpdate()))
                                .appendChild(Button.create("Reset")
                                        .addClickListener(e -> getController().doRevert())))
                        .style()
                        .setTextAlign("right"))
                .asElement());
    }

    @Override
    public void edit(Person result) {
        if (result != null) {
            detailFirstName.setValue(result.getFirstName());
            detailName.setValue(result.getName());
            detailStreet.setValue(result.getAddress().getStreet());
            detailZip.setValue(result.getAddress().getZip());
            detailCity.setValue(result.getAddress().getCity());
        }
    }

    @Override
    public boolean isDirty() {
        boolean notDirty = (
                getController().getPerson()
                        .getFirstName()
                        .equals(detailFirstName.getValue())) &&

                (getController().getPerson()
                        .getName()
                        .equals(detailName.getValue())) &&

                (getController().getPerson()
                        .getAddress()
                        .getStreet()
                        .equals(detailStreet.getValue())) &&

                (getController().getPerson()
                        .getAddress()
                        .getZip()
                        .equals(detailZip.getValue())) &&

                (getController().getPerson()
                        .getAddress()
                        .getCity()
                        .equals(detailCity.getValue())
                );
        return !notDirty;
    }

    @Override
    public Person flush(Person person) {
        person.setFirstName(detailFirstName.getValue());
        person.setName(detailName.getValue());
        person.getAddress().setStreet(detailStreet.getValue());
        person.getAddress().setZip(detailZip.getValue());
        person.getAddress().setCity(detailCity.getValue());
        return person;
    }
}
