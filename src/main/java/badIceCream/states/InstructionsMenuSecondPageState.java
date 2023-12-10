package badIceCream.states;

import badIceCream.controller.menu.InstructionsMenuFirstPageController;
import badIceCream.controller.menu.InstructionsMenuSecondPageController;
import badIceCream.model.menu.InstructionsMenuFirstPage;
import badIceCream.model.menu.InstructionsMenuSecondPage;
import badIceCream.viewer.menu.InstructionsMenuFirstPageViewer;
import badIceCream.viewer.menu.InstructionsMenuSecondPageViewer;

public class InstructionsMenuSecondPageState extends MenuState<InstructionsMenuSecondPage> {
    public InstructionsMenuSecondPageState(InstructionsMenuSecondPage model, int level) {
        super(model, new InstructionsMenuSecondPageController(model), new InstructionsMenuSecondPageViewer(model), level);
    }

    public InstructionsMenuSecondPageState(InstructionsMenuSecondPage model, InstructionsMenuSecondPageController controller, InstructionsMenuSecondPageViewer viewer, int level) {
        super(model, controller, viewer, level);
    }
}
