package org.example.viewer.game;

import org.example.GUI.GUI;
import org.example.model.game.elements.IceWall;

public class IceWallViewer implements ElementViewer<IceWall>{
    @Override
    public void draw(IceWall iceWall, GUI gui){
        gui.drawIceWall(iceWall.getPosition());
    }
}
