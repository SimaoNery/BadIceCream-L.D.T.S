package badIceCream.states;

import badIceCream.GUI.Graphics;
import badIceCream.viewer.Viewer;
import badIceCream.controller.Controller;
import badIceCream.controller.menu.PauseMenuController;
import badIceCream.model.menu.PauseMenu;
import badIceCream.viewer.menu.PauseMenuViewer;


public class PauseMenuState extends MenuState<PauseMenu> {
    private final State state;
    private final Graphics graphics;
    public PauseMenuState(PauseMenu model, State state, int level, Graphics graphics) {
        super(model, level);
        this.state = state;
        this.graphics = graphics;
    }

    @Override
    protected Viewer<PauseMenu> getViewer() {
        return new PauseMenuViewer(getModel());
    }

    @Override
    protected Controller<PauseMenu> getController() {
        return new PauseMenuController(getModel(), state, level, graphics);
    }
}
