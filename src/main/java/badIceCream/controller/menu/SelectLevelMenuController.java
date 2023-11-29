package badIceCream.controller.menu;

import badIceCream.GUI.GUI;
import badIceCream.Game;
import badIceCream.controller.Controller;
import badIceCream.model.game.arena.LoaderArenaBuilder;
import badIceCream.model.menu.InstructionsMenu;
import badIceCream.model.menu.SelectLevelMenu;
import badIceCream.states.GameState;
import badIceCream.states.InstructionsMenuState;
import badIceCream.states.SelectLevelMenuState;

import java.io.IOException;

public class SelectLevelMenuController extends MenuController<SelectLevelMenu> {
    public SelectLevelMenuController(SelectLevelMenu menu) {
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
                if (getModel().isSelectedLevel1()) game.setState(new GameState(new LoaderArenaBuilder(1).createArena()));
                if (getModel().isSelectedLevel2()) game.setState(new GameState(new LoaderArenaBuilder(2).createArena()));
                if (getModel().isSelectedLevel3()) game.setState(new GameState(new LoaderArenaBuilder(3).createArena()));
                if (getModel().isSelectedLevel4()) game.setState(new GameState(new LoaderArenaBuilder(4).createArena()));
                if (getModel().isSelectedLevel5()) game.setState(new GameState(new LoaderArenaBuilder(5).createArena()));
        }
    }
}
