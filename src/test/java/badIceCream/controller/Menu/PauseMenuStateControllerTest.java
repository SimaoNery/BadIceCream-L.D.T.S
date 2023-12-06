package badIceCream.controller.Menu;

import badIceCream.GUI.GUI;
import badIceCream.GUI.GameGraphics;
import badIceCream.Game;
import badIceCream.controller.menu.PauseMenuController;
import badIceCream.model.menu.PauseMenu;
import badIceCream.states.MainMenuState;
import badIceCream.states.State;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class PauseMenuStateControllerTest {
    private PauseMenuController pauseMenuController;
    private PauseMenu pauseMenu;

    private State state;
    private Game game;

    @BeforeEach
    void setUp() {
        pauseMenu = mock(PauseMenu.class);
        state = mock(State.class);
        game = mock(Game.class);
        when(game.getState()).thenReturn(state);
        pauseMenuController = new PauseMenuController(pauseMenu, state);
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
        pauseMenuController.step(game, GUI.ACTION.SELECT, System.currentTimeMillis());

        verify(game, times(1)).setState(eq(any(MainMenuState.class)), null);
    }

    @Test
    void testCaseSelectResume() throws IOException {
        when(pauseMenu.isSelectedResume()).thenReturn(true);
        pauseMenuController.step(game, GUI.ACTION.SELECT, System.currentTimeMillis());

        verify(game, times(1)).setAudioController("LevelMusic.wav");
        verify(game, times(1)).setState(eq(state), any(GameGraphics.class));
    }

}
