package badIceCream.states;

import badIceCream.GUI.Graphics;
import badIceCream.model.game.arena.Arena;
import badIceCream.viewer.Viewer;
import badIceCream.controller.Controller;
import badIceCream.controller.menu.PauseMenuController;
import badIceCream.model.menu.PauseMenu;
import badIceCream.viewer.menu.PauseMenuViewer;


public class PauseMenuState extends MenuState<PauseMenu> {
    public PauseMenuState(PauseMenu model, State parent, int level) {
        super(model, new PauseMenuController(model, parent), new PauseMenuViewer(model), level);
    }

    @Override
    protected Viewer<PauseMenu> getViewer() {
        return new PauseMenuViewer(getModel());
    }

    @Override
    protected Controller<PauseMenu> getController() {
        return new PauseMenuController(getModel(), null);
    }
}
