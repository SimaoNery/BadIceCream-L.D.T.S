package badIceCream.states;

import badIceCream.controller.Controller;
import badIceCream.controller.menu.GameOverMenuController;
import badIceCream.model.menu.GameOverMenu;
import badIceCream.utils.Audio;
import badIceCream.viewer.Viewer;
import badIceCream.viewer.menu.GameOverMenuViewer;

public class GameOverMenuState extends MenuState<GameOverMenu> {

    public GameOverMenuState(GameOverMenu model, int level) {
        super(model, new GameOverMenuController(model), new GameOverMenuViewer(model), level);
    }
}
