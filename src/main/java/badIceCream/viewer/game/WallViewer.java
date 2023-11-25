package badIceCream.viewer.game;

import badIceCream.GUI.GUI;
import badIceCream.model.game.elements.Wall;

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

