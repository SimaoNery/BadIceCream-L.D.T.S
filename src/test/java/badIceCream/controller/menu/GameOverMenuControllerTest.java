package badIceCream.controller.menu;

import badIceCream.GUI.GUI;

import badIceCream.GUI.GameGraphics;
import badIceCream.Game;
import badIceCream.controller.menu.GameOverMenuController;
import badIceCream.model.menu.GameOverMenu;
import badIceCream.states.*;
import badIceCream.utils.Audio;
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

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        when(game.getState()).thenReturn(state);
        gameOverMenuController = new GameOverMenuController(gameOverMenu, audio);
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

        verify(audio, times(1)).stop();
        verify(game, times(1)).setAudioController("MainMenuMusic.wav");
        verify(game, times(1)).setState(eq(any(MainMenuState.class)), null);
    }

    @Test
    void testCaseSelectPlayAgain() throws IOException {
        when(game.getState().getLevel()).thenReturn(1);
        when(gameOverMenu.isSelectedQuitToMainMenu()).thenReturn(false);
        when(gameOverMenu.isSelectedPlayAgain()).thenReturn(true);

        gameOverMenuController.step(game, GUI.ACTION.SELECT, System.currentTimeMillis());
        verify(audio, times(1)).stop();
        verify(game, times(1)).setAudioController("LevelMusic.wav");
        verify(game, times(1)).setState(any(GameState.class), any(GameGraphics.class));
    }
}
