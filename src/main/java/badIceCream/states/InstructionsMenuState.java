package badIceCream.states;

import badIceCream.controller.Controller;
import badIceCream.controller.menu.InstructionsMenuController;
import badIceCream.controller.menu.LevelCompletedMenuController;
import badIceCream.model.menu.InstructionsMenu;
import badIceCream.viewer.Viewer;
import badIceCream.viewer.menu.InstructionsMenuViewer;
import badIceCream.viewer.menu.LevelCompletedMenuViewer;


public class InstructionsMenuState extends MenuState<InstructionsMenu> {
    public InstructionsMenuState(InstructionsMenu model, int level) {
        super(model, new InstructionsMenuController(model), new InstructionsMenuViewer(model), level);
    }

}
