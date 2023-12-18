package badIceCream.controller.menu;

import badIceCream.GUI.GUI;
import badIceCream.GUI.Graphics;
import badIceCream.Game;
import badIceCream.model.menu.LevelCompletedMenu;
import badIceCream.states.GameState;
import badIceCream.states.MainMenuState;
import badIceCream.states.State;
import badIceCream.utils.Audio;
import badIceCream.utils.Type;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class LevelCompletedMenuControllerTest {
    private LevelCompletedMenuController levelCompletedMenuController;
    @Mock
    private LevelCompletedMenu levelCompletedMenu;
    @Mock
    private Game game;
    @Mock
    private State state;

    @Mock
    private Graphics graphics;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        when(state.getLevel()).thenReturn(1);
        when(game.getState()).thenReturn(state);
        levelCompletedMenuController = new LevelCompletedMenuController(levelCompletedMenu);
        when(levelCompletedMenu.isSelectedQuitToMainMenu()).thenReturn(false);
        when(levelCompletedMenu.isSelectedNextLevel()).thenReturn(false);
        game.setAll(state, graphics);
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

        
        verify(game, times(1)).setState(any(MainMenuState.class), any(Type.class), anyInt(), anyInt());
    }

    @Test
    void testCaseSelectPlayAgain() throws IOException {
        when(levelCompletedMenu.isSelectedNextLevel()).thenReturn(true);

        levelCompletedMenuController.step(game, GUI.ACTION.SELECT, System.currentTimeMillis());
        
        verify(game, times(1)).setState(any(GameState.class), any(Type.class), anyInt(), anyInt());
    }
}
