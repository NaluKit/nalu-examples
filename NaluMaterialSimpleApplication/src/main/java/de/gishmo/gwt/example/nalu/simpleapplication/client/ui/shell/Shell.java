package de.gishmo.gwt.example.nalu.simpleapplication.client.ui.shell;

import com.github.mvp4g.nalu.plugin.gwt.client.annotation.Selector;
import com.github.mvp4g.nalu.plugin.gwt.client.component.AbstractCompositeShell;
import com.github.mvp4g.nalu.plugin.gwt.client.selector.IsSelectorProvider;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.Widget;

import de.gishmo.gwt.example.nalu.simpleapplication.client.NaluSimpleApplicationContext;
import gwt.material.design.client.ui.MaterialContainer;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialSideNavDrawer;
import gwt.material.design.client.ui.MaterialToast;

public class Shell extends AbstractCompositeShell<NaluSimpleApplicationContext> {

    private static ShellUiBinder uiBinder = GWT.create(ShellUiBinder.class);

    interface ShellUiBinder extends UiBinder<Widget, Shell> {
    }

    @UiField
    MaterialLabel userName;

    @Selector("content")
    @UiField
    MaterialContainer content;

    //TODO: right now sideNav component is on the shell 
    // but should be extracted to a different component.
    // Selector already available for that extraction.
    @Selector("sideNav")
    @UiField
    MaterialSideNavDrawer sideNav;

    @UiHandler("logout")
    void onClick(ClickEvent e) {
        MaterialToast.fireToast("loging out!");
    }

    public Shell() {
        super();
    }

    /**
     * The ShellPresenter has to implemented this method, because the framework can not do this. (It
     * does not know, what to use).
     * <p>
     * We append the ShellView to the browser body.
     */
    @Override
    public void attachShell() {
    	
        initWidget(uiBinder.createAndBindUi(this));

        userName.setText("Nalu Simple Application");
        
        RootLayoutPanel.get().add(this);
    }
    
    @Override
    public void bind() {
      IsSelectorProvider<Shell> provider = new ShellSelectorProviderImpl();
      provider.initialize(this);
    }
}
