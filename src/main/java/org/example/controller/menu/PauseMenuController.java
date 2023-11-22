package org.example.controller.menu;

import org.example.Game;
import org.example.controller.Controller;
import org.example.model.menu.MainMenu;

import java.io.IOException;

public class PauseMenuController extends Controller<MainMenu> {
    public PauseMenuController(MainMenu menu) {
        super(menu);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP:
                getModel().previousEntry();
                break;
            case DOWN:
                getModel().nextEntry();
                break;
            case SELECT:
                // Resume
                // Quit
        }
    }
}
