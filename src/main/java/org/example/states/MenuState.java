package org.example.states;

import org.example.controller.Controller;
import org.example.viewer.Viewer;

public abstract class MenuState<T> extends State<T> {

    public MenuState(T menu) {
        super(menu);
    }

    @Override
    abstract protected Viewer<T> getViewer();

    @Override
    abstract protected Controller<T> getController();

}
