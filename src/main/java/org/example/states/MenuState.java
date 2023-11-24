package org.example.states;

import org.example.controller.Controller;
import org.example.controller.menu.PauseMenuController;
import org.example.model.menu.Menu;
import org.example.model.menu.PauseMenu;
import org.example.viewer.Viewer;
import org.example.viewer.menu.PauseMenuViewer;

public abstract class MenuState<T> extends State<T> {

    public MenuState(T menu) {
        super(menu);
    }

    @Override
    abstract protected Viewer<T> getViewer();

    @Override
    abstract protected Controller<T> getController();

}
