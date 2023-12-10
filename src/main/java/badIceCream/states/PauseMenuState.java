package badIceCream.states;

import badIceCream.controller.menu.PauseMenuController;
import badIceCream.model.menu.PauseMenu;
import badIceCream.viewer.menu.PauseMenuViewer;


public class PauseMenuState extends MenuState<PauseMenu> {
    public PauseMenuState(PauseMenu model, State parent, PauseMenuController controller, PauseMenuViewer viewer, int level) {
        super(model, controller, viewer, level);
    }
}
