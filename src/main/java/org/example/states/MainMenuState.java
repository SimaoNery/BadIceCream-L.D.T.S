package org.example.states;

import org.example.controller.Controller;
import org.example.controller.menu.MainMenuController;
import org.example.model.menu.MainMenu;
import org.example.model.menu.Menu;
import org.example.viewer.Viewer;

public class MainMenuState extends State<MainMenu> {
    public MainMenuState(MainMenu model) {
        super(model);
    }

    @Override
    protected Viewer<MainMenu> getViewer() {
        return new MenuViewer(getModel());
    }

    @Override
    protected Controller<MainMenu> getController() {
        return new MainMenuController(getModel());
    }
}
