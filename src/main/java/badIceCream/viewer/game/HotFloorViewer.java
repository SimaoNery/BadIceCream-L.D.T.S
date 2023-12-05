package badIceCream.viewer.game;

import badIceCream.GUI.GUI;
import badIceCream.GUI.GameGraphics;
import badIceCream.GUI.Graphics;
import badIceCream.model.Position;
import badIceCream.model.game.elements.Element;
import badIceCream.model.game.elements.HotFloor;

public class HotFloorViewer implements ElementViewer<HotFloor> {
    @Override
    public void draw(HotFloor hotFloor, Graphics gui, int type) {
        gui.drawHotFloor(hotFloor.getPosition(), type);
    }

}
