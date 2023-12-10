package badIceCream.viewer.menu;

import badIceCream.GUI.Graphics;
import badIceCream.model.Position;
import badIceCream.model.menu.GameOverMenu;
import badIceCream.model.menu.SelectLevelMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class SelectLevelMenuViewerTest {
    @Mock
    private SelectLevelMenu menu;
    @Mock
    private Graphics graphics;

    private SelectLevelMenuViewer viewer;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);

        viewer = new SelectLevelMenuViewer(menu);
    }

    @Test
    void drawTitle(){
        String s0 = "   _                    _    _____      _           _              ";
        String s1 = "  | |                  | |  / ____|    | |         | |             ";
        String s2 = "  | |     _____   _____| | | (___   ___| | ___  ___| |_            ";
        String s3 = "  | |    / _ \\ \\ / / _ \\ |  \\___ \\ / _ \\ |/ _ \\/ __| __|    ";
        String s4 = "  | |___|  __/\\ V /  __/ |  ____) |  __/ |  __/ (__| |_           ";
        String s5 = "  |______\\___| \\_/ \\___|_| |_____/ \\___|_|\\___|\\___|\\__|    ";


        viewer.drawTitle(graphics);

        verify(graphics,times(1)).drawText(new Position(41, 1), s0, "  #f7dc6f  ");
        verify(graphics,times(1)).drawText(new Position(41, 2), s1, "  #f7dc6f  ");
        verify(graphics,times(1)).drawText(new Position(41, 3), s2, "  #f7dc6f  ");
        verify(graphics,times(1)).drawText(new Position(41, 4), s3, "  #f7dc6f  ");
        verify(graphics,times(1)).drawText(new Position(41, 5), s4, "  #f7dc6f  ");
        verify(graphics,times(1)).drawText(new Position(41, 6), s5, "  #f7dc6f  ");
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

        verify(graphics,times(1)).drawText(new Position(65, 33), s0, "  #ffffff  ");
        verify(graphics,times(1)).drawText(new Position(65, 34), s1, "  #ffffff  ");
        verify(graphics,times(1)).drawText(new Position(65, 35), s2, "  #ffffff  ");
        verify(graphics,times(1)).drawText(new Position(65, 36), s3, "  #ffffff  ");
        verify(graphics,times(1)).drawText(new Position(65, 37), s4, "  #ffffff  ");
        verify(graphics,times(1)).drawText(new Position(65, 38), s5, "  #ffffff  ");
        verify(graphics,times(1)).drawText(new Position(65, 39), s6, " #ffffff ");
        verify(graphics,times(1)).drawText(new Position(65, 40), s7, " #ffffff ");

        verify(graphics,times(1)).drawText(new Position(100, 26), s0, "  #ffffff  ");
        verify(graphics,times(1)).drawText(new Position(100, 27), s1, "  #ffffff  ");
        verify(graphics,times(1)).drawText(new Position(100, 28), s2, "  #ffffff  ");
        verify(graphics,times(1)).drawText(new Position(100, 29), s3, "  #ffffff  ");
        verify(graphics,times(1)).drawText(new Position(100, 30), s4, "  #ffffff  ");
        verify(graphics,times(1)).drawText(new Position(100, 31), s5, "  #ffffff  ");
        verify(graphics,times(1)).drawText(new Position(100, 32), s6, " #ffffff ");
        verify(graphics,times(1)).drawText(new Position(100, 33), s7, " #ffffff ");

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
