package badIceCream.states;

import badIceCream.GUI.GUI;
import badIceCream.GUI.Graphics;
import badIceCream.Game;
import badIceCream.controller.menu.SelectLevelMenuController;
import badIceCream.model.menu.SelectLevelMenu;
import badIceCream.viewer.menu.SelectLevelMenuViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class SelectLevelMenuStateTest {
    private SelectLevelMenuState state;
    @Mock
    private SelectLevelMenu model;
    @Mock
    private SelectLevelMenuController controller;
    @Mock
    private SelectLevelMenuViewer viewer;
    @Mock
    private Graphics graphics;
    @Mock
    private Game game;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        int level = 1;

        state = new SelectLevelMenuState(model,controller, viewer, level);
    }

    @Test
    void getModel(){
        SelectLevelMenu test = state.getModel();
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
