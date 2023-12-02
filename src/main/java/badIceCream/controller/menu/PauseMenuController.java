package badIceCream.controller.menu;

import badIceCream.GUI.GUI;
import badIceCream.GUI.GameGraphics;
import badIceCream.GUI.Graphics;
import badIceCream.Game;
import badIceCream.model.game.arena.Arena;
import badIceCream.model.menu.MainMenu;
import badIceCream.model.menu.PauseMenu;
import badIceCream.states.GameState;
import badIceCream.states.MainMenuState;
import badIceCream.states.State;

import java.io.IOException;

public class PauseMenuController extends MenuController<PauseMenu> {
    private final GameState previous;

    public PauseMenuController(PauseMenu menu, GameState previous) {
        super(menu);
        this.previous = previous;
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
                if (getModel().isSelectedResume()) game.setState(previous, new GameGraphics(70, 50));
                if (getModel().isSelectedMenu()) game.setState(new MainMenuState(new MainMenu(), game.getState().getLevel()), null);
        }
    }
}
