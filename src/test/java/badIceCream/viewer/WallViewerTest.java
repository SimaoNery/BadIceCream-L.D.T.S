package badIceCream.viewer;

import badIceCream.GUI.Graphics;
import badIceCream.model.Position;
import badIceCream.model.game.elements.IceWall;
import badIceCream.model.game.elements.StoneWall;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class WallViewerTest {
    private WallViewer viewer;
    @Mock
    private Graphics graphics;
    @Mock
    private Position position;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);

        viewer = new WallViewer();
    }

    @Test
    void drawStoneWall(){
        StoneWall stoneWall = mock(StoneWall.class);
        when(stoneWall.getPosition()).thenReturn(position);

        viewer.draw(stoneWall, graphics, 2);
        verify(graphics, times(1)).drawStoneWall(position);
    }

    @Test
    void drawIceWallDefault(){
        IceWall iceWallDefault = mock(IceWall.class);
        when(iceWallDefault.getPosition()).thenReturn(position);
        when(iceWallDefault.getType()).thenReturn(1);

        viewer.draw(iceWallDefault, graphics, 1);
        verify(graphics, times(1)).drawIceWall(position, 1);
    }

    @Test
    void drawIceWallApple(){
        IceWall iceWallApple = mock(IceWall.class);
        when(iceWallApple.getPosition()).thenReturn(position);
        when(iceWallApple.getType()).thenReturn(3);

        viewer.draw(iceWallApple, graphics, 3);
        verify(graphics, times(1)).drawIceWall(position, 3);
    }

    @Test
    void drawIceWallPepper(){
        IceWall iceWallPepper = mock(IceWall.class);
        when(iceWallPepper.getPosition()).thenReturn(position);
        when(iceWallPepper.getType()).thenReturn(4);

        viewer.draw(iceWallPepper, graphics, 4);
        verify(graphics, times(1)).drawIceWall(position, 4);
    }

    @Test
    void drawIceWallBanana(){
        IceWall iceWallBanana = mock(IceWall.class);
        when(iceWallBanana.getPosition()).thenReturn(position);
        when(iceWallBanana.getType()).thenReturn(5);

        viewer.draw(iceWallBanana, graphics, 5);
        verify(graphics, times(1)).drawIceWall(position, 5);
    }

    @Test
    void drawIceWallPineapple(){
        IceWall iceWallPineapple = mock(IceWall.class);
        when(iceWallPineapple.getPosition()).thenReturn(position);
        when(iceWallPineapple.getType()).thenReturn(6);

        viewer.draw(iceWallPineapple, graphics, 6);
        verify(graphics, times(1)).drawIceWall(position, 6);
    }

    @Test
    void drawIceWallStrawberry(){
        IceWall iceWallStrawberry = mock(IceWall.class);
        when(iceWallStrawberry.getPosition()).thenReturn(position);
        when(iceWallStrawberry.getType()).thenReturn(7);

        viewer.draw(iceWallStrawberry, graphics, 7);
        verify(graphics, times(1)).drawIceWall(position, 7);
    }

    @Test
    void drawIceWallJumperDown(){
        IceWall iceWallJumperDown = mock(IceWall.class);
        when(iceWallJumperDown.getPosition()).thenReturn(position);
        when(iceWallJumperDown.getType()).thenReturn(8);

        viewer.draw(iceWallJumperDown, graphics, 8);
        verify(graphics, times(1)).drawIceWall(position, 8);
    }
    @Test
    void drawIceWallJumperUp(){
        IceWall iceWallJumperUp = mock(IceWall.class);
        when(iceWallJumperUp.getPosition()).thenReturn(position);
        when(iceWallJumperUp.getType()).thenReturn(9);

        viewer.draw(iceWallJumperUp, graphics, 9);
        verify(graphics, times(1)).drawIceWall(position, 9);
    }
    @Test
    void drawIceWallJumperLeft(){
        IceWall iceWallJumperLeft = mock(IceWall.class);
        when(iceWallJumperLeft.getPosition()).thenReturn(position);
        when(iceWallJumperLeft.getType()).thenReturn(10);

        viewer.draw(iceWallJumperLeft, graphics, 10);
        verify(graphics, times(1)).drawIceWall(position, 10);
    }

    @Test
    void drawIceWallJumperRight(){
        IceWall iceWallJumperRight = mock(IceWall.class);
        when(iceWallJumperRight.getPosition()).thenReturn(position);
        when(iceWallJumperRight.getType()).thenReturn(11);

        viewer.draw(iceWallJumperRight, graphics, 11);
        verify(graphics, times(1)).drawIceWall(position, 11);
    }
}
