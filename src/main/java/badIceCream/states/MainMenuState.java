package badIceCream.states;

import badIceCream.controller.menu.InstructionsMenuFirstPageController;
import badIceCream.model.menu.InstructionsMenuFirstPage;
import badIceCream.model.menu.MainMenu;
import badIceCream.viewer.Viewer;
import badIceCream.controller.Controller;
import badIceCream.controller.menu.MainMenuController;
import badIceCream.viewer.menu.InstructionsMenuFirstPageViewer;
import badIceCream.viewer.menu.MainMenuViewer;

public class MainMenuState extends MenuState<MainMenu> {
    public MainMenuState(MainMenu model, int level) {
        super(model, new MainMenuController(model), new MainMenuViewer(model), level);
    }
    public MainMenuState(MainMenu model, MainMenuController controller, MainMenuViewer viewer, int level) {
        super(model, controller, viewer, level);
    }
}
