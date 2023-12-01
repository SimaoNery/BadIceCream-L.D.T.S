package badIceCream.controller.menu;

import badIceCream.GUI.GUI;
import badIceCream.GUI.GameGraphics;
import badIceCream.GUI.Graphics;
import badIceCream.Game;
import badIceCream.model.menu.MainMenu;
import badIceCream.model.menu.PauseMenu;
import badIceCream.states.GameState;
import badIceCream.states.MainMenuState;
import badIceCream.states.State;

import java.io.IOException;

public class PauseMenuController extends MenuController<PauseMenu> {
    private final State lastState;
    private final Graphics lastGui;

    public PauseMenuController(PauseMenu menu, State lastState, int level, Graphics lastGui) {
        super(menu, level);
        this.lastState = lastState;
        this.lastGui = lastGui;
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
                if (getModel().isSelectedResume()) game.setState(lastState, lastGui.getGui());
                if (getModel().isSelectedMenu()) game.setState(new MainMenuState(new MainMenu(), level), null);
        }
    }
}
