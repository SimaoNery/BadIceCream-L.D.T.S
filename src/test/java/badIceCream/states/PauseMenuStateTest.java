package badIceCream.states;

import badIceCream.GUI.GUI;
import badIceCream.GUI.Graphics;
import badIceCream.Game;
import badIceCream.controller.menu.GameOverMenuController;
import badIceCream.controller.menu.PauseMenuController;
import badIceCream.model.menu.GameOverMenu;
import badIceCream.model.menu.PauseMenu;
import badIceCream.viewer.menu.GameOverMenuViewer;
import badIceCream.viewer.menu.PauseMenuViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class PauseMenuStateTest {
    private PauseMenuState state;
    @Mock
    private PauseMenu model;
    @Mock
    private PauseMenuController controller;
    @Mock
    private PauseMenuViewer viewer;
    @Mock
    private Graphics graphics;
    @Mock
    private Game game;
    @Mock
    private State parent;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        int level = 1;

        state = new PauseMenuState(model, parent, controller, viewer, level);
    }

    @Test
    void getModel(){
        PauseMenu test = state.getModel();
        assertEquals(model, test);
    }

    @Test
    void step() throws IOException {
        long time = 1000L;

        when(graphics.getNextAction()).thenReturn(GUI.ACTION.UP);

        state.step(game, graphics, time);


        verify(controller, times(1)).step(game, GUI.ACTION.UP, time);
        verify(viewer, times(1)).draw(graphics);
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