package badIceCream.viewer.game;

import badIceCream.GUI.GUI;
import badIceCream.model.Position;
import badIceCream.model.game.elements.Element;
import badIceCream.model.game.elements.HotFloor;

public class HotFloorViewer implements ElementViewer<HotFloor> {
    @Override
    public void draw(HotFloor hotFloor, GUI gui) {
        gui.drawHotFloor(hotFloor.getPosition());
    }
}
