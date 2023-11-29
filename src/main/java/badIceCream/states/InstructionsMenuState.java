package badIceCream.states;

import badIceCream.controller.Controller;
import badIceCream.model.menu.InstructionsMenu;
import badIceCream.viewer.Viewer;


public class InstructionsMenuState extends MenuState<InstructionsMenu> {
    public InstructionsMenuState(InstructionsMenu model) {
        super(model);
    }

    @Override
    protected Viewer<InstructionsMenu> getViewer() {
        return null;
    }

    @Override
    protected Controller<InstructionsMenu> getController() {
        return null;
    }
}
