package badIceCream.controller;

import badIceCream.GUI.GUI;
import badIceCream.Game;
import badIceCream.controller.menu.InstructionsMenuController;
import badIceCream.model.menu.InstructionsMenu;
import badIceCream.states.MainMenuState;
import badIceCream.states.State;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class InstructionsMenuControllerTest {
    private InstructionsMenuController instructionsMenuController;
    private InstructionsMenu instructionsMenu;

    private Game game;

    @BeforeEach
    void setUp() {
        instructionsMenu = mock(InstructionsMenu.class);
        instructionsMenuController = new InstructionsMenuController(instructionsMenu);
        State state = mock(State.class);
        game = mock(Game.class);
        when(game.getState()).thenReturn(state);
    }

    /*
    @Test
    void testCaseLeft() throws IOException  {
        instructionsMenuController.step(game, GUI.ACTION.RIGHT, System.currentTimeMillis());

        verify(game, times(1)).setState(eq(any(InstructionsMenuSecondPageState.class)), null);
    }*/

    @Test
    void testCaseSelectExit() throws IOException  {
        instructionsMenuController.step(game, GUI.ACTION.SELECT, System.currentTimeMillis());

        verify(game, times(1)).setState(eq(any(MainMenuState.class)), null);
    }

}
