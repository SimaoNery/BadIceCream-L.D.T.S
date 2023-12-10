package badIceCream.states;

import badIceCream.model.menu.MainMenu;
import badIceCream.viewer.Viewer;
import badIceCream.controller.Controller;
import badIceCream.controller.menu.MainMenuController;
import badIceCream.viewer.menu.MainMenuViewer;

public class MainMenuState extends MenuState<MainMenu> {
    public MainMenuState(MainMenu model,MainMenuController controller, MainMenuViewer viewer, int level) {
        super(model, controller, viewer, level);
    }
}
