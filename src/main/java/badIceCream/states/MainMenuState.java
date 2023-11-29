package badIceCream.states;

import badIceCream.model.menu.MainMenu;
import badIceCream.viewer.Viewer;
import badIceCream.controller.Controller;
import badIceCream.controller.menu.MainMenuController;
import badIceCream.viewer.menu.MainMenuViewer;

public class MainMenuState extends MenuState<MainMenu> {
    public MainMenuState(MainMenu model, int level) {
        super(model, level);
    }

    @Override
    protected Viewer<MainMenu> getViewer() {
        return new MainMenuViewer(getModel());
    }

    @Override
    protected Controller<MainMenu> getController() {
        return new MainMenuController(getModel(), level);
    }
}
