package badIceCream.viewer.menu;

import badIceCream.GUI.GUI;
import badIceCream.model.Position;
import badIceCream.model.menu.InstructionsMenu;
import badIceCream.viewer.Viewer;

public class InstructionsMenuViewer extends Viewer<InstructionsMenu> {

    public InstructionsMenuViewer(InstructionsMenu menu) {
        super(menu);
    }
    @Override
    protected void drawElements(GUI gui) {
        for(int i = 0; i < getModel().getNumberEntries(); i++) {
            gui.drawText(new Position(5, 7 + i), getModel().getEntry(i), getModel().isSelected(i) ? "#D1D100" : "#FFFFFF" );
        }
    }
}
