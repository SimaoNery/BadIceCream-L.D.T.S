package badIceCream.viewer;

import badIceCream.GUI.Graphics;
import badIceCream.model.Position;
import badIceCream.model.game.elements.HotFloor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class HotFloorTest {
    private HotFloorViewer viewer;
    @Mock
    private Graphics graphics;
    @Mock
    private Position position;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);

        viewer = new HotFloorViewer();
    }

    @Test
    void drawDefaultHotFloor(){
        HotFloor defaultHotFloor = mock(HotFloor.class);
        when(defaultHotFloor.getPosition()).thenReturn(position);
        when(defaultHotFloor.getType()).thenReturn(0);

        viewer.draw(defaultHotFloor, graphics, 0);
        verify(graphics, times(1)).drawHotFloor(position, 0);
    }
    //-----------------------------------------------------------------------------------
    @Test
    void drawDefaultMonsterUptHotFloor(){
        HotFloor defaulMonsterUptHotFloor = mock(HotFloor.class);
        when(defaulMonsterUptHotFloor.getPosition()).thenReturn(position);
        when(defaulMonsterUptHotFloor.getType()).thenReturn(1);

        viewer.draw(defaulMonsterUptHotFloor, graphics, 1);
        verify(graphics, times(1)).drawHotFloor(position, 1);
    }

    @Test
    void drawDefaultMonsterRightHotFloor(){
        HotFloor defaulMonsterRightHotFloor = mock(HotFloor.class);
        when(defaulMonsterRightHotFloor.getPosition()).thenReturn(position);
        when(defaulMonsterRightHotFloor.getType()).thenReturn(2);

        viewer.draw(defaulMonsterRightHotFloor, graphics, 2);
        verify(graphics, times(1)).drawHotFloor(position, 2);
    }

    @Test
    void drawDefaultMonsterLeftHotFloor(){
        HotFloor defaulMonsterLeftHotFloor = mock(HotFloor.class);
        when(defaulMonsterLeftHotFloor.getPosition()).thenReturn(position);
        when(defaulMonsterLeftHotFloor.getType()).thenReturn(3);

        viewer.draw(defaulMonsterLeftHotFloor, graphics, 3);
        verify(graphics, times(1)).drawHotFloor(position, 3);
    }

    @Test
    void drawDefaultMonsterDownHotFloor(){
        HotFloor defaulMonsterDownHotFloor = mock(HotFloor.class);
        when(defaulMonsterDownHotFloor.getPosition()).thenReturn(position);
        when(defaulMonsterDownHotFloor.getType()).thenReturn(4);

        viewer.draw(defaulMonsterDownHotFloor, graphics, 4);
        verify(graphics, times(1)).drawHotFloor(position, 4);
    }
    //-----------------------------------------------------------------------------------------
    @Test
    void drawJumperMonsterUpHotFloor(){
        HotFloor jumperMonsterUpHotFloor = mock(HotFloor.class);
        when(jumperMonsterUpHotFloor.getPosition()).thenReturn(position);
        when(jumperMonsterUpHotFloor.getType()).thenReturn(5);

        viewer.draw(jumperMonsterUpHotFloor, graphics, 5);
        verify(graphics, times(1)).drawHotFloor(position, 5);
    }

    @Test
    void drawJumperMonsterRightHotFloor(){
        HotFloor jumperMonsterRightHotFloor = mock(HotFloor.class);
        when(jumperMonsterRightHotFloor.getPosition()).thenReturn(position);
        when(jumperMonsterRightHotFloor.getType()).thenReturn(6);

        viewer.draw(jumperMonsterRightHotFloor, graphics, 6);
        verify(graphics, times(1)).drawHotFloor(position, 6);
    }

    @Test
    void drawJumperMonsterLeftHotFloor(){
        HotFloor jumperMonsterLeftHotFloor = mock(HotFloor.class);
        when(jumperMonsterLeftHotFloor.getPosition()).thenReturn(position);
        when(jumperMonsterLeftHotFloor.getType()).thenReturn(7);

        viewer.draw(jumperMonsterLeftHotFloor, graphics, 7);
        verify(graphics, times(1)).drawHotFloor(position, 7);
    }

    @Test
    void drawJumperMonsterDownHotFloor(){
        HotFloor jumperMonsterDownHotFloor = mock(HotFloor.class);
        when(jumperMonsterDownHotFloor.getPosition()).thenReturn(position);
        when(jumperMonsterDownHotFloor.getType()).thenReturn(8);

        viewer.draw(jumperMonsterDownHotFloor, graphics, 8);
        verify(graphics, times(1)).drawHotFloor(position, 8);
    }
    //---------------------------------------------------------------------------------------
    @Test
    void drawRunnerMonsterNormalUpHotFloor(){
        HotFloor runnerMonsterNormalUpHotFloor = mock(HotFloor.class);
        when(runnerMonsterNormalUpHotFloor.getPosition()).thenReturn(position);
        when(runnerMonsterNormalUpHotFloor.getType()).thenReturn(9);

        viewer.draw(runnerMonsterNormalUpHotFloor, graphics, 9);
        verify(graphics, times(1)).drawHotFloor(position, 9);
    }

    @Test
    void drawRunnerMonsterNormalRightHotFloor(){
        HotFloor runnerMonsterNormalRightHotFloor = mock(HotFloor.class);
        when(runnerMonsterNormalRightHotFloor.getPosition()).thenReturn(position);
        when(runnerMonsterNormalRightHotFloor.getType()).thenReturn(10);

        viewer.draw(runnerMonsterNormalRightHotFloor, graphics, 10);
        verify(graphics, times(1)).drawHotFloor(position, 10);
    }

    @Test
    void drawRunnerMonsterNormalLeftHotFloor(){
        HotFloor runnerMonsterNormalLeftHotFloor = mock(HotFloor.class);
        when(runnerMonsterNormalLeftHotFloor.getPosition()).thenReturn(position);
        when(runnerMonsterNormalLeftHotFloor.getType()).thenReturn(11);

        viewer.draw(runnerMonsterNormalLeftHotFloor, graphics, 11);
        verify(graphics, times(1)).drawHotFloor(position, 11);
    }

    @Test
    void drawRunnerMonsterNormalDownHotFloor(){
        HotFloor runnerMonsterNormalDownHotFloor = mock(HotFloor.class);
        when(runnerMonsterNormalDownHotFloor.getPosition()).thenReturn(position);
        when(runnerMonsterNormalDownHotFloor.getType()).thenReturn(12);

        viewer.draw(runnerMonsterNormalDownHotFloor, graphics, 12);
        verify(graphics, times(1)).drawHotFloor(position, 12);
    }
    //--------------------------------------------------------------------------------------------

    @Test
    void drawRunnerMonsterRunningUpHotFloor(){
        HotFloor runnerMonsterRunningUpHotFloor = mock(HotFloor.class);
        when(runnerMonsterRunningUpHotFloor.getPosition()).thenReturn(position);
        when(runnerMonsterRunningUpHotFloor.getType()).thenReturn(13);

        viewer.draw(runnerMonsterRunningUpHotFloor, graphics, 13);
        verify(graphics, times(1)).drawHotFloor(position, 13);
    }

    @Test
    void drawRunnerMonsterRunningRightHotFloor(){
        HotFloor runnerMonsterRunningRightHotFloor = mock(HotFloor.class);
        when(runnerMonsterRunningRightHotFloor.getPosition()).thenReturn(position);
        when(runnerMonsterRunningRightHotFloor.getType()).thenReturn(14);

        viewer.draw(runnerMonsterRunningRightHotFloor, graphics, 14);
        verify(graphics, times(1)).drawHotFloor(position, 14);
    }
    @Test
    void drawRunnerMonsterRunningLeftHotFloor(){
        HotFloor runnerMonsterRunningLeftHotFloor = mock(HotFloor.class);
        when(runnerMonsterRunningLeftHotFloor.getPosition()).thenReturn(position);
        when(runnerMonsterRunningLeftHotFloor.getType()).thenReturn(15);

        viewer.draw(runnerMonsterRunningLeftHotFloor, graphics, 15);
        verify(graphics, times(1)).drawHotFloor(position, 15);
    }

    @Test
    void drawRunnerMonsterRunningDownHotFloor(){
        HotFloor runnerMonsterRunningDownHotFloor = mock(HotFloor.class);
        when(runnerMonsterRunningDownHotFloor.getPosition()).thenReturn(position);
        when(runnerMonsterRunningDownHotFloor.getType()).thenReturn(16);

        viewer.draw(runnerMonsterRunningDownHotFloor, graphics, 16);
        verify(graphics, times(1)).drawHotFloor(position, 16);
    }
    //----------------------------------------------------------------------------------
    @Test
    void drawWallBreakerMonsterUpHotFloor(){
        HotFloor wallBreakerMonsterUpHotFloor = mock(HotFloor.class);
        when(wallBreakerMonsterUpHotFloor.getPosition()).thenReturn(position);
        when(wallBreakerMonsterUpHotFloor.getType()).thenReturn(17);

        viewer.draw(wallBreakerMonsterUpHotFloor, graphics, 17);
        verify(graphics, times(1)).drawHotFloor(position, 17);
    }
    @Test
    void drawWallBreakerMonsterRightHotFloor(){
        HotFloor wallBreakerMonsterRightHotFloor = mock(HotFloor.class);
        when(wallBreakerMonsterRightHotFloor.getPosition()).thenReturn(position);
        when(wallBreakerMonsterRightHotFloor.getType()).thenReturn(18);

        viewer.draw(wallBreakerMonsterRightHotFloor, graphics, 18);
        verify(graphics, times(1)).drawHotFloor(position, 18);
    }
    @Test
    void drawWallBreakerMonsterDownHotFloor(){
        HotFloor wallBreakerMonsterDownHotFloor = mock(HotFloor.class);
        when(wallBreakerMonsterDownHotFloor.getPosition()).thenReturn(position);
        when(wallBreakerMonsterDownHotFloor.getType()).thenReturn(19);

        viewer.draw(wallBreakerMonsterDownHotFloor, graphics, 19);
        verify(graphics, times(1)).drawHotFloor(position, 19);
    }
    @Test
    void drawWallBreakerMonsterLeftHotFloor(){
        HotFloor wallBreakerMonsterLeftHotFloor = mock(HotFloor.class);
        when(wallBreakerMonsterLeftHotFloor.getPosition()).thenReturn(position);
        when(wallBreakerMonsterLeftHotFloor.getType()).thenReturn(20);

        viewer.draw(wallBreakerMonsterLeftHotFloor, graphics, 20);
        verify(graphics, times(1)).drawHotFloor(position, 20);
    }
    //-------------------------------------------------------------------------------------------
    @Test
    void drawWAppleHotFloor(){
        HotFloor appleHotFloor = mock(HotFloor.class);
        when(appleHotFloor.getPosition()).thenReturn(position);
        when(appleHotFloor.getType()).thenReturn(21);

        viewer.draw(appleHotFloor, graphics, 21);
        verify(graphics, times(1)).drawHotFloor(position, 21);
    }

    @Test
    void drawBananaHotFloor(){
        HotFloor bananaHotFloor = mock(HotFloor.class);
        when(bananaHotFloor.getPosition()).thenReturn(position);
        when(bananaHotFloor.getType()).thenReturn(22);

        viewer.draw(bananaHotFloor, graphics, 22);
        verify(graphics, times(1)).drawHotFloor(position, 22);
    }
    @Test
    void drawCherryHotFloor(){
        HotFloor cherryHotFloor = mock(HotFloor.class);
        when(cherryHotFloor.getPosition()).thenReturn(position);
        when(cherryHotFloor.getType()).thenReturn(23);

        viewer.draw(cherryHotFloor, graphics, 23);
        verify(graphics, times(1)).drawHotFloor(position, 23);
    }
    @Test
    void drawPineappleHotFloor(){
        HotFloor pineappleHotFloor = mock(HotFloor.class);
        when(pineappleHotFloor.getPosition()).thenReturn(position);
        when(pineappleHotFloor.getType()).thenReturn(23);

        viewer.draw(pineappleHotFloor, graphics, 24);
        verify(graphics, times(1)).drawHotFloor(position, 24);
    }
    @Test
    void drawStrawberryHotFloor(){
        HotFloor strawberryHotFloor = mock(HotFloor.class);
        when(strawberryHotFloor.getPosition()).thenReturn(position);
        when(strawberryHotFloor.getType()).thenReturn(25);

        viewer.draw(strawberryHotFloor, graphics, 25);
        verify(graphics, times(1)).drawHotFloor(position, 25);
    }
    @Test
    void drawIceCreamUpHotFloor(){
        HotFloor iceCreamUpHotFloor = mock(HotFloor.class);
        when(iceCreamUpHotFloor.getPosition()).thenReturn(position);
        when(iceCreamUpHotFloor.getType()).thenReturn(26);

        viewer.draw(iceCreamUpHotFloor, graphics, 26);
        verify(graphics, times(1)).drawHotFloor(position, 26);
    }
    @Test
    void drawIceCreamRightHotFloor(){
        HotFloor iceCreamRightHotFloor = mock(HotFloor.class);
        when(iceCreamRightHotFloor.getPosition()).thenReturn(position);
        when(iceCreamRightHotFloor.getType()).thenReturn(27);

        viewer.draw(iceCreamRightHotFloor, graphics, 27);
        verify(graphics, times(1)).drawHotFloor(position, 27);
    }
    @Test
    void drawIceCreamLeftHotFloor(){
        HotFloor iceCreamLeftHotFloor = mock(HotFloor.class);
        when(iceCreamLeftHotFloor.getPosition()).thenReturn(position);
        when(iceCreamLeftHotFloor.getType()).thenReturn(28);

        viewer.draw(iceCreamLeftHotFloor, graphics, 28);
        verify(graphics, times(1)).drawHotFloor(position, 28);
    }
    @Test
    void drawIceCreamDownHotFloor(){
        HotFloor iceCreamDownHotFloor = mock(HotFloor.class);
        when(iceCreamDownHotFloor.getPosition()).thenReturn(position);
        when(iceCreamDownHotFloor.getType()).thenReturn(29);

        viewer.draw(iceCreamDownHotFloor, graphics, 29);
        verify(graphics, times(1)).drawHotFloor(position, 29);
    }
}
