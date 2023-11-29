package badIceCream.controller.menu;

import badIceCream.GUI.GUI;
import badIceCream.Game;
import badIceCream.model.game.arena.LoaderArenaBuilder;
import badIceCream.model.menu.InstructionsMenu;
import badIceCream.model.menu.MainMenu;
import badIceCream.model.menu.SelectLevelMenu;
import badIceCream.states.GameState;
import badIceCream.states.InstructionsMenuState;
import badIceCream.states.MenuState;
import badIceCream.states.SelectLevelMenuState;

import java.io.IOException;

public class MainMenuController extends MenuController<MainMenu> {
    public MainMenuController(MainMenu menu, int level) {
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
                if (getModel().isSelectedExit()) game.setState(null);
                if (getModel().isSelectedInstructions()) game.setState(new InstructionsMenuState(new InstructionsMenu(), level));
                if (getModel().isSelectedStart()) game.setState(new SelectLevelMenuState(new SelectLevelMenu(), level));
        }
    }
}