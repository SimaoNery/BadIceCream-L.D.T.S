package badIceCream.viewer.game;

import badIceCream.GUI.GUI;
import badIceCream.GUI.GameGraphics;
import badIceCream.GUI.Graphics;
import badIceCream.model.game.elements.Wall;

import java.io.IOException;

public class WallViewer implements ElementViewer<Wall> {
    @Override
    public void draw(Wall wall, Graphics gui, int type) {
        switch (type) {
            case 1, 3, 4, 5, 6, 7: gui.drawIceWall(wall.getPosition(), type);
                break;
            case 2: gui.drawStoneWall(wall.getPosition());

        }
    }

}

