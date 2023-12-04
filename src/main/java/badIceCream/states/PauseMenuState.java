package badIceCream.states;

import badIceCream.GUI.Graphics;
import badIceCream.model.game.arena.Arena;
import badIceCream.viewer.Viewer;
import badIceCream.controller.Controller;
import badIceCream.controller.menu.PauseMenuController;
import badIceCream.model.menu.PauseMenu;
import badIceCream.viewer.menu.PauseMenuViewer;


public class PauseMenuState extends MenuState<PauseMenu> {
    private Arena arena;
    public PauseMenuState(PauseMenu model, Arena arena, int level) {
        super(model, level);
        this.arena = arena;
    }

    @Override
    protected Viewer<PauseMenu> getViewer() {
        return new PauseMenuViewer(getModel());
    }

    @Override
    protected Controller<PauseMenu> getController() {
        return new PauseMenuController(getModel(), arena);
    }
}
