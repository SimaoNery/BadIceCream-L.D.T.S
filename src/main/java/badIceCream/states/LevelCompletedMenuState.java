package badIceCream.states;

import badIceCream.controller.menu.InstructionsMenuFirstPageController;
import badIceCream.controller.menu.LevelCompletedMenuController;
import badIceCream.model.menu.InstructionsMenuFirstPage;
import badIceCream.model.menu.LevelCompletedMenu;
import badIceCream.utils.Audio;
import badIceCream.viewer.menu.InstructionsMenuFirstPageViewer;
import badIceCream.viewer.menu.LevelCompletedMenuViewer;

public class LevelCompletedMenuState extends MenuState<LevelCompletedMenu> {

    public LevelCompletedMenuState(LevelCompletedMenu model, int level) {
        super(model, new LevelCompletedMenuController(model), new LevelCompletedMenuViewer(model), level);
    }

    public LevelCompletedMenuState(LevelCompletedMenu model, LevelCompletedMenuController controller, LevelCompletedMenuViewer viewer, int level) {
        super(model, controller, viewer, level);
    }
}
