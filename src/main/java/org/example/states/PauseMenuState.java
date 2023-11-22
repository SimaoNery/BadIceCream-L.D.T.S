package org.example.states;

import org.example.controller.Controller;
import org.example.controller.menu.MainMenuController;
import org.example.model.menu.MainMenu;
import org.example.model.menu.Menu;
import org.example.model.menu.PauseMenu;

public class PauseMenuState {
    public PauseMenuState(PauseMenu model) {
        super(model);
    }

    @Override
    protected Viewer<PauseMenu> getViewer() {
        return new MenuViewer(getModel());
    }

    @Override
    protected Controller<MainMenu> getController() {
        return new MainMenuController(getModel());
    }
}
