package badIceCream.states;

import badIceCream.controller.Controller;
import badIceCream.controller.menu.GameOverMenuController;
import badIceCream.model.menu.GameOverMenu;
import badIceCream.viewer.Viewer;
import badIceCream.viewer.menu.GameOverMenuViewer;

public class GameOverMenuState extends MenuState<GameOverMenu> {

    public GameOverMenuState(GameOverMenu model) {
        super(model);
    }
    @Override
    protected Viewer<GameOverMenu> getViewer() {
        return new GameOverMenuViewer(getModel());
    }

    @Override
    protected Controller<GameOverMenu> getController() {
        return new GameOverMenuController(getModel());
    }
}
