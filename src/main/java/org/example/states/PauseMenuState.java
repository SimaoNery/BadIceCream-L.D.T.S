package org.example.states;

import org.example.controller.Controller;
import org.example.controller.menu.MainMenuController;
import org.example.controller.menu.PauseMenuController;
import org.example.model.menu.MainMenu;
import org.example.model.menu.PauseMenu;
import org.example.viewer.Viewer;
import org.example.viewer.menu.MainMenuViewer;
import org.example.viewer.menu.PauseMenuViewer;


public class PauseMenuState extends State<PauseMenu> {
    public PauseMenuState(PauseMenu model) {
        super(model);
    }

    @Override
    protected Viewer<PauseMenu> getViewer() {
        return new PauseMenuViewer(getModel());
    }

    @Override
    protected Controller<PauseMenu> getController() {
        return new PauseMenuController(getModel());
    }
}
