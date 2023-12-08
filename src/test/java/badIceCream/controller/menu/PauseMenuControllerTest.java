package badIceCream.controller.menu;

import badIceCream.GUI.GUI;
import badIceCream.GUI.GameGraphics;
import badIceCream.Game;
import badIceCream.model.menu.PauseMenu;
import badIceCream.states.GameState;
import badIceCream.states.MainMenuState;
import badIceCream.states.State;
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
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        when(game.getState()).thenReturn(state);
        pauseMenuController = new PauseMenuController(pauseMenu, state);
        when(pauseMenu.isSelectedMenu()).thenReturn(false);
        when(pauseMenu.isSelectedResume()).thenReturn(false);
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

        verify(game, times(1)).setState(eq(any(MainMenuState.class)), null);
    }

    @Test
    void testCaseSelectResume() throws IOException {
        when(pauseMenu.isSelectedResume()).thenReturn(true);

        pauseMenuController.step(game, GUI.ACTION.SELECT, 0);

        verify(game, times(1)).setAudioController("LevelMusic.wav");
        verify(game, times(1)).setState(eq(state), any(GameGraphics.class));
    }

}
