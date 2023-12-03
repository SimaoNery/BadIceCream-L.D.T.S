package badIceCream.viewer.game;

import badIceCream.GUI.GUI;
import badIceCream.GUI.GameGraphics;
import badIceCream.GUI.Graphics;
import badIceCream.model.game.elements.IceCream;

public class IceCreamViewer implements ElementViewer<IceCream>{
    @Override
    public void draw(IceCream ice, Graphics gui){
        gui.drawIceCream(ice.getPosition(), ice.getLastMovement(), ice.isStrawberryActive());
    }
}
