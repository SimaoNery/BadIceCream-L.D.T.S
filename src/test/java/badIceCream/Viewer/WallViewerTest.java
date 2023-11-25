package badIceCream.Viewer;

import badIceCream.model.game.elements.IceWall;
import badIceCream.model.game.elements.StoneWall;
import badIceCream.model.game.elements.Wall;
import badIceCream.GUI.GUI;
import badIceCream.viewer.game.WallViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class WallViewerTest {
    private List<Wall> walls;
    private WallViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        walls = Arrays.asList(
                new IceWall(1, 1), new IceWall(2, 2), new IceWall(3, 3),
                new StoneWall(4, 4), new StoneWall(5, 5), new StoneWall(6, 6));

        viewer = new WallViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawWalls() throws IOException {
        for(Wall wall : walls){
            viewer.draw(wall, gui);

            switch (wall.getType()){
                case 1: Mockito.verify(gui, Mockito.times(1)).drawIceWall(wall.getPosition());
                    break;
                case 2: Mockito.verify(gui, Mockito.times(1)).drawStoneWall(wall.getPosition());
                    break;
            }

        }
    }
}
