package badIceCream.controller.Menu;

import badIceCream.GUI.GUI;
import badIceCream.GUI.GameGraphics;
import badIceCream.Game;
import badIceCream.controller.menu.SelectLevelMenuController;
import badIceCream.model.menu.SelectLevelMenu;
import badIceCream.states.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class SelectLevelMenuControllerTest {
    private SelectLevelMenuController selectLevelMenuController;
    private SelectLevelMenu selectLevelMenu;
    private Game game;

    @BeforeEach
    void setUp() {
        selectLevelMenu = mock(SelectLevelMenu.class);
        State state = mock(State.class);
        game = mock(Game.class);
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
    void testCaseSelectLevel1() throws IOException  {
        when(selectLevelMenu.isSelectedLevel1()).thenReturn(true);
        selectLevelMenuController.step(game, GUI.ACTION.SELECT, System.currentTimeMillis());
        verify(game, times(1)).setAudioController("LevelMusic.wav");
        verify(game, times(1)).setState(any(GameState.class), any(GameGraphics.class));
/*
        when(game.getState().getLevel()).thenReturn(2);
        selectLevelMenuController.step(game, GUI.ACTION.SELECT, System.currentTimeMillis());
        verify(game, times(2)).setAudioController("LevelMusic.wav");
        verify(game, times(2)).setState(any(GameState.class), any(GameGraphics.class));

        when(game.getState().getLevel()).thenReturn(3);
        selectLevelMenuController.step(game, GUI.ACTION.SELECT, System.currentTimeMillis());
        verify(game, times(3)).setAudioController("LevelMusic.wav");
        verify(game, times(3)).setState(any(GameState.class), any(GameGraphics.class));

        when(game.getState().getLevel()).thenReturn(4);
        selectLevelMenuController.step(game, GUI.ACTION.SELECT, System.currentTimeMillis());
        verify(game, times(4)).setAudioController("LevelMusic.wav");
        verify(game, times(4)).setState(any(GameState.class), any(GameGraphics.class));

        when(game.getState().getLevel()).thenReturn(5);
        selectLevelMenuController.step(game, GUI.ACTION.SELECT, System.currentTimeMillis());
        verify(game, times(5)).setAudioController("LevelMusic.wav");
        verify(game, times(5)).setState(any(GameState.class), any(GameGraphics.class)); */
    }

    @Test
    void testCaseSelectLevel2() throws IOException  {
        when(selectLevelMenu.isSelectedLevel2()).thenReturn(true); /*
        when(game.getState().getLevel()).thenReturn(1);
        selectLevelMenuController.step(game, GUI.ACTION.SELECT, System.currentTimeMillis());
        verify(game, never()).setAudioController("LevelMusic.wav");
        verify(game, never()).setState(any(GameState.class), any(GameGraphics.class));
*/
        when(game.getState().getLevel()).thenReturn(2);
        selectLevelMenuController.step(game, GUI.ACTION.SELECT, System.currentTimeMillis());
        verify(game, times(1)).setAudioController("LevelMusic.wav");
        verify(game, times(1)).setState(any(GameState.class), any(GameGraphics.class));
        /*
        when(game.getState().getLevel()).thenReturn(3);
        selectLevelMenuController.step(game, GUI.ACTION.SELECT, System.currentTimeMillis());
        verify(game, times(2)).setAudioController("LevelMusic.wav");
        verify(game, times(2)).setState(any(GameState.class), any(GameGraphics.class));

        when(game.getState().getLevel()).thenReturn(4);
        selectLevelMenuController.step(game, GUI.ACTION.SELECT, System.currentTimeMillis());
        verify(game, times(3)).setAudioController("LevelMusic.wav");
        verify(game, times(3)).setState(any(GameState.class), any(GameGraphics.class));

        when(game.getState().getLevel()).thenReturn(5);
        selectLevelMenuController.step(game, GUI.ACTION.SELECT, System.currentTimeMillis());
        verify(game, times(4)).setAudioController("LevelMusic.wav");
        verify(game, times(4)).setState(any(GameState.class), any(GameGraphics.class));
        */
    }

    @Test
    void testCaseSelectLevel3() throws IOException  {
        when(selectLevelMenu.isSelectedLevel3()).thenReturn(true); /*
        when(game.getState().getLevel()).thenReturn(1);
        selectLevelMenuController.step(game, GUI.ACTION.SELECT, System.currentTimeMillis());
        verify(game, never()).setAudioController("LevelMusic.wav");
        verify(game, never()).setState(any(GameState.class), any(GameGraphics.class));

        when(game.getState().getLevel()).thenReturn(2);
        selectLevelMenuController.step(game, GUI.ACTION.SELECT, System.currentTimeMillis());
        verify(game, never()).setAudioController("LevelMusic.wav");
        verify(game, never()).setState(any(GameState.class), any(GameGraphics.class));
*/
        when(game.getState().getLevel()).thenReturn(3);
        selectLevelMenuController.step(game, GUI.ACTION.SELECT, System.currentTimeMillis());
        verify(game, times(1)).setAudioController("LevelMusic.wav");
        verify(game, times(1)).setState(any(GameState.class), any(GameGraphics.class));
/*
        when(game.getState().getLevel()).thenReturn(4);
        selectLevelMenuController.step(game, GUI.ACTION.SELECT, System.currentTimeMillis());
        verify(game, times(2)).setAudioController("LevelMusic.wav");
        verify(game, times(2)).setState(any(GameState.class), any(GameGraphics.class));

        when(game.getState().getLevel()).thenReturn(5);
        selectLevelMenuController.step(game, GUI.ACTION.SELECT, System.currentTimeMillis());
        verify(game, times(3)).setAudioController("LevelMusic.wav");
        verify(game, times(3)).setState(any(GameState.class), any(GameGraphics.class));*/
    }

    @Test
    void testCaseSelectLevel4() throws IOException  {
        when(selectLevelMenu.isSelectedLevel4()).thenReturn(true); /*
        when(game.getState().getLevel()).thenReturn(1);
        selectLevelMenuController.step(game, GUI.ACTION.SELECT, System.currentTimeMillis());
        verify(game, never()).setAudioController("LevelMusic.wav");
        verify(game, never()).setState(any(GameState.class), any(GameGraphics.class));

        when(game.getState().getLevel()).thenReturn(2);
        selectLevelMenuController.step(game, GUI.ACTION.SELECT, System.currentTimeMillis());
        verify(game, never()).setAudioController("LevelMusic.wav");
        verify(game, never()).setState(any(GameState.class), any(GameGraphics.class));

        when(game.getState().getLevel()).thenReturn(3);
        selectLevelMenuController.step(game, GUI.ACTION.SELECT, System.currentTimeMillis());
        verify(game, never()).setAudioController("LevelMusic.wav");
        verify(game, never()).setState(any(GameState.class), any(GameGraphics.class));
*/
        when(game.getState().getLevel()).thenReturn(4);
        selectLevelMenuController.step(game, GUI.ACTION.SELECT, System.currentTimeMillis());
        verify(game, times(1)).setAudioController("LevelMusic.wav");
        verify(game, times(1)).setState(any(GameState.class), any(GameGraphics.class));
        /*
        when(game.getState().getLevel()).thenReturn(5);
        selectLevelMenuController.step(game, GUI.ACTION.SELECT, System.currentTimeMillis());
        verify(game, times(2)).setAudioController("LevelMusic.wav");
        verify(game, times(2)).setState(any(GameState.class), any(GameGraphics.class)); */
    }

    @Test
    void testCaseSelectLevel5() throws IOException  {
        when(selectLevelMenu.isSelectedLevel5()).thenReturn(true); /*
        when(game.getState().getLevel()).thenReturn(1);
        selectLevelMenuController.step(game, GUI.ACTION.SELECT, System.currentTimeMillis());
        verify(game, never()).setAudioController("LevelMusic.wav");
        verify(game, never()).setState(any(GameState.class), any(GameGraphics.class));

        when(game.getState().getLevel()).thenReturn(2);
        selectLevelMenuController.step(game, GUI.ACTION.SELECT, System.currentTimeMillis());
        verify(game, never()).setAudioController("LevelMusic.wav");
        verify(game, never()).setState(any(GameState.class), any(GameGraphics.class));

        when(game.getState().getLevel()).thenReturn(3);
        selectLevelMenuController.step(game, GUI.ACTION.SELECT, System.currentTimeMillis());
        verify(game, never()).setAudioController("LevelMusic.wav");
        verify(game, never()).setState(any(GameState.class), any(GameGraphics.class));

        when(game.getState().getLevel()).thenReturn(4);
        selectLevelMenuController.step(game, GUI.ACTION.SELECT, System.currentTimeMillis());
        verify(game, never()).setAudioController("LevelMusic.wav");
        verify(game, never()).setState(any(GameState.class), any(GameGraphics.class)); */

        when(game.getState().getLevel()).thenReturn(5);
        selectLevelMenuController.step(game, GUI.ACTION.SELECT, System.currentTimeMillis());
        verify(game, times(1)).setAudioController("LevelMusic.wav");
        verify(game, times(1)).setState(any(GameState.class), any(GameGraphics.class));
    }
}