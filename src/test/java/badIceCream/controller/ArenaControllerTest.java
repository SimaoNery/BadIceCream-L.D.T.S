package badIceCream.controller;

import badIceCream.GUI.GUI;
import badIceCream.GUI.MenuGraphics;
import badIceCream.Game;
import badIceCream.controller.game.ArenaController;
import badIceCream.controller.game.IceCreamController;
import badIceCream.controller.game.MonsterController;
import badIceCream.model.Position;
import badIceCream.model.game.arena.Arena;
import badIceCream.model.game.elements.IceCream;
import badIceCream.model.game.elements.fruits.BananaFruit;
import badIceCream.model.game.elements.fruits.Fruit;
import badIceCream.model.game.elements.monsters.*;
import badIceCream.states.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

class ArenaControllerTest {

    private ArenaController arenaController;
    private Game game;
    private IceCreamController iceCreamController;
    private List<MonsterController> monsterControllers;
    private IceCream iceCream;

    private State state;
    private Arena arena;

    @BeforeEach
    void setUp() {
        state = mock(State.class);
        game = Mockito.mock(Game.class);
        when(game.getState()).thenReturn(state);

        Position position = mock(Position.class);
        iceCream = mock(IceCream.class);
        when(iceCream.getPosition()).thenReturn(position);

        arena = Mockito.mock(Arena.class);
        when(arena.getIceCream()).thenReturn(iceCream);
        iceCreamController = Mockito.mock(IceCreamController.class);

        MonsterController monsterController1 = mock(MonsterController.class);
        MonsterController monsterController2 = mock(MonsterController.class);

        monsterControllers = new ArrayList<>(Arrays.asList(monsterController1, monsterController2));


        when(arena.getFruits()).thenReturn(Arrays.asList(
                mock(Fruit.class),
                mock(Fruit.class)
        ));

        arenaController = new ArenaController(arena, iceCreamController, monsterControllers);
    }

    @Test
    void stepTestWin() throws IOException {

        when(arena.getFruits()).thenReturn(Collections.emptyList());

        Field firstField = null;
        try {
            firstField = ArenaController.class.getDeclaredField("first");
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        firstField.setAccessible(true);
        try {
            firstField.set(arenaController, false);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        arenaController.step(game, GUI.ACTION.UP, System.currentTimeMillis());
        arenaController.step(game, GUI.ACTION.DOWN, System.currentTimeMillis());
        arenaController.step(game, GUI.ACTION.LEFT, System.currentTimeMillis());
        arenaController.step(game, GUI.ACTION.RIGHT, System.currentTimeMillis());

        verify(game, times(4)).stopAudio();
        verify(state, times(4)).increaseLevel();
        verify(game, times(4)).setState(any(LevelCompletedMenuState.class), any(MenuGraphics.class));
    }

    @Test
    void stepTestNewFruits() throws IOException {
        when(arena.getFruits()).thenReturn(Collections.emptyList());
        arenaController.step(game, GUI.ACTION.UP, System.currentTimeMillis());
        verify(arena, times(1)).generateNewFruits(anyInt());
    }

    @Test
    void stepTestEscape() throws IOException {

        when(iceCream.getAlive()).thenReturn(true);
        arenaController.step(game, GUI.ACTION.PAUSE, System.currentTimeMillis());

        verify(game, times(1)).setAudioController("MainMenuMusic.wav");
        verify(game, times(1)).setState(any(PauseMenuState.class), any(MenuGraphics.class));
    }

    @Test
    void stepTestGameOver() throws IOException {
        when(iceCream.getAlive()).thenReturn(false);

        arenaController.step(game, GUI.ACTION.UP, System.currentTimeMillis());
        arenaController.step(game, GUI.ACTION.DOWN, System.currentTimeMillis());
        arenaController.step(game, GUI.ACTION.LEFT, System.currentTimeMillis());
        arenaController.step(game, GUI.ACTION.RIGHT, System.currentTimeMillis());

        verify(game, times(4)).stopAudio();
        verify(game, times(4)).setState(
                any(GameOverMenuState.class),
                any(MenuGraphics.class)
        );
    }

    @Test
    void testStrawberryExpiration() throws IOException {

        when(iceCream.getAlive()).thenReturn(true);
        when(iceCreamController.eatFruit()).thenReturn(-1);
        when(iceCream.isStrawberryActive()).thenReturn(true);
        long currentTime = System.currentTimeMillis();

        arenaController.step(game, GUI.ACTION.UP, currentTime);
        arenaController.step(game, GUI.ACTION.DOWN, currentTime);
        arenaController.step(game, GUI.ACTION.RIGHT, currentTime);
        arenaController.step(game, GUI.ACTION.LEFT, currentTime);


        verify(iceCream, times(4)).setStrawberry(false);

    }

    @Test
    void testStepEatFruit() throws IOException {

        when(iceCreamController.eatFruit()).thenReturn(5);

        arenaController.step(game, GUI.ACTION.UP, System.currentTimeMillis());
        arenaController.step(game, GUI.ACTION.DOWN, System.currentTimeMillis());
        arenaController.step(game, GUI.ACTION.LEFT, System.currentTimeMillis());
        arenaController.step(game, GUI.ACTION.RIGHT, System.currentTimeMillis());

        verify(iceCream, times(4)).setStrawberry(true);

    }

    @Test
    void testStepDontEatStrawberry() throws IOException {


        when(iceCreamController.eatFruit()).thenReturn(1,2,3,4);

        arenaController.step(game, GUI.ACTION.UP, System.currentTimeMillis());
        arenaController.step(game, GUI.ACTION.DOWN, System.currentTimeMillis());
        arenaController.step(game, GUI.ACTION.LEFT, System.currentTimeMillis());
        arenaController.step(game, GUI.ACTION.RIGHT, System.currentTimeMillis());

        verify(iceCream, never()).setStrawberry(true);

    }

    @Test
    void testStepIceCream() throws IOException {
        when(iceCream.getAlive()).thenReturn(true);

        long step = System.currentTimeMillis();
        arenaController.step(game, GUI.ACTION.UP, step);
        verify(iceCreamController, times(1)).step(game, GUI.ACTION.UP, step);
        arenaController.step(game, GUI.ACTION.DOWN, step);
        verify(iceCreamController, times(1)).step(game, GUI.ACTION.DOWN, step);
        arenaController.step(game, GUI.ACTION.LEFT, step);
        verify(iceCreamController, times(1)).step(game, GUI.ACTION.LEFT, step);
        arenaController.step(game, GUI.ACTION.RIGHT, step);
        verify(iceCreamController, times(1)).step(game, GUI.ACTION.RIGHT, step);
    }

    @Test
    void testStepMonster() throws IOException {
        long currentTime = System.currentTimeMillis();
        arenaController.stepMonsters(currentTime);

        verify(monsterControllers.get(0)).step(currentTime);
        verify(monsterControllers.get(1)).step(currentTime);
    }

}
