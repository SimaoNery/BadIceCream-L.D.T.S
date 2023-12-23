package badIceCream.states;

import badIceCream.GUI.GUI;
import badIceCream.GUI.Graphics;
import badIceCream.Game;
import badIceCream.controller.game.ArenaController;
import badIceCream.model.game.arena.Arena;
import badIceCream.model.game.elements.IceCream;
import badIceCream.viewer.ArenaViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


public class GameStateTest {
    private GameState state;
    @Mock
    private Game game;
    @Mock
    private Graphics graphics;
    @Mock
    private ArenaController controller;
    @Mock
    private ArenaViewer viewer;
    @Mock
    private Arena arena;
    @Mock
    private IceCream iceCream;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        int level = 1;

        when(arena.getIceCream()).thenReturn(iceCream);

        state = new GameState(arena, controller, viewer, level);
    }

    @Test
    void getModel(){
        Arena test = state.getModel();
        assertEquals(arena, test);
    }

    @Test
    void step() throws IOException {
        when(graphics.getNextAction()).thenReturn(GUI.ACTION.UP);

        state.step(game, graphics, 1000L);

        verify(controller, times(1)).step(game, GUI.ACTION.UP, 1000L);
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
