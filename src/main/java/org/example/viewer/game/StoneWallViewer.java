package org.example.viewer.game;

import org.example.GUI.GUI;
import org.example.model.game.elements.StoneWall;

public class StoneWallViewer implements ElementViewer<StoneWall>{
    public void draw(StoneWall stoneWall, GUI gui){
        gui.drawStoneWall(stoneWall.getPosition());
    }
}
