package badIceCream.viewer.menu;

import badIceCream.GUI.Graphics;
import badIceCream.model.menu.GameOverMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


public class GameOverMenuViewerTest {
    @Mock
    private GameOverMenu menu;
    @Mock
    private Graphics graphics;

    private GameOverMenuViewer viewer;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);

        viewer = new GameOverMenuViewer(menu);
    }

    @Test
    void drawTitle(){
    }

    @Test
    void drawSnowflake(){
    }

    @Test
    void drawElements(){
    }
}
