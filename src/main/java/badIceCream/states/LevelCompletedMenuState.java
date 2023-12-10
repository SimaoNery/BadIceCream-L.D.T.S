package badIceCream.states;

import badIceCream.controller.menu.LevelCompletedMenuController;
import badIceCream.model.menu.LevelCompletedMenu;
import badIceCream.utils.Audio;
import badIceCream.viewer.menu.LevelCompletedMenuViewer;

public class LevelCompletedMenuState extends MenuState<LevelCompletedMenu> {

    public LevelCompletedMenuState(LevelCompletedMenu model, LevelCompletedMenuController controller, LevelCompletedMenuViewer viewer, int level) {
        super(model,controller, viewer, level);
    }
}
