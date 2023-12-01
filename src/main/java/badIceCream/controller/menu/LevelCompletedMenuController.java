package badIceCream.controller.menu;

import badIceCream.GUI.GUI;
import badIceCream.GUI.Graphics;
import badIceCream.GUI.MenuGraphics;
import badIceCream.Game;
import badIceCream.model.menu.LevelCompletedMenu;
import badIceCream.model.menu.MainMenu;
import badIceCream.states.MainMenuState;

import java.io.IOException;

public class LevelCompletedMenuController extends MenuController<LevelCompletedMenu> {
    public LevelCompletedMenuController(LevelCompletedMenu menu, int level) {
        super(menu, level);
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
                if (getModel().isSelectedNextLevel()) game.setState(null, null);
                if (getModel().isSelectedQuitToMainMenu()) game.setState(new MainMenuState(new MainMenu(), level), null);
        }
    }
}
