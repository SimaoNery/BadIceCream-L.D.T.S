package badIceCream.viewer.game;

import badIceCream.GUI.GUI;
import badIceCream.model.game.elements.IceCream;

public class IceCreamViewer implements ElementViewer<IceCream>{
    @Override
    public void draw(IceCream ice, GUI gui){
        gui.drawIceCream(ice.getPosition());
    }
}
