package badIceCream.controller.menu;

import badIceCream.GUI.GUI;
import badIceCream.GUI.GameGraphics;
import badIceCream.Game;
import badIceCream.controller.menu.SelectLevelMenuController;
import badIceCream.model.menu.SelectLevelMenu;
import badIceCream.states.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class SelectLevelMenuControllerTest {
    private SelectLevelMenuController selectLevelMenuController;
    @Mock
    private SelectLevelMenu selectLevelMenu;
    @Mock
    private State state;
    @Mock
    private Game game;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        when(game.getState()).thenReturn(state);
        selectLevelMenuController = new SelectLevelMenuController(selectLevelMenu);
    }

    @Test
    void testCaseLeft() throws IOException  {
        selectLevelMenuController.step(game, GUI.ACTION.LEFT, System.currentTimeMillis());

        verify(selectLevelMenu, times(1)).previousEntry();
    }

    @Test
    void testCaseRight() throws IOException  {
        selectLevelMenuController.step(game, GUI.ACTION.RIGHT, System.currentTimeMillis());

        verify(selectLevelMenu, times(1)).nextEntry();
    }

    @Test
    void testCaseSelectLevel1WhenIn1() throws IOException  {
        when(selectLevelMenu.isSelectedLevel1()).thenReturn(true);
        selectLevelMenuController.step(game, GUI.ACTION.SELECT, System.currentTimeMillis());
        verify(game, times(1)).setAudioController("LevelMusic.wav");
        verify(game, times(1)).setState(any(GameState.class), any(GameGraphics.class));
    }

    @Test
    void testCaseSelectLevel2WhenIn1() throws IOException  {
        when(selectLevelMenu.isSelectedLevel2()).thenReturn(true);
        selectLevelMenuController.step(game, GUI.ACTION.SELECT, System.currentTimeMillis());
        verify(game, never()).setAudioController("LevelMusic.wav");
        verify(game, never()).setState(any(GameState.class), any(GameGraphics.class));
    }

    @Test
    void testCaseSelectLevel3WhenIn1() throws IOException  {
        when(selectLevelMenu.isSelectedLevel3()).thenReturn(true);
        selectLevelMenuController.step(game, GUI.ACTION.SELECT, System.currentTimeMillis());
        verify(game, never()).setAudioController("LevelMusic.wav");
        verify(game, never()).setState(any(GameState.class), any(GameGraphics.class));
    }

    @Test
    void testCaseSelectLevel4WhenIn1() throws IOException  {
        when(selectLevelMenu.isSelectedLevel4()).thenReturn(true);
        selectLevelMenuController.step(game, GUI.ACTION.SELECT, System.currentTimeMillis());
        verify(game, never()).setAudioController("LevelMusic.wav");
        verify(game, never()).setState(any(GameState.class), any(GameGraphics.class));
    }

    @Test
    void testCaseSelectLevel5WhenIn1() throws IOException  {
        when(selectLevelMenu.isSelectedLevel5()).thenReturn(true);
        selectLevelMenuController.step(game, GUI.ACTION.SELECT, System.currentTimeMillis());
        verify(game, never()).setAudioController("LevelMusic.wav");
        verify(game, never()).setState(any(GameState.class), any(GameGraphics.class));
    }

    @Test
    void testCaseSelectLevel1WhenIn2() throws IOException  {
        when(selectLevelMenu.isSelectedLevel1()).thenReturn(true);
        when(game.getState().getLevel()).thenReturn(2);
        selectLevelMenuController.step(game, GUI.ACTION.SELECT, System.currentTimeMillis());
        verify(game, times(1)).setAudioController("LevelMusic.wav");
        verify(game, times(1)).setState(any(GameState.class), any(GameGraphics.class));
    }

    @Test
    void testCaseSelectLevel2WhenIn2() throws IOException  {
        when(selectLevelMenu.isSelectedLevel2()).thenReturn(true);
        when(game.getState().getLevel()).thenReturn(2);
        selectLevelMenuController.step(game, GUI.ACTION.SELECT, System.currentTimeMillis());
        verify(game, times(1)).setAudioController("LevelMusic.wav");
        verify(game, times(1)).setState(any(GameState.class), any(GameGraphics.class));
    }

    @Test
    void testCaseSelectLevel3WhenIn2() throws IOException  {
        when(selectLevelMenu.isSelectedLevel3()).thenReturn(true);
        when(game.getState().getLevel()).thenReturn(2);
        selectLevelMenuController.step(game, GUI.ACTION.SELECT, System.currentTimeMillis());
        verify(game, never()).setAudioController("LevelMusic.wav");
        verify(game, never()).setState(any(GameState.class), any(GameGraphics.class));
    }

    @Test
    void testCaseSelectLevel4WhenIn2() throws IOException  {
        when(selectLevelMenu.isSelectedLevel4()).thenReturn(true);
        when(game.getState().getLevel()).thenReturn(2);
        selectLevelMenuController.step(game, GUI.ACTION.SELECT, System.currentTimeMillis());
        verify(game, never()).setAudioController("LevelMusic.wav");
        verify(game, never()).setState(any(GameState.class), any(GameGraphics.class));
    }

    @Test
    void testCaseSelectLevel5WhenIn2() throws IOException  {
        when(selectLevelMenu.isSelectedLevel5()).thenReturn(true);
        when(game.getState().getLevel()).thenReturn(2);
        selectLevelMenuController.step(game, GUI.ACTION.SELECT, System.currentTimeMillis());
        verify(game, never()).setAudioController("LevelMusic.wav");
        verify(game, never()).setState(any(GameState.class), any(GameGraphics.class));
    }

    @Test
    void testCaseSelectLevel1WhenIn3() throws IOException  {
        when(selectLevelMenu.isSelectedLevel1()).thenReturn(true);
        when(game.getState().getLevel()).thenReturn(3);
        selectLevelMenuController.step(game, GUI.ACTION.SELECT, System.currentTimeMillis());
        verify(game, times(1)).setAudioController("LevelMusic.wav");
        verify(game, times(1)).setState(any(GameState.class), any(GameGraphics.class));
    }

    @Test
    void testCaseSelectLevel2WhenIn3() throws IOException  {
        when(selectLevelMenu.isSelectedLevel2()).thenReturn(true);
        when(game.getState().getLevel()).thenReturn(3);
        selectLevelMenuController.step(game, GUI.ACTION.SELECT, System.currentTimeMillis());
        verify(game, times(1)).setAudioController("LevelMusic.wav");
        verify(game, times(1)).setState(any(GameState.class), any(GameGraphics.class));
    }

    @Test
    void testCaseSelectLevel3WhenIn3() throws IOException  {
        when(selectLevelMenu.isSelectedLevel3()).thenReturn(true);
        when(game.getState().getLevel()).thenReturn(3);
        selectLevelMenuController.step(game, GUI.ACTION.SELECT, System.currentTimeMillis());
        verify(game, times(1)).setAudioController("LevelMusic.wav");
        verify(game, times(1)).setState(any(GameState.class), any(GameGraphics.class));
    }

    @Test
    void testCaseSelectLevel4WhenIn3() throws IOException  {
        when(selectLevelMenu.isSelectedLevel4()).thenReturn(true);
        when(game.getState().getLevel()).thenReturn(3);
        selectLevelMenuController.step(game, GUI.ACTION.SELECT, System.currentTimeMillis());
        verify(game, never()).setAudioController("LevelMusic.wav");
        verify(game, never()).setState(any(GameState.class), any(GameGraphics.class));
    }

    @Test
    void testCaseSelectLevel5WhenIn3() throws IOException  {
        when(selectLevelMenu.isSelectedLevel5()).thenReturn(true);
        when(game.getState().getLevel()).thenReturn(3);
        selectLevelMenuController.step(game, GUI.ACTION.SELECT, System.currentTimeMillis());
        verify(game, never()).setAudioController("LevelMusic.wav");
        verify(game, never()).setState(any(GameState.class), any(GameGraphics.class));
    }

    @Test
    void testCaseSelectLevel1WhenIn4() throws IOException  {
        when(selectLevelMenu.isSelectedLevel1()).thenReturn(true);
        when(game.getState().getLevel()).thenReturn(4);
        selectLevelMenuController.step(game, GUI.ACTION.SELECT, System.currentTimeMillis());
        verify(game, times(1)).setAudioController("LevelMusic.wav");
        verify(game, times(1)).setState(any(GameState.class), any(GameGraphics.class));
    }

    @Test
    void testCaseSelectLevel2WhenIn4() throws IOException  {
        when(selectLevelMenu.isSelectedLevel2()).thenReturn(true);
        when(game.getState().getLevel()).thenReturn(4);
        selectLevelMenuController.step(game, GUI.ACTION.SELECT, System.currentTimeMillis());
        verify(game, times(1)).setAudioController("LevelMusic.wav");
        verify(game, times(1)).setState(any(GameState.class), any(GameGraphics.class));
    }

    @Test
    void testCaseSelectLevel3WhenIn4() throws IOException  {
        when(selectLevelMenu.isSelectedLevel3()).thenReturn(true);
        when(game.getState().getLevel()).thenReturn(4);
        selectLevelMenuController.step(game, GUI.ACTION.SELECT, System.currentTimeMillis());
        verify(game, times(1)).setAudioController("LevelMusic.wav");
        verify(game, times(1)).setState(any(GameState.class), any(GameGraphics.class));
    }

    @Test
    void testCaseSelectLevel4WhenIn4() throws IOException  {
        when(selectLevelMenu.isSelectedLevel4()).thenReturn(true);
        when(game.getState().getLevel()).thenReturn(4);
        selectLevelMenuController.step(game, GUI.ACTION.SELECT, System.currentTimeMillis());
        verify(game, times(1)).setAudioController("LevelMusic.wav");
        verify(game, times(1)).setState(any(GameState.class), any(GameGraphics.class));
    }

    @Test
    void testCaseSelectLevel5WhenIn4() throws IOException  {
        when(selectLevelMenu.isSelectedLevel5()).thenReturn(true);
        when(game.getState().getLevel()).thenReturn(4);
        selectLevelMenuController.step(game, GUI.ACTION.SELECT, System.currentTimeMillis());
        verify(game, never()).setAudioController("LevelMusic.wav");
        verify(game, never()).setState(any(GameState.class), any(GameGraphics.class));
    }

    @Test
    void testCaseSelectLevel1WhenIn5() throws IOException  {
        when(selectLevelMenu.isSelectedLevel1()).thenReturn(true);
        when(game.getState().getLevel()).thenReturn(5);
        selectLevelMenuController.step(game, GUI.ACTION.SELECT, System.currentTimeMillis());
        verify(game, times(1)).setAudioController("LevelMusic.wav");
        verify(game, times(1)).setState(any(GameState.class), any(GameGraphics.class));
    }

    @Test
    void testCaseSelectLevel2WhenIn5() throws IOException  {
        when(selectLevelMenu.isSelectedLevel2()).thenReturn(true);
        when(game.getState().getLevel()).thenReturn(5);
        selectLevelMenuController.step(game, GUI.ACTION.SELECT, System.currentTimeMillis());
        verify(game, times(1)).setAudioController("LevelMusic.wav");
        verify(game, times(1)).setState(any(GameState.class), any(GameGraphics.class));
    }

    @Test
    void testCaseSelectLevel3WhenIn5() throws IOException  {
        when(selectLevelMenu.isSelectedLevel3()).thenReturn(true);
        when(game.getState().getLevel()).thenReturn(5);
        selectLevelMenuController.step(game, GUI.ACTION.SELECT, System.currentTimeMillis());
        verify(game, times(1)).setAudioController("LevelMusic.wav");
        verify(game, times(1)).setState(any(GameState.class), any(GameGraphics.class));
    }

    @Test
    void testCaseSelectLevel4WhenIn5() throws IOException  {
        when(selectLevelMenu.isSelectedLevel4()).thenReturn(true);
        when(game.getState().getLevel()).thenReturn(5);
        selectLevelMenuController.step(game, GUI.ACTION.SELECT, System.currentTimeMillis());
        verify(game, times(1)).setAudioController("LevelMusic.wav");
        verify(game, times(1)).setState(any(GameState.class), any(GameGraphics.class));
    }

    @Test
    void testCaseSelectLevel5WhenIn5() throws IOException  {
        when(selectLevelMenu.isSelectedLevel5()).thenReturn(true);
        when(game.getState().getLevel()).thenReturn(5);
        selectLevelMenuController.step(game, GUI.ACTION.SELECT, System.currentTimeMillis());
        verify(game, times(1)).setAudioController("LevelMusic.wav");
        verify(game, times(1)).setState(any(GameState.class), any(GameGraphics.class));
    }
}
