package org.example.controller.menu;

import org.example.GUI.GUI;
import org.example.Game;
import org.example.controller.Controller;

import java.io.IOException;

public class MenuController<T> extends Controller<T> {

    public MenuController(T model) {
        super(model);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {};
}
