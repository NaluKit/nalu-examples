package de.gishmo.gwt.example.nalu.simpleapplication.client.ui.shell;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

import de.gishmo.gwt.example.nalu.simpleapplication.client.NaluSimpleApplicationContext;
import gwt.material.design.client.ui.MaterialContainer;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialSideNavDrawer;
import gwt.material.design.client.ui.MaterialToast;

public class ShellComponent extends Composite {

    private static ShellComponentUiBinder uiBinder = GWT.create(ShellComponentUiBinder.class);

    interface ShellComponentUiBinder extends UiBinder<Widget, ShellComponent> {
    }

    @UiField
    MaterialLabel userName;

    @UiField
    MaterialContainer content;

    @UiField
    MaterialSideNavDrawer sideNav;

    @UiHandler("logout")
    void onClick(ClickEvent e) {
        MaterialToast.fireToast("loging out!");
    }

    public ShellComponent(NaluSimpleApplicationContext context) {
        initWidget(uiBinder.createAndBindUi(this));

        userName.setText("Nalu Simple Application");
    }

    public MaterialContainer getContent() {
        return content;
    }

    public MaterialSideNavDrawer getSideNav() {
        return sideNav;
    }
}
