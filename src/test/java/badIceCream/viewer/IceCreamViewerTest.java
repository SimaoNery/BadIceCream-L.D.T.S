package badIceCream.viewer;

import badIceCream.GUI.GUI;
import badIceCream.GUI.Graphics;
import badIceCream.model.Position;
import badIceCream.model.game.elements.IceCream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class IceCreamViewerTest {
    private IceCreamViewer viewer;
    @Mock
    private Graphics graphics;
    @Mock
    private Position position;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);

        viewer = new IceCreamViewer();
    }

    @Test
    void drawIceCreamNoShield(){
        IceCream iceCreamNoShield = mock(IceCream.class);
        when(iceCreamNoShield.getPosition()).thenReturn(position);
        when(iceCreamNoShield.getLastMovement()).thenReturn(GUI.ACTION.UP);
        when(iceCreamNoShield.isStrawberryActive()).thenReturn(false);

        viewer.draw(iceCreamNoShield, graphics, 1);
        verify(graphics, times(1)).drawIceCream(position, GUI.ACTION.UP, false);
    }

    @Test
    void drawIceCreamShield(){
        IceCream iceCreamShield = mock(IceCream.class);
        when(iceCreamShield.getPosition()).thenReturn(position);
        when(iceCreamShield.getLastMovement()).thenReturn(GUI.ACTION.UP);
        when(iceCreamShield.isStrawberryActive()).thenReturn(true);

        viewer.draw(iceCreamShield, graphics, 1);
        verify(graphics, times(1)).drawIceCream(position, GUI.ACTION.UP, true);
    }
}
