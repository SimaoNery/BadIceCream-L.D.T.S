package badIceCream.states;

import badIceCream.controller.Controller;
import badIceCream.model.menu.GameOverMenu;
import badIceCream.viewer.Viewer;

public class GameOverMenuState extends MenuState<GameOverMenu> {

    public GameOverMenuState(GameOverMenu model) {
        super(model);
    }
    @Override
    protected Viewer<GameOverMenu> getViewer() {
        return null;
    }

    @Override
    protected Controller<GameOverMenu> getController() {
        return null;
    }
}
