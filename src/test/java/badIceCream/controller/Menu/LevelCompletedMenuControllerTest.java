package badIceCream.controller.Menu;

import badIceCream.GUI.GUI;
import badIceCream.GUI.GameGraphics;
import badIceCream.Game;
import badIceCream.controller.menu.GameOverMenuController;
import badIceCream.controller.menu.LevelCompletedMenuController;
import badIceCream.model.menu.GameOverMenu;
import badIceCream.model.menu.LevelCompletedMenu;
import badIceCream.states.GameState;
import badIceCream.states.MainMenuState;
import badIceCream.states.State;
import badIceCream.utils.Audio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class LevelCompletedMenuControllerTest {
    private LevelCompletedMenuController levelCompletedMenuController;
    private LevelCompletedMenu levelCompletedMenu;
    private Game game;
    private Audio audio;

    @BeforeEach
    void setUp() {
        levelCompletedMenu = mock(LevelCompletedMenu.class);
        State state = mock(State.class);
        when(state.getLevel()).thenReturn(1);
        game = mock(Game.class);
        audio = mock(Audio.class);
        when(game.getState()).thenReturn(state);
        levelCompletedMenuController = new LevelCompletedMenuController(levelCompletedMenu, audio);
    }

    @Test
    void testCaseUp() throws IOException {
        levelCompletedMenuController.step(game, GUI.ACTION.UP, System.currentTimeMillis());

        verify(levelCompletedMenu, times(1)).previousEntry();
    }

    @Test
    void testCaseDown() throws IOException  {
        levelCompletedMenuController.step(game, GUI.ACTION.DOWN, System.currentTimeMillis());

        verify(levelCompletedMenu, times(1)).nextEntry();
    }

    @Test
    void testCaseSelectQuitToMainMenu() throws IOException  {
        when(levelCompletedMenu.isSelectedQuitToMainMenu()).thenReturn(true);
        levelCompletedMenuController.step(game, GUI.ACTION.SELECT, System.currentTimeMillis());

        verify(audio, times(1)).stop();
        verify(game, times(1)).setAudioController("MainMenuMusic.wav");
        verify(game, times(1)).setState(eq(any(MainMenuState.class)), null);
    }

    @Test
    void testCaseSelectPlayAgain() throws IOException {
        when(levelCompletedMenu.isSelectedNextLevel()).thenReturn(true);

        levelCompletedMenuController.step(game, GUI.ACTION.SELECT, System.currentTimeMillis());
        verify(audio, times(1)).stop();
        verify(game, times(1)).setAudioController("LevelMusic.wav");
        verify(game, times(1)).setState(any(GameState.class), any(GameGraphics.class));
    }
}
