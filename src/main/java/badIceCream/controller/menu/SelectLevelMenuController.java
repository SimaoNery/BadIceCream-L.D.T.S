package badIceCream.controller.menu;

import badIceCream.GUI.GUI;
import badIceCream.GUI.GameGraphics;
import badIceCream.Game;
import badIceCream.model.game.arena.LoaderArenaBuilder;
import badIceCream.model.menu.SelectLevelMenu;
import badIceCream.states.GameState;

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
                if (getModel().isSelectedLevel1()) game.setState(new GameState(new LoaderArenaBuilder(1).createArena(), game.getState().getLevel()), new GameGraphics(70, 50));
                if (getModel().isSelectedLevel2() && game.getState().getLevel() >= 2) game.setState(new GameState(new LoaderArenaBuilder(2).createArena(), game.getState().getLevel()), new GameGraphics(70, 50));
                if (getModel().isSelectedLevel3() && game.getState().getLevel() >= 3) game.setState(new GameState(new LoaderArenaBuilder(3).createArena(), game.getState().getLevel()), new GameGraphics(70, 50));
                if (getModel().isSelectedLevel4() && game.getState().getLevel() >= 4) game.setState(new GameState(new LoaderArenaBuilder(4).createArena(), game.getState().getLevel()), new GameGraphics(70, 50));
                if (getModel().isSelectedLevel5() && game.getState().getLevel() >= 5) game.setState(new GameState(new LoaderArenaBuilder(5).createArena(), game.getState().getLevel()), new GameGraphics(70, 50));

        }
    }
}
