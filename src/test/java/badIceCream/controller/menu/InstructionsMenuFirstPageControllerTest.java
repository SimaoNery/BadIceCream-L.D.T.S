package badIceCream.controller.menu;

import badIceCream.GUI.GUI;
import badIceCream.Game;
import badIceCream.model.menu.InstructionsMenuFirstPage;
import badIceCream.states.InstructionsMenuSecondPageState;
import badIceCream.states.MainMenuState;
import badIceCream.states.State;
import badIceCream.utils.Type;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class InstructionsMenuFirstPageControllerTest {
    private InstructionsMenuFirstPageController InstructionsMenuFirstPageController;

    private Game game;

    @BeforeEach
    void setUp() {
        InstructionsMenuFirstPage instructionsMenuFirstPage = mock(InstructionsMenuFirstPage.class);
        InstructionsMenuFirstPageController = new InstructionsMenuFirstPageController(instructionsMenuFirstPage);
        State state = mock(State.class);
        game = mock(Game.class);
        when(game.getState()).thenReturn(state);
    }


    @Test
    void testCaseLeft() throws IOException  {
        InstructionsMenuFirstPageController.step(game, GUI.ACTION.RIGHT, System.currentTimeMillis());

        verify(game, times(1)).setState(any(InstructionsMenuSecondPageState.class), any(Type.class), anyInt(), anyInt());
    }

    @Test
    void testCaseSelectExit() throws IOException  {
        InstructionsMenuFirstPageController.step(game, GUI.ACTION.PAUSE, System.currentTimeMillis());

        verify(game, times(1)).setState(any(MainMenuState.class), any(Type.class), anyInt(), anyInt());
    }

}
