package badIceCream.states;

import badIceCream.controller.Controller;
import badIceCream.model.menu.LevelCompletedMenu;
import badIceCream.viewer.Viewer;

public class LevelCompletedMenuState extends MenuState<LevelCompletedMenu> {

    public LevelCompletedMenuState(LevelCompletedMenu model) {
        super(model);
    }
    @Override
    protected Viewer<LevelCompletedMenu> getViewer() {
        return null;
    }
    @Override
    protected Controller<LevelCompletedMenu> getController() {
        return null;
    }
}
