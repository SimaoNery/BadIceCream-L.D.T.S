package badIceCream.controller.Menu;

import badIceCream.GUI.GUI;
import badIceCream.Game;
import badIceCream.controller.menu.InstructionsMenuSecondPageController;
import badIceCream.controller.menu.InstructionsMenuSecondPageController;
import badIceCream.model.menu.InstructionsMenuSecondPage;
import badIceCream.model.menu.InstructionsMenuSecondPage;
import badIceCream.states.InstructionsMenuFirstPageState;
import badIceCream.states.InstructionsMenuSecondPageState;
import badIceCream.states.MainMenuState;
import badIceCream.states.State;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class InstructionsMenuSecondPageControllerTest {
    private InstructionsMenuSecondPageController InstructionsMenuSecondPageController;
    private InstructionsMenuSecondPage instructionsMenuSecondPage;
    private Game game;

    @BeforeEach
    void setUp() {
        instructionsMenuSecondPage = mock(InstructionsMenuSecondPage.class);
        InstructionsMenuSecondPageController = new InstructionsMenuSecondPageController(instructionsMenuSecondPage);
        State state = mock(State.class);
        game = mock(Game.class);
        when(game.getState()).thenReturn(state);
    }


    @Test
    void testCaseLeft() throws IOException {
        InstructionsMenuSecondPageController.step(game, GUI.ACTION.LEFT, System.currentTimeMillis());

        verify(game, times(1)).setState(eq(any(InstructionsMenuFirstPageState.class)), null);
    }

    @Test
    void testCaseSelectExit() throws IOException  {
        InstructionsMenuSecondPageController.step(game, GUI.ACTION.PAUSE, System.currentTimeMillis());

        verify(game, times(1)).setState(eq(any(MainMenuState.class)), null);
    }

}