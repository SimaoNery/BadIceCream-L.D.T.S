package badIceCream.controller.menu;

import badIceCream.GUI.GUI;
import badIceCream.GUI.GameGraphics;
import badIceCream.GUI.Graphics;
import badIceCream.Game;
import badIceCream.model.menu.PauseMenu;
import badIceCream.states.GameState;
import badIceCream.states.MainMenuState;
import badIceCream.states.PauseMenuState;
import badIceCream.states.State;
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
import static org.mockito.Mockito.times;

public class PauseMenuControllerTest {
    private PauseMenuController pauseMenuController;

    @Mock
    private PauseMenu pauseMenu;
    @Mock
    private Game game;
    @Mock
    private State state;
    @Mock
    private Audio audio;
    @Mock
    private Graphics graphics;
    @BeforeEach
    void setUp() throws IOException {
        MockitoAnnotations.openMocks(this);
        when(game.getState()).thenReturn(state);
        pauseMenuController = new PauseMenuController(pauseMenu, state);
        when(pauseMenu.isSelectedMenu()).thenReturn(false);
        when(pauseMenu.isSelectedResume()).thenReturn(false);
        game.setAll(state, graphics, audio);
        when(game.getGraphicsForGame(any(Type.class), anyInt(), anyInt())).thenReturn(null);
    }

    @Test
    void testCaseUp() throws IOException  {
        pauseMenuController.step(game, GUI.ACTION.UP, System.currentTimeMillis());

        verify(pauseMenu, times(1)).previousEntry();
    }

    @Test
    void testCaseDown() throws IOException  {
        pauseMenuController.step(game, GUI.ACTION.DOWN, System.currentTimeMillis());

        verify(pauseMenu, times(1)).nextEntry();
    }


    @Test
    void testCaseSelectMenu() throws IOException {
        when(pauseMenu.isSelectedMenu()).thenReturn(true);
        when(pauseMenu.isSelectedResume()).thenReturn(false);
        pauseMenuController.step(game, GUI.ACTION.SELECT, System.currentTimeMillis());

        verify(game, times(1)).setState(any(MainMenuState.class), any(Type.class), anyInt(), anyInt());
    }

    @Test
    void testCaseSelectResume() throws IOException {
        when(pauseMenu.isSelectedResume()).thenReturn(true);

        pauseMenuController.step(game, GUI.ACTION.SELECT, 0);

        verify(game, times(1)).setAudio(any(Audio.class));
        verify(game, times(1)).setState(state, Type.game, 70, 50);
    }

}
