package badIceCream.viewer;

import badIceCream.GUI.Graphics;
import badIceCream.model.Position;
import badIceCream.model.game.elements.fruits.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class FruitViewerTest {
    private FruitViewer viewer;
    @Mock
    private Graphics graphics;
    @Mock
    private Position position;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);

        viewer = new FruitViewer();
    }

    @Test
    void drawApple(){
        AppleFruit apple = mock(AppleFruit.class);
        when(apple.getPosition()).thenReturn(position);

        viewer.draw(apple, graphics, 1);
        verify(graphics, times(1)).drawAppleFruit(position);
    }

    @Test
    void drawBanana(){
        BananaFruit banana = mock(BananaFruit.class);
        when(banana.getPosition()).thenReturn(position);

        viewer.draw(banana, graphics, 2);
        verify(graphics, times(1)).drawBananaFruit(position);
    }

    @Test
    void drawPepper(){
        CherryFruit pepper = mock(CherryFruit.class);
        when(pepper.getPosition()).thenReturn(position);

        viewer.draw(pepper, graphics, 3);
        verify(graphics, times(1)).drawCherryFruit(position);
    }

    @Test
    void drawPineapple(){
        PineappleFruit pineapple = mock(PineappleFruit.class);
        when(pineapple.getPosition()).thenReturn(position);

        viewer.draw(pineapple, graphics, 4);
        verify(graphics, times(1)).drawPineappleFruit(position);
    }

    @Test
    void drawStrawberry(){
        StrawberryFruit strawberry = mock(StrawberryFruit.class);
        when(strawberry.getPosition()).thenReturn(position);

        viewer.draw(strawberry, graphics, 5);
        verify(graphics, times(1)).drawStrawberryFruit(position);
    }
}

