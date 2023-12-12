package badIceCream.controller.menu;

import badIceCream.GUI.GUI;
import badIceCream.Game;
import badIceCream.model.menu.InstructionsMenuSecondPage;
import badIceCream.states.InstructionsMenuFirstPageState;
import badIceCream.states.MainMenuState;
import badIceCream.states.State;
import badIceCream.utils.Type;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class InstructionsMenuSecondPageControllerTest {
    private InstructionsMenuSecondPageController InstructionsMenuSecondPageController;
    @Mock
    private InstructionsMenuSecondPage instructionsMenuSecondPage;
    @Mock
    private Game game;
    @Mock
    private State state;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        InstructionsMenuSecondPageController = new InstructionsMenuSecondPageController(instructionsMenuSecondPage);
        when(game.getState()).thenReturn(state);
    }


    @Test
    void testCaseLeft() throws IOException {
        InstructionsMenuSecondPageController.step(game, GUI.ACTION.LEFT, System.currentTimeMillis());

        verify(game, times(1)).setState(any(InstructionsMenuFirstPageState.class), any(Type.class), anyInt(), anyInt());
    }

    @Test
    void testCaseSelectExit() throws IOException  {
        InstructionsMenuSecondPageController.step(game, GUI.ACTION.PAUSE, System.currentTimeMillis());

        verify(game, times(1)).setState(any(MainMenuState.class), any(Type.class), anyInt(), anyInt());
    }

}