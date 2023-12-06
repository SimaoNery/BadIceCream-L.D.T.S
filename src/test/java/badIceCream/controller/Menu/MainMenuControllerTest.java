package badIceCream.controller.Menu;

import badIceCream.GUI.GUI;
import badIceCream.Game;
import badIceCream.controller.menu.MainMenuController;
import badIceCream.model.menu.InstructionsMenuFirstPage;
import badIceCream.model.menu.MainMenu;
import badIceCream.states.InstructionsMenuFirstPageState;
import badIceCream.states.SelectLevelMenuState;
import badIceCream.states.State;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class MainMenuControllerTest {
    private MainMenuController mainMenuController;
    private MainMenu mainMenu;
    private Game game;

    @BeforeEach
    void setUp() {
        mainMenu = mock(MainMenu.class);
        State state = mock(State.class);
        game = mock(Game.class);
        when(game.getState()).thenReturn(state);
        mainMenuController = new MainMenuController(mainMenu);
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
        verify(game, times(1)).setState(null, null);
    }

    @Test
    void testCaseSelectInstructions() throws IOException, InstantiationException, IllegalAccessException {
        when(mainMenu.isSelectedInstructions()).thenReturn(true);
        when(game.getState().getLevel()).thenReturn(1);

        mainMenuController.step(game, GUI.ACTION.SELECT, System.currentTimeMillis());

        InstructionsMenuFirstPage instructionsMenu = mock(InstructionsMenuFirstPage.class);

        verify(game, times(1)).setState(eq(any(InstructionsMenuFirstPageState.class)), null);
    }

    @Test
    void testCaseSelectStart() throws IOException, InstantiationException, IllegalAccessException {
        when(mainMenu.isSelectedStart()).thenReturn(true);
        when(game.getState().getLevel()).thenReturn(1);

        mainMenuController.step(game, GUI.ACTION.SELECT, System.currentTimeMillis());

        InstructionsMenuFirstPage instructionsMenu = mock(InstructionsMenuFirstPage.class);

        verify(game, times(1)).setState(eq(any(SelectLevelMenuState.class)), null);
    }

}
