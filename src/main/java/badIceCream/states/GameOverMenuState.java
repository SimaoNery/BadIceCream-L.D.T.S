package badIceCream.states;

import badIceCream.controller.menu.GameOverMenuController;
import badIceCream.model.menu.GameOverMenu;
import badIceCream.viewer.menu.GameOverMenuViewer;

public class GameOverMenuState extends MenuState<GameOverMenu> {
    public GameOverMenuState(GameOverMenu model, GameOverMenuController controller, GameOverMenuViewer viewer ,int level){
        super(model, controller, viewer, level);
    }
}
