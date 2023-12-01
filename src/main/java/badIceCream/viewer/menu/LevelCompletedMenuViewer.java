package badIceCream.viewer.menu;

import badIceCream.GUI.GUI;
import badIceCream.GUI.Graphics;
import badIceCream.model.Position;
import badIceCream.model.menu.LevelCompletedMenu;
import badIceCream.viewer.Viewer;

public class LevelCompletedMenuViewer extends Viewer<LevelCompletedMenu> {
    public LevelCompletedMenuViewer(LevelCompletedMenu menu) {
        super(menu);
    }
    @Override
    protected void drawElements(Graphics gui) {
        for(int i = 0; i < getModel().getNumberEntries(); i++) {
            gui.drawText(new Position(5, 7 + i), getModel().getEntry(i), getModel().isSelected(i) ? "#D1D100" : "#FFFFFF" );
        }
    }
}
