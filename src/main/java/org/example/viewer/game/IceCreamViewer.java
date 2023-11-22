package org.example.viewer.game;

import org.example.GUI.GUI;
import org.example.model.Position;
import org.example.model.game.elements.IceCream;

public class IceCreamViewer implements ElementViewer<IceCream>{
    @Override
    public void draw(IceCream ice, GUI gui){
        gui.drawIceCream(ice.getPosition());
    }
}
