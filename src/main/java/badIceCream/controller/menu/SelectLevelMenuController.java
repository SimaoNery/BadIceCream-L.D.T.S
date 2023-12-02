package badIceCream.controller.menu;

import badIceCream.GUI.GUI;
import badIceCream.GUI.GameGraphics;
import badIceCream.Game;
import badIceCream.model.game.arena.LoaderArenaBuilder;
import badIceCream.model.menu.SelectLevelMenu;
import badIceCream.states.GameState;

import java.io.IOException;

public class SelectLevelMenuController extends MenuController<SelectLevelMenu> {
    public SelectLevelMenuController(SelectLevelMenu menu, int level) {
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
                if (getModel().isSelectedLevel1()) game.setState(new GameState(new LoaderArenaBuilder(1).createArena(), level), new GameGraphics(70, 50));
                if (getModel().isSelectedLevel2() && level >= 2) game.setState(new GameState(new LoaderArenaBuilder(2).createArena(), level), new GameGraphics(70, 50));
                if (getModel().isSelectedLevel3() && level >= 3) game.setState(new GameState(new LoaderArenaBuilder(3).createArena(), level), new GameGraphics(70, 50));
                if (getModel().isSelectedLevel4() && level >= 4) game.setState(new GameState(new LoaderArenaBuilder(4).createArena(), level), new GameGraphics(70, 50));
                if (getModel().isSelectedLevel5() && level >= 5) game.setState(new GameState(new LoaderArenaBuilder(5).createArena(), level), new GameGraphics(70, 50));

        }
    }
}
