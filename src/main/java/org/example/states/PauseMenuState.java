package org.example.states;

import org.example.controller.Controller;
import org.example.controller.menu.MainMenuController;
import org.example.controller.menu.PauseMenuController;
import org.example.model.menu.MainMenu;
import org.example.model.menu.PauseMenu;
import org.example.viewer.Viewer;

public class PauseMenuState extends State<PauseMenu> {
    public PauseMenuState(PauseMenu model) {
        super(model);
    }

    @Override
    protected Viewer<PauseMenu> getViewer() {
        return new MenuViewer(getModel());
    }

    @Override
    protected Controller<PauseMenu> getController() {
        return new PauseMenuController(getModel());
    }
}
