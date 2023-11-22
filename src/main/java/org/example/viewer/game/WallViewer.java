package org.example.viewer.game;

import org.example.GUI.GUI;
import org.example.model.game.elements.Wall;

public class WallViewer implements ElementViewer<Wall> {
    @Override
    public void draw(Wall wall, GUI gui){
        switch (wall.getType()) {
            case 1: gui.drawIceWall(wall.getPosition());
                break;
            case 2: gui.drawStoneWall(wall.getPosition());
        }
    }
}

