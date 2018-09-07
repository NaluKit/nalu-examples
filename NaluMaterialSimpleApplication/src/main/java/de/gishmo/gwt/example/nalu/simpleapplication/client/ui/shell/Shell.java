package de.gishmo.gwt.example.nalu.simpleapplication.client.ui.shell;

import com.github.mvp4g.nalu.client.component.AbstractShell;
import com.github.mvp4g.nalu.plugin.gwt.client.annotation.Selector;
import com.github.mvp4g.nalu.plugin.gwt.client.selector.IsSelectorProvider;
import com.google.gwt.user.client.ui.RootLayoutPanel;

import de.gishmo.gwt.example.nalu.simpleapplication.client.NaluSimpleApplicationContext;
import gwt.material.design.client.ui.MaterialContainer;
import gwt.material.design.client.ui.MaterialSideNavDrawer;

public class Shell extends AbstractShell<NaluSimpleApplicationContext> {

    @Selector("content")
    MaterialContainer content;
    
    //TODO: Por ahora el componente de la navegación está en la propia shell pero hay que sacarlo
    // a un componente especifico. Aqui dejo ya el selector para ser utilizado y este recordatorio.
    @Selector("sideNav")
    MaterialSideNavDrawer sideNav;

    private ShellComponent shellComponent;


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
        
        shellComponent = new ShellComponent(this.context);
        content = shellComponent.getContent();
        sideNav = shellComponent.getSideNav();

        RootLayoutPanel.get().add(shellComponent);
    }
    
    @Override
    public void bind() {
      IsSelectorProvider<Shell> provider = new ShellSelectorProviderImpl();
      provider.initialize(this);
    }
}
