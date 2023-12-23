package badIceCream.viewer.menu;

import badIceCream.GUI.Graphics;
import badIceCream.model.Position;
import badIceCream.model.menu.InstructionsMenuFirstPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class InstructionsMenuFirstPageViewerTest {
    @Mock
    private InstructionsMenuFirstPage menu;
    @Mock
    private Graphics graphics;

    private InstructionsMenuFirstPageViewer viewer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        viewer = new InstructionsMenuFirstPageViewer(menu);
    }

    @Test
    void drawTitle() {
        String s0 = "           _____           _                   _   _                       ";
        String s1 = "          |_   _|         | |                 | | (_)                      ";
        String s2 = "            | |  _ __  ___| |_ _ __ _   _  ___| |_ _  ___  _ __  ___       ";
        String s3 = "            | | | '_ \\/ __| __| '__| | | |/ __| __| |/ _ \\| '_ \\/ __|      ";
        String s4 = "           _| |_| | | \\__ \\ |_| |  | |_| | (__| |_| | (_) | | | \\__ \";    ";
        String s5 = "          |_____|_| |_|___/\\__|_|   \\__,_|\\___|\\__|_|\\___/|_| |_|___/      ";


        viewer.drawTitle(graphics);

        verify(graphics, times(1)).drawText(new Position(35, 1), s0, "  #f7dc6f  ");
        verify(graphics, times(1)).drawText(new Position(35, 2), s1, "  #f7dc6f  ");
        verify(graphics, times(1)).drawText(new Position(35, 3), s2, "  #f7dc6f  ");
        verify(graphics, times(1)).drawText(new Position(35, 4), s3, "  #f7dc6f  ");
        verify(graphics, times(1)).drawText(new Position(35, 5), s4, "  #f7dc6f  ");
        verify(graphics, times(1)).drawText(new Position(35, 6), s5, "  #f7dc6f  ");
    }

    @Test
    void drawSnowflake() {
        String s0 = "   ..    ..          ";
        String s1 = "   '\\    /'         ";
        String s2 = "     \\\\//          ";
        String s3 = "_.__\\\\\\///__._    ";
        String s4 = " '  ///\\\\\\  '     ";
        String s5 = "     //\\\\          ";
        String s6 = "   ./    \\.         ";
        String s7 = "   ''    ''          ";

        viewer.drawSnowflake(graphics);

        verify(graphics, times(1)).drawText(new Position(15, 25), s0, "#ffffff");
        verify(graphics, times(1)).drawText(new Position(15, 26), s1, "#ffffff");
        verify(graphics, times(1)).drawText(new Position(15, 27), s2, "#ffffff");
        verify(graphics, times(1)).drawText(new Position(15, 28), s3, "#ffffff");
        verify(graphics, times(1)).drawText(new Position(15, 29), s4, "#ffffff");
        verify(graphics, times(1)).drawText(new Position(15, 30), s5, "#ffffff");
        verify(graphics, times(1)).drawText(new Position(15, 31), s6, "#ffffff");
        verify(graphics, times(1)).drawText(new Position(15, 32), s7, "#ffffff");

        verify(graphics, times(1)).drawText(new Position(5, 1), s0, "  #ffffff  ");
        verify(graphics, times(1)).drawText(new Position(5, 2), s1, "  #ffffff  ");
        verify(graphics, times(1)).drawText(new Position(5, 3), s2, "  #ffffff  ");
        verify(graphics, times(1)).drawText(new Position(5, 4), s3, "  #ffffff  ");
        verify(graphics, times(1)).drawText(new Position(5, 5), s4, "  #ffffff  ");
        verify(graphics, times(1)).drawText(new Position(5, 6), s5, "  #ffffff  ");
        verify(graphics, times(1)).drawText(new Position(5, 7), s6, " #ffffff ");
        verify(graphics, times(1)).drawText(new Position(5, 8), s7, " #ffffff ");

        verify(graphics, times(1)).drawText(new Position(120, 7), s0, "  #ffffff  ");
        verify(graphics, times(1)).drawText(new Position(120, 8), s1, "  #ffffff  ");
        verify(graphics, times(1)).drawText(new Position(120, 9), s2, "  #ffffff  ");
        verify(graphics, times(1)).drawText(new Position(120, 10), s3, "  #ffffff  ");
        verify(graphics, times(1)).drawText(new Position(120, 11), s4, "  #ffffff  ");
        verify(graphics, times(1)).drawText(new Position(120, 12), s5, "  #ffffff  ");
        verify(graphics, times(1)).drawText(new Position(120, 13), s6, " #ffffff ");
        verify(graphics, times(1)).drawText(new Position(120, 14), s7, " #ffffff ");
    }

    @Test
    void drawElements() {

        viewer.drawElements(graphics);

        verify(graphics, times(1)).drawText(new Position(33, 15), "The goal of the game is to collect all fruits without being caught by the monsters", "#f76fe0");
        verify(graphics, times(1)).drawText(new Position(40, 20), "Movements", "#FFFFFF");
        verify(graphics, times(1)).drawText(new Position(40, 25), "Build/Break Ice", "#FFFFFF");
        verify(graphics, times(1)).drawText(new Position(40, 30), "Pause", "#FFFFFF");

        verify(graphics, times(1)).drawText(new Position(91, 17), "       ___          ", "#FFFFFF");
        verify(graphics, times(1)).drawText(new Position(91, 18), "      | ^ |         ", "#FFFFFF");
        verify(graphics, times(1)).drawText(new Position(91, 19), "      |_|_|         ", "#FFFFFF");
        verify(graphics, times(1)).drawText(new Position(91, 20), "  ___  ___  ___     ", "#FFFFFF");
        verify(graphics, times(1)).drawText(new Position(91, 21), " | <-|| | ||-> |    ", "#FFFFFF");
        verify(graphics, times(1)).drawText(new Position(91, 22), " |___||_v_||___|    ", "#FFFFFF");

        verify(graphics, times(1)).drawText(new Position(90, 24), " _________________ ", "#FFFFFF");
        verify(graphics, times(1)).drawText(new Position(90, 25), "|      SPACE      |", "#FFFFFF");
        verify(graphics, times(1)).drawText(new Position(90, 26), "|_________________|", "#FFFFFF");


        verify(graphics, times(1)).drawText(new Position(96, 29), " _____", "#FFFFFF");
        verify(graphics, times(1)).drawText(new Position(96, 30), "| ESC |", "#FFFFFF");
        verify(graphics, times(1)).drawText(new Position(96, 31), "|_____|", "#FFFFFF");

        verify(graphics, times(1)).drawText(new Position(110, 40), "Next Page", "#FFFFFF");
        verify(graphics, times(1)).drawText(new Position(120, 39), " ___", "#FFFFFF");
        verify(graphics, times(1)).drawText(new Position(120, 40), "| ->|", "#FFFFFF");
        verify(graphics, times(1)).drawText(new Position(120, 41), "|___|", "#FFFFFF");

        verify(graphics, times(1)).drawText(new Position(36, 40), "Main Menu", "#FFFFFF");
        verify(graphics, times(1)).drawText(new Position(30, 39), " ___", "#FFFFFF");
        verify(graphics, times(1)).drawText(new Position(30, 40), "|ESC|", "#FFFFFF");
        verify(graphics, times(1)).drawText(new Position(30, 41), "|___| ", "#FFFFFF");
    }
}
