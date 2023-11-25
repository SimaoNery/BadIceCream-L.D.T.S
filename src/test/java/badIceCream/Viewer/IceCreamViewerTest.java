package badIceCream.Viewer;

import badIceCream.model.game.elements.IceCream;
import badIceCream.GUI.GUI;
import badIceCream.viewer.game.IceCreamViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class IceCreamViewerTest {
    private IceCream iceCream;
    private IceCreamViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        iceCream = new IceCream(10, 10);
        viewer = new IceCreamViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawIceCream() {
        viewer.draw(iceCream, gui);
        Mockito.verify(gui, Mockito.times(1)).drawIceCream(iceCream.getPosition());
    }
}
