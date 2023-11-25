package badIceCream.controller.menu;

import badIceCream.GUI.GUI;
import badIceCream.Game;
import badIceCream.model.game.arena.LoaderArenaBuilder;
import badIceCream.model.menu.MainMenu;
import badIceCream.states.GameState;

import java.io.IOException;

public class MainMenuController extends MenuController<MainMenu> {
    public MainMenuController(MainMenu menu) {
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
                if (getModel().isSelectedExit()) game.setState(null);
                if (getModel().isSelectedStart()) game.setState(new GameState(new LoaderArenaBuilder(1).createArena()));
        }
    }
}