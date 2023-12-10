package badIceCream.viewer.menu;

import badIceCream.GUI.Graphics;
import badIceCream.model.Position;
import badIceCream.model.menu.GameOverMenu;
import badIceCream.model.menu.PauseMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class PauseMenuViewerTest {
    @Mock
    private PauseMenu menu;
    @Mock
    private Graphics graphics;

    private PauseMenuViewer viewer;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);

        viewer = new PauseMenuViewer(menu);
    }

    @Test
    void drawTitle(){
        String s0 = "  _____                                            ";
        String s1 = " |  __ \\                                          ";
        String s2 = " | |__) |  __ _   _   _   ___    ___              ";
        String s3 = " |  ___/  / _` | | | | | / __|  / _ \\            ";
        String s4 = " | |     | (_| | | |_| | \\__ \\ |  __/           ";
        String s5 = " |_|      \\__,_|  \\__,_| |___/  \\___|          ";


        viewer.drawTitle(graphics);

        verify(graphics,times(1)).drawText(new Position(51, 3), s0, "  #f7dc6f  ");
        verify(graphics,times(1)).drawText(new Position(51, 4), s1, "  #f7dc6f  ");
        verify(graphics,times(1)).drawText(new Position(51, 5), s2, "  #f7dc6f  ");
        verify(graphics,times(1)).drawText(new Position(51, 6), s3, "  #f7dc6f  ");
        verify(graphics,times(1)).drawText(new Position(51, 7), s4, "  #f7dc6f  ");
        verify(graphics,times(1)).drawText(new Position(51, 8), s5, "  #f7dc6f  ");
    }
    @Test
    void drawPauseSymbol(){
        String s1 = " __    _           ";
        String s2 = "|  |  | \\          ";
        String s3 = "|  |  |  \\         ";
        String s4 = "|  |  |   \\         ";
        String s5 = "|  |  |   /         ";
        String s6 = "|  |  |  /          ";
        String s7 = "|__|  |_/             ";

        viewer.drawPauseSymbol(graphics);

        verify(graphics,times(1)).drawText(new Position(66, 10), s1, "  #b05fa3  ");
        verify(graphics,times(1)).drawText(new Position(66, 11), s2, "  #b05fa3  ");
        verify(graphics,times(1)).drawText(new Position(66, 12), s3, "  #b05fa3  ");
        verify(graphics,times(1)).drawText(new Position(66, 13), s4, "  #b05fa3  ");
        verify(graphics,times(1)).drawText(new Position(66, 14), s5, "  #b05fa3  ");
        verify(graphics,times(1)).drawText(new Position(66, 15), s6, "  #b05fa3  ");
        verify(graphics,times(1)).drawText(new Position(66, 16), s7, "  #b05fa3  ");
    }
    @Test
    void drawSnowflake(){
        String s0 = "   ..    ..          ";
        String s1 = "   '\\    /'         ";
        String s2 = "     \\\\//          ";
        String s3 = "_.__\\\\\\///__._    ";
        String s4 = " '  ///\\\\\\  '     ";
        String s5 = "     //\\\\          ";
        String s6 = "   ./    \\.         ";
        String s7 = "   ''    ''          ";

        viewer.drawSnowflake(graphics);

        verify(graphics,times(1)).drawText(new Position(15, 25), s0, "#ffffff");
        verify(graphics,times(1)).drawText(new Position(15, 26), s1, "#ffffff");
        verify(graphics,times(1)).drawText(new Position(15, 27), s2, "#ffffff");
        verify(graphics,times(1)).drawText(new Position(15, 28), s3, "#ffffff");
        verify(graphics,times(1)).drawText(new Position(15, 29), s4, "#ffffff");
        verify(graphics,times(1)).drawText(new Position(15, 30), s5, "#ffffff");
        verify(graphics,times(1)).drawText(new Position(15, 31), s6, "#ffffff");
        verify(graphics,times(1)).drawText(new Position(15, 32), s7, "#ffffff");

        verify(graphics,times(1)).drawText(new Position(5, 1), s0, "  #ffffff  ");
        verify(graphics,times(1)).drawText(new Position(5, 2), s1, "  #ffffff  ");
        verify(graphics,times(1)).drawText(new Position(5, 3), s2, "  #ffffff  ");
        verify(graphics,times(1)).drawText(new Position(5, 4), s3, "  #ffffff  ");
        verify(graphics,times(1)).drawText(new Position(5, 5), s4, "  #ffffff  ");
        verify(graphics,times(1)).drawText(new Position(5, 6), s5, "  #ffffff  ");
        verify(graphics,times(1)).drawText(new Position(5, 7), s6, " #ffffff ");
        verify(graphics,times(1)).drawText(new Position(5, 8), s7, " #ffffff ");

        verify(graphics,times(1)).drawText(new Position(70, 33), s0, "  #ffffff  ");
        verify(graphics,times(1)).drawText(new Position(70, 34), s1, "  #ffffff  ");
        verify(graphics,times(1)).drawText(new Position(70, 35), s2, "  #ffffff  ");
        verify(graphics,times(1)).drawText(new Position(70, 36), s3, "  #ffffff  ");
        verify(graphics,times(1)).drawText(new Position(70, 37), s4, "  #ffffff  ");
        verify(graphics,times(1)).drawText(new Position(70, 38), s5, "  #ffffff  ");
        verify(graphics,times(1)).drawText(new Position(70, 39), s6, " #ffffff ");
        verify(graphics,times(1)).drawText(new Position(70, 40), s7, " #ffffff ");

        verify(graphics,times(1)).drawText(new Position(100, 20), s0, "  #ffffff  ");
        verify(graphics,times(1)).drawText(new Position(100, 21), s1, "  #ffffff  ");
        verify(graphics,times(1)).drawText(new Position(100, 22), s2, "  #ffffff  ");
        verify(graphics,times(1)).drawText(new Position(100, 23), s3, "  #ffffff  ");
        verify(graphics,times(1)).drawText(new Position(100, 24), s4, "  #ffffff  ");
        verify(graphics,times(1)).drawText(new Position(100, 25), s5, "  #ffffff  ");
        verify(graphics,times(1)).drawText(new Position(100, 26), s6, " #ffffff ");
        verify(graphics,times(1)).drawText(new Position(100, 27), s7, " #ffffff ");

        verify(graphics,times(1)).drawText(new Position(120, 7), s0, "  #ffffff  ");
        verify(graphics,times(1)).drawText(new Position(120, 8), s1, "  #ffffff  ");
        verify(graphics,times(1)).drawText(new Position(120, 9), s2, "  #ffffff  ");
        verify(graphics,times(1)).drawText(new Position(120, 10), s3, "  #ffffff  ");
        verify(graphics,times(1)).drawText(new Position(120, 11), s4, "  #ffffff  ");
        verify(graphics,times(1)).drawText(new Position(120, 12), s5, "  #ffffff  ");
        verify(graphics,times(1)).drawText(new Position(120, 13), s6, " #ffffff ");
        verify(graphics,times(1)).drawText(new Position(120, 14), s7, " #ffffff ");
    }

    @Test
    void drawElements(){
    }
}
