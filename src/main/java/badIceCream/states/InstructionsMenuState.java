package badIceCream.states;

import badIceCream.controller.Controller;
import badIceCream.controller.menu.InstructionsMenuController;
import badIceCream.model.menu.InstructionsMenu;
import badIceCream.viewer.Viewer;
import badIceCream.viewer.menu.InstructionsMenuViewer;


public class InstructionsMenuState extends MenuState<InstructionsMenu> {
    public InstructionsMenuState(InstructionsMenu model) {
        super(model);
    }

    @Override
    protected Viewer<InstructionsMenu> getViewer() {
        return new InstructionsMenuViewer(getModel());
    }

    @Override
    protected Controller<InstructionsMenu> getController() {
        return new InstructionsMenuController(getModel());
    }
}
