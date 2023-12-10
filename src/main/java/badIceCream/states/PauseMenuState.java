package badIceCream.states;

import badIceCream.controller.menu.InstructionsMenuFirstPageController;
import badIceCream.controller.menu.PauseMenuController;
import badIceCream.model.menu.InstructionsMenuFirstPage;
import badIceCream.model.menu.PauseMenu;
import badIceCream.viewer.menu.InstructionsMenuFirstPageViewer;
import badIceCream.viewer.menu.PauseMenuViewer;


public class PauseMenuState extends MenuState<PauseMenu> {
    public PauseMenuState(PauseMenu model, State parent, int level) {
        super(model, new PauseMenuController(model, parent), new PauseMenuViewer(model), level);
    }
    public PauseMenuState(PauseMenu model, State parent, PauseMenuController controller, PauseMenuViewer viewer, int level) {
        super(model, controller, viewer, level);
    }
}
