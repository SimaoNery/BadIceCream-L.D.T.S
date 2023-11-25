package badIceCream.controller.menu;

import badIceCream.GUI.GUI;
import badIceCream.Game;
import badIceCream.model.menu.PauseMenu;

import java.io.IOException;

public class PauseMenuController extends MenuController<PauseMenu> {
    public PauseMenuController(PauseMenu menu) {
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
