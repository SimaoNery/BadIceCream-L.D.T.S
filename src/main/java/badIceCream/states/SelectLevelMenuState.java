package badIceCream.states;

import badIceCream.controller.Controller;
import badIceCream.controller.menu.PauseMenuController;
import badIceCream.controller.menu.SelectLevelMenuController;
import badIceCream.model.menu.PauseMenu;
import badIceCream.model.menu.SelectLevelMenu;
import badIceCream.viewer.Viewer;
import badIceCream.viewer.menu.PauseMenuViewer;
import badIceCream.viewer.menu.SelectLevelMenuViewer;

public class SelectLevelMenuState extends MenuState<SelectLevelMenu> {
    public SelectLevelMenuState(SelectLevelMenu model) {
        super(model);
    }

    @Override
    protected Viewer<SelectLevelMenu> getViewer() {
        return new SelectLevelMenuViewer(getModel());
    }

    @Override
    protected Controller<SelectLevelMenu> getController() {
        return new SelectLevelMenuController(getModel());
    }
}
