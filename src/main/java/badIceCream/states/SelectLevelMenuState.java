package badIceCream.states;

import badIceCream.controller.Controller;
import badIceCream.controller.menu.SelectLevelMenuController;
import badIceCream.model.menu.SelectLevelMenu;
import badIceCream.viewer.Viewer;
import badIceCream.viewer.menu.SelectLevelMenuViewer;

public class SelectLevelMenuState extends MenuState<SelectLevelMenu> {
    public SelectLevelMenuState(SelectLevelMenu model, int level) {
        super(model, new SelectLevelMenuController(model), new SelectLevelMenuViewer(model), level);
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
