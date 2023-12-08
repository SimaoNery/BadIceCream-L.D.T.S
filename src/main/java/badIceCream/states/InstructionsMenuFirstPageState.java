package badIceCream.states;

import badIceCream.controller.menu.InstructionsMenuFirstPageController;
import badIceCream.model.menu.InstructionsMenuFirstPage;
import badIceCream.viewer.menu.InstructionsMenuFirstPageViewer;


public class InstructionsMenuFirstPageState extends MenuState<InstructionsMenuFirstPage> {
    public InstructionsMenuFirstPageState(InstructionsMenuFirstPage model, int level) {
        super(model, new InstructionsMenuFirstPageController(model), new InstructionsMenuFirstPageViewer(model), level);
    }

}
