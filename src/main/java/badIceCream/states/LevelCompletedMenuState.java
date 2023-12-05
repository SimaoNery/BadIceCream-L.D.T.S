package badIceCream.states;

import badIceCream.controller.Controller;
import badIceCream.controller.menu.LevelCompletedMenuController;
import badIceCream.model.menu.LevelCompletedMenu;
import badIceCream.utils.Audio;
import badIceCream.viewer.Viewer;
import badIceCream.viewer.menu.LevelCompletedMenuViewer;

public class LevelCompletedMenuState extends MenuState<LevelCompletedMenu> {

    public LevelCompletedMenuState(LevelCompletedMenu model, int level, Audio audio) {
        super(model, new LevelCompletedMenuController(model, audio), new LevelCompletedMenuViewer(model), level);
    }
}
