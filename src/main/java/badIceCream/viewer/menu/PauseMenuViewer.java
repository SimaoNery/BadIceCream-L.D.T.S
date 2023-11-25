package badIceCream.viewer.menu;

import badIceCream.GUI.GUI;
import badIceCream.model.Position;
import badIceCream.model.menu.PauseMenu;
import badIceCream.viewer.Viewer;

public class PauseMenuViewer extends Viewer<PauseMenu> {
    public PauseMenuViewer(PauseMenu menu) {super(menu);}

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(5, 5), "Pause", "#FFFFFF");

        for(int i = 0; i < getModel().getNumberEntries(); i++){
            gui.drawText(new Position(5, 7 + i), getModel().getEntry(i), getModel().isSelected(i) ? "#D1D100" : "#FFFFFF" );
        }
    }
}
