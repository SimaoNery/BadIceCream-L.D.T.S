package badIceCream.states;

import badIceCream.controller.Controller;
import badIceCream.controller.menu.PauseMenuController;
import badIceCream.model.menu.PauseMenu;
import badIceCream.model.menu.SelectLevelMenu;
import badIceCream.viewer.Viewer;
import badIceCream.viewer.menu.PauseMenuViewer;

public class SelectLevelMenuState extends MenuState<SelectLevelMenu> {
    public SelectLevelMenuState(SelectLevelMenu model) {
        super(model);
    }

    @Override
    protected Viewer<SelectLevelMenu> getViewer() {
        return null;
    }

    @Override
    protected Controller<SelectLevelMenu> getController() {
        return null;
    }
}
