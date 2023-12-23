package badIceCream.states;

import badIceCream.GUI.GUI;
import badIceCream.GUI.Graphics;
import badIceCream.Game;
import badIceCream.controller.menu.GameOverMenuController;
import badIceCream.model.menu.GameOverMenu;
import badIceCream.viewer.menu.GameOverMenuViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class GameOverMenuStateTest {
    private GameOverMenuState state;
    @Mock
    private GameOverMenu model;
    @Mock
    private GameOverMenuController controller;
    @Mock
    private GameOverMenuViewer viewer;
    @Mock
    private Graphics graphics;
    @Mock
    private Game game;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        int level = 1;

        state = new GameOverMenuState(model, controller, viewer, level);
    }

    @Test
    void getModel(){
        GameOverMenu test = state.getModel();
        assertEquals(model, test);
    }

    @Test
    void step() throws IOException {
        long time = 1000L;
        when(graphics.getNextAction()).thenReturn(GUI.ACTION.UP);


        state.step(game, graphics, time);

        verify(controller, times(1)).step(eq(game), eq(GUI.ACTION.UP), eq(time));
        verify(viewer, times(1)).draw(eq(graphics));
    }

    @Test
    void stepMonsters() throws IOException {
        long time = 1000L;

        state.stepMonsters(time);

        verify(controller, times(1)).stepMonsters(time);
    }

    @Test
    void getLevel(){
        int expectedLevel = 1;
        int actualLevel = state.getLevel();

        assertEquals(expectedLevel, actualLevel);
    }

    @Test
    void increaseLevel(){
        int initial = state.getLevel();

        state.increaseLevel();

        int increased = state.getLevel();

        assertEquals(initial+1, increased);

        for (int i = state.getLevel(); i < 5; i++) {
            state.increaseLevel();
        }
        state.increaseLevel();
        assertEquals(5, state.getLevel());
    }
}
