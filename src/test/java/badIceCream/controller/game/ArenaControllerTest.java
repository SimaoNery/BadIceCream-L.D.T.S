package badIceCream.controller.game;

import badIceCream.GUI.GUI;
import badIceCream.GUI.Graphics;
import badIceCream.Game;
import badIceCream.model.Position;
import badIceCream.model.game.arena.Arena;
import badIceCream.model.game.elements.IceCream;
import badIceCream.model.game.elements.fruits.Fruit;
import badIceCream.states.GameOverMenuState;
import badIceCream.states.GameState;
import badIceCream.states.LevelCompletedMenuState;
import badIceCream.states.PauseMenuState;
import badIceCream.utils.Type;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

class ArenaControllerTest {
    private ArenaController arenaController;
    @Mock
    private Game game;
    @Mock
    private IceCreamController iceCreamController;
    @Mock
    private List<MonsterController> monsterControllers;
    @Mock
    private MonsterController monsterController1, monsterController2;
    @Mock
    private IceCream iceCream;
    @Mock
    private GameState state;
    @Mock
    private Arena arena;
    @Mock
    private Position position;
    @Mock
    private Graphics graphics;

    @BeforeEach
    void setUp() throws IOException {
        MockitoAnnotations.openMocks(this);
        when(game.getState()).thenReturn(state);
        when(iceCream.getPosition()).thenReturn(position);
        when(iceCream.isStrawberryActive()).thenReturn(false);
        when(arena.getIceCream()).thenReturn(iceCream);


        monsterControllers = new ArrayList<>(Arrays.asList(monsterController1, monsterController2));

        arenaController = new ArenaController(arena, iceCreamController, monsterControllers);
        when(game.getGraphicsForGame(any(Type.class), anyInt(), anyInt())).thenReturn(graphics);
    }
    @Test
    void stepTestWinUp() throws IOException {
        when(arena.getFruits()).thenReturn(Collections.emptyList());

        Field firstField;
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
        verify(state, times(1)).increaseLevel();
        verify(game, times(1)).setState(any(LevelCompletedMenuState.class), any(Type.class), anyInt(), anyInt());
    }

    @Test
    void stepTestWinDown() throws IOException {
        when(arena.getFruits()).thenReturn(Collections.emptyList());

        Field firstField;
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

        arenaController.step(game, GUI.ACTION.DOWN, System.currentTimeMillis());

        verify(state, times(1)).increaseLevel();
        verify(game, times(1)).setState(any(LevelCompletedMenuState.class), any(Type.class), anyInt(), anyInt());
    }

    @Test
    void stepTestWinLeft() throws IOException {
        when(arena.getFruits()).thenReturn(Collections.emptyList());

        Field firstField;
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

        arenaController.step(game, GUI.ACTION.LEFT, System.currentTimeMillis());


        verify(state, times(1)).increaseLevel();
        verify(game, times(1)).setState(any(LevelCompletedMenuState.class), any(Type.class), anyInt(), anyInt());
    }

    @Test
    void stepTestWinRight() throws IOException {
        when(arena.getFruits()).thenReturn(Collections.emptyList());

        Field firstField;
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

        arenaController.step(game, GUI.ACTION.RIGHT, System.currentTimeMillis());


        verify(state, times(1)).increaseLevel();
        verify(game, times(1)).setState(any(LevelCompletedMenuState.class), any(Type.class), anyInt(), anyInt());
    }

    @Test
    void stepTestNewFruits() throws IOException {
        when(arena.getFruits()).thenReturn(Collections.emptyList());
        arenaController.step(game, GUI.ACTION.UP, System.currentTimeMillis());
        verify(arena, times(1)).generateNewFruits(anyInt());
    }
    @Test
    void stepTestEscape() throws IOException {
        when(arena.getFruits()).thenReturn(List.of(mock(Fruit.class)));
        when(iceCream.getAlive()).thenReturn(true);
        arenaController.step(game, GUI.ACTION.PAUSE, System.currentTimeMillis());

        verify(game, times(1)).setState(any(PauseMenuState.class), any(Type.class), anyInt(), anyInt());
    }
    @Test
    void stepTestGameOverUp() throws IOException {
        when(iceCreamController.eatFruit()).thenReturn(-1);
        when(iceCream.isStrawberryActive()).thenReturn(false);
        when(iceCream.getAlive()).thenReturn(false);
        when(arena.getFruits()).thenReturn(List.of(mock(Fruit.class)));

        arenaController.step(game, GUI.ACTION.UP, System.currentTimeMillis());


        verify(game, times(1)).getState();
        verify(game, times(1)).setState(any(GameOverMenuState.class), any(Type.class), anyInt(), anyInt());

    }

    @Test
    void stepTestGameOverDown() throws IOException {
        when(iceCreamController.eatFruit()).thenReturn(-1);
        when(iceCream.isStrawberryActive()).thenReturn(false);
        when(iceCream.getAlive()).thenReturn(false);
        when(arena.getFruits()).thenReturn(List.of(mock(Fruit.class)));

        arenaController.step(game, GUI.ACTION.DOWN, System.currentTimeMillis());


        verify(game, times(1)).setState(any(GameOverMenuState.class), any(Type.class), anyInt(), anyInt());
    }

    @Test
    void stepTestGameOverLeft() throws IOException {
        when(iceCreamController.eatFruit()).thenReturn(-1);
        when(iceCream.isStrawberryActive()).thenReturn(false);
        when(iceCream.getAlive()).thenReturn(false);
        when(arena.getFruits()).thenReturn(List.of(mock(Fruit.class)));

        arenaController.step(game, GUI.ACTION.LEFT, System.currentTimeMillis());


        verify(game, times(1)).setState(any(GameOverMenuState.class), any(Type.class), anyInt(), anyInt());
    }

    @Test
    void stepTestGameOverRight() throws IOException {
        when(iceCreamController.eatFruit()).thenReturn(-1);
        when(iceCream.isStrawberryActive()).thenReturn(false);
        when(iceCream.getAlive()).thenReturn(false);
        when(arena.getFruits()).thenReturn(List.of(mock(Fruit.class)));

        arenaController.step(game, GUI.ACTION.RIGHT, System.currentTimeMillis());


        verify(game, times(1)).setState(any(GameOverMenuState.class), any(Type.class), anyInt(), anyInt());
    }

    @Test
    void testStrawberryExpirationUp() throws IOException {

        when(iceCream.getAlive()).thenReturn(true);
        when(iceCreamController.eatFruit()).thenReturn(-1);
        when(iceCream.isStrawberryActive()).thenReturn(true);
        long currentTime = System.currentTimeMillis();

        arenaController.step(game, GUI.ACTION.UP, currentTime);


        verify(iceCream, times(1)).setStrawberry(false);

    }

    @Test
    void testStrawberryExpirationDown() throws IOException {

        when(iceCream.getAlive()).thenReturn(true);
        when(iceCreamController.eatFruit()).thenReturn(-1);
        when(iceCream.isStrawberryActive()).thenReturn(true);
        long currentTime = System.currentTimeMillis() + 10000;

        arenaController.step(game, GUI.ACTION.DOWN, currentTime);

        verify(iceCream, times(1)).setStrawberry(false);

    }

    @Test
    void testStrawberryExpirationLeft() throws IOException {

        when(iceCream.getAlive()).thenReturn(true);
        when(iceCreamController.eatFruit()).thenReturn(-1);
        when(iceCream.isStrawberryActive()).thenReturn(true);
        long currentTime = System.currentTimeMillis() + 30000;

        arenaController.step(game, GUI.ACTION.LEFT, currentTime);

        verify(iceCream, times(1)).setStrawberry(false);

    }

    @Test
    void testStrawberryExpirationRight() throws IOException {

        when(iceCream.getAlive()).thenReturn(true);
        when(iceCreamController.eatFruit()).thenReturn(-1);
        when(iceCream.isStrawberryActive()).thenReturn(true);
        long currentTime = System.currentTimeMillis() + 40000;

        arenaController.step(game, GUI.ACTION.RIGHT, currentTime);

        verify(iceCream, times(1)).setStrawberry(false);

    }

    @Test
    void testStrawberryNoExpiration() throws IOException {

        when(iceCream.getAlive()).thenReturn(true);
        when(iceCreamController.eatFruit()).thenReturn(-1);
        long currentTime = System.currentTimeMillis() + 30000;


        Field firstField;
        try {
            firstField = ArenaController.class.getDeclaredField("strawberry");
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        firstField.setAccessible(true);
        try {
            firstField.set(arenaController, currentTime);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        arenaController.step(game, GUI.ACTION.LEFT, currentTime);
        when(iceCream.isStrawberryActive()).thenReturn(true);
        arenaController.step(game, GUI.ACTION.LEFT, currentTime + 9999);

        verify(iceCream, never()).setStrawberry(false);

    }

    @Test
    void testStrawberryExpirationLowerLimit() throws IOException {

        when(iceCream.getAlive()).thenReturn(true);
        when(iceCreamController.eatFruit()).thenReturn(-1);
        long currentTime = System.currentTimeMillis() + 30000;


        Field firstField;
        try {
            firstField = ArenaController.class.getDeclaredField("strawberry");
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        firstField.setAccessible(true);
        try {
            firstField.set(arenaController, currentTime);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        arenaController.step(game, GUI.ACTION.LEFT, currentTime);
        when(iceCream.isStrawberryActive()).thenReturn(true);
        arenaController.step(game, GUI.ACTION.LEFT, currentTime + 10000);

        verify(iceCream, times(1)).setStrawberry(false);

    }

    @Test
    void testStepEatFruitUp() throws IOException {
        when(iceCreamController.eatFruit()).thenReturn(5);

        arenaController.step(game, GUI.ACTION.UP, System.currentTimeMillis());

        verify(iceCream, times(1)).setStrawberry(true);
    }

    @Test
    void testStepEatFruitDown() throws IOException {
        when(iceCreamController.eatFruit()).thenReturn(5);

        arenaController.step(game, GUI.ACTION.DOWN, System.currentTimeMillis());

        verify(iceCream, times(1)).setStrawberry(true);

    }

    @Test
    void testStepEatFruitLeft() throws IOException {
        when(iceCreamController.eatFruit()).thenReturn(5);

        arenaController.step(game, GUI.ACTION.LEFT, System.currentTimeMillis());

        verify(iceCream, times(1)).setStrawberry(true);

    }

    @Test
    void testStepEatFruitRigth() throws IOException {
        when(iceCreamController.eatFruit()).thenReturn(5);

        arenaController.step(game, GUI.ACTION.RIGHT, System.currentTimeMillis());

        verify(iceCream, times(1)).setStrawberry(true);
    }

    @Test
    void testStepDontEatStrawberry1() throws IOException {

        when(iceCreamController.eatFruit()).thenReturn(1);

        arenaController.step(game, GUI.ACTION.UP, System.currentTimeMillis());

        verify(iceCream, never()).setStrawberry(true);

    }

    @Test
    void testStepDontEatStrawberry2() throws IOException {

        when(iceCreamController.eatFruit()).thenReturn(2);

        arenaController.step(game, GUI.ACTION.UP, System.currentTimeMillis());

        verify(iceCream, never()).setStrawberry(true);

    }

    @Test
    void testStepDontEatStrawberry3() throws IOException {

        when(iceCreamController.eatFruit()).thenReturn(3);

        arenaController.step(game, GUI.ACTION.UP, System.currentTimeMillis());

        verify(iceCream, never()).setStrawberry(true);

    }

    @Test
    void testStepDontEatStrawberry4() throws IOException {

        when(iceCreamController.eatFruit()).thenReturn(4);

        arenaController.step(game, GUI.ACTION.RIGHT, System.currentTimeMillis());

        verify(iceCream, never()).setStrawberry(true);

    }

    @Test
    void testStepIceCreamUp() throws IOException {
        when(iceCreamController.eatFruit()).thenReturn(-1);
        when(arena.getFruits()).thenReturn(List.of(mock(Fruit.class)));
        when(iceCream.getAlive()).thenReturn(true);

        long step = System.currentTimeMillis();
        arenaController.step(game, GUI.ACTION.UP, step);
        verify(iceCreamController, times(1)).step(game, GUI.ACTION.UP, step);
    }

    @Test
    void testStepIceCreamDown() throws IOException {
        when(iceCreamController.eatFruit()).thenReturn(-1);
        when(arena.getFruits()).thenReturn(List.of(mock(Fruit.class)));
        when(iceCream.getAlive()).thenReturn(true);

        long step = System.currentTimeMillis();
        arenaController.step(game, GUI.ACTION.DOWN, step);
        verify(iceCreamController, times(1)).step(game, GUI.ACTION.DOWN, step);
    }

    @Test
    void testStepIceCreamLeft() throws IOException {
        when(iceCreamController.eatFruit()).thenReturn(-1);
        when(arena.getFruits()).thenReturn(List.of(mock(Fruit.class)));
        when(iceCream.getAlive()).thenReturn(true);

        long step = System.currentTimeMillis();
        arenaController.step(game, GUI.ACTION.LEFT, step);
        verify(iceCreamController, times(1)).step(game, GUI.ACTION.LEFT, step);
    }

    @Test
    void testStepIceCreamRight() throws IOException {
        when(iceCreamController.eatFruit()).thenReturn(-1);
        when(arena.getFruits()).thenReturn(List.of(mock(Fruit.class)));
        when(iceCream.getAlive()).thenReturn(true);

        long step = System.currentTimeMillis();
        arenaController.step(game, GUI.ACTION.RIGHT, step);
        verify(iceCreamController, times(1)).step(game, GUI.ACTION.RIGHT, step);
    }


    @Test
    void testStepMonster() throws IOException {
        long currentTime = System.currentTimeMillis();
        arenaController.stepMonsters(currentTime);

        verify(monsterController1).step(currentTime);
        verify(monsterController2).step(currentTime);
    }

}
