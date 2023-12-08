package badIceCream.controller.menu;

import badIceCream.GUI.GUI;
import badIceCream.Game;
import badIceCream.controller.menu.MainMenuController;
import badIceCream.model.menu.InstructionsMenuFirstPage;
import badIceCream.model.menu.MainMenu;
import badIceCream.states.InstructionsMenuFirstPageState;
import badIceCream.states.MainMenuState;
import badIceCream.states.SelectLevelMenuState;
import badIceCream.states.State;
import badIceCream.utils.Type;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class MainMenuControllerTest {
    private MainMenuController mainMenuController;
    @Mock
    private MainMenu mainMenu;
    @Mock
    private State state;
    @Mock
    private Game game;

    @BeforeEach
    void setUp() throws IOException {
        MockitoAnnotations.openMocks(this);
        when(game.getState()).thenReturn(state);
        mainMenuController = new MainMenuController(mainMenu);
        when(game.getGraphicsForGame(any(Type.class), anyInt(), anyInt())).thenReturn(null);
    }

    @Test
    void testCaseUp() throws IOException  {
        mainMenuController.step(game, GUI.ACTION.UP, System.currentTimeMillis());

        verify(mainMenu, times(1)).previousEntry();
    }

    @Test
    void testCaseDown() throws IOException  {
        mainMenuController.step(game, GUI.ACTION.DOWN, System.currentTimeMillis());

        verify(mainMenu, times(1)).nextEntry();
    }

    @Test
    void testCaseSelectExit() throws IOException  {
        when(mainMenu.isSelectedExit()).thenReturn(true);
        mainMenuController.step(game, GUI.ACTION.SELECT, System.currentTimeMillis());

        verify(game, times(1)).stopAudio();
        verify(game, times(1)).setState(null, Type.nulo, 0 ,0);
    }

    @Test
    void testCaseSelectInstructions() throws IOException, InstantiationException, IllegalAccessException {
        when(mainMenu.isSelectedInstructions()).thenReturn(true);
        when(game.getState().getLevel()).thenReturn(1);

        mainMenuController.step(game, GUI.ACTION.SELECT, System.currentTimeMillis());

        verify(game, times(1)).setState(any(InstructionsMenuFirstPageState.class), any(Type.class), anyInt(), anyInt());
    }

    @Test
    void testCaseSelectStart() throws IOException, InstantiationException, IllegalAccessException {
        when(mainMenu.isSelectedStart()).thenReturn(true);
        when(game.getState().getLevel()).thenReturn(1);

        mainMenuController.step(game, GUI.ACTION.SELECT, System.currentTimeMillis());


        verify(game, times(1)).setState(any(SelectLevelMenuState.class), any(Type.class), anyInt(), anyInt());
    }

}