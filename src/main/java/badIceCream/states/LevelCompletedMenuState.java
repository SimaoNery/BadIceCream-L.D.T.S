package badIceCream.states;

import badIceCream.controller.Controller;
import badIceCream.controller.menu.LevelCompletedMenuController;
import badIceCream.model.menu.LevelCompletedMenu;
import badIceCream.viewer.Viewer;
import badIceCream.viewer.menu.LevelCompletedMenuViewer;

public class LevelCompletedMenuState extends MenuState<LevelCompletedMenu> {

    public LevelCompletedMenuState(LevelCompletedMenu model, int level) {
        super(model, level);
    }
    @Override
    protected Viewer<LevelCompletedMenu> getViewer() {

        return new LevelCompletedMenuViewer(getModel());
    }
    @Override
    protected Controller<LevelCompletedMenu> getController() {

        return new LevelCompletedMenuController(getModel());
    }
}
