package badIceCream.controller.menu;

import badIceCream.GUI.GUI;

import badIceCream.GUI.GameGraphics;
import badIceCream.GUI.Graphics;
import badIceCream.Game;
import badIceCream.model.menu.GameOverMenu;
import badIceCream.states.*;
import badIceCream.utils.Audio;
import badIceCream.utils.Type;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.io.IOException;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class GameOverMenuControllerTest {
    private GameOverMenuController gameOverMenuController;
    @Mock
    private GameOverMenu gameOverMenu;
    @Mock
    private Game game;
    @Mock
    private State state;
    @Mock
    private Audio audio;
    @Mock
    private Graphics graphics;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        when(game.getState()).thenReturn(state);
        gameOverMenuController = new GameOverMenuController(gameOverMenu);
        game.setAll(state, graphics, audio);
    }

    @Test
    void testCaseUp() throws IOException {
        gameOverMenuController.step(game, GUI.ACTION.UP, System.currentTimeMillis());

        verify(gameOverMenu, times(1)).previousEntry();
    }

    @Test
    void testCaseDown() throws IOException  {
        gameOverMenuController.step(game, GUI.ACTION.DOWN, System.currentTimeMillis());

        verify(gameOverMenu, times(1)).nextEntry();
    }

    @Test
    void testCaseSelectQuitToMainMenu() throws IOException  {
        when(gameOverMenu.isSelectedQuitToMainMenu()).thenReturn(true);
        gameOverMenuController.step(game, GUI.ACTION.SELECT, System.currentTimeMillis());

        verify(game, times(1)).setAudio(any(Audio.class));
        verify(game, times(1)).setState(any(MainMenuState.class), any(Type.class), anyInt(), anyInt());
    }

    @Test
    void testCaseSelectPlayAgain() throws IOException {
        when(game.getState().getLevel()).thenReturn(1);
        when(gameOverMenu.isSelectedQuitToMainMenu()).thenReturn(false);
        when(gameOverMenu.isSelectedPlayAgain()).thenReturn(true);

        gameOverMenuController.step(game, GUI.ACTION.SELECT, System.currentTimeMillis());
        verify(game, times(1)).setAudio(any(Audio.class));
        verify(game, times(1)).setState(any(GameState.class), any(Type.class), anyInt(), anyInt());
    }
}
