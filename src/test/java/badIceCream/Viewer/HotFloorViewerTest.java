package badIceCream.Viewer;

import badIceCream.GUI.GUI;
import badIceCream.model.game.elements.HotFloor;
import badIceCream.model.game.elements.IceWall;
import badIceCream.model.game.elements.StoneWall;
import badIceCream.model.game.elements.Wall;
import badIceCream.viewer.game.HotFloorViewer;
import badIceCream.viewer.game.WallViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class HotFloorViewerTest {
    private HotFloor hotFloor;
    private HotFloorViewer viewer;
    private GUI gui;
    @BeforeEach
    void setUp() {
        hotFloor = new HotFloor(10,10);
        viewer = new HotFloorViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawHotFloor() throws IOException {
        viewer.draw(hotFloor, gui);
        Mockito.verify(gui, Mockito.times(1)).drawHotFloor(hotFloor.getPosition());
    }
}
