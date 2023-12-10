package badIceCream.states;

import badIceCream.controller.menu.InstructionsMenuSecondPageController;
import badIceCream.model.menu.InstructionsMenuSecondPage;
import badIceCream.viewer.menu.InstructionsMenuSecondPageViewer;

public class InstructionsMenuSecondPageState extends MenuState<InstructionsMenuSecondPage> {
    public InstructionsMenuSecondPageState(InstructionsMenuSecondPage model,InstructionsMenuSecondPageController controller, InstructionsMenuSecondPageViewer viewer, int level) {
        super(model, controller, viewer, level);
    }
}
