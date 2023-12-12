package badIceCream.states;

import badIceCream.controller.menu.PauseMenuController;
import badIceCream.model.menu.PauseMenu;
import badIceCream.viewer.menu.PauseMenuViewer;


public class PauseMenuState extends MenuState<PauseMenu> {
    public PauseMenuState(PauseMenu model, State<GameState> parent, int level) {
        super(model, new PauseMenuController(model, parent), new PauseMenuViewer(model), level);
    }
}
