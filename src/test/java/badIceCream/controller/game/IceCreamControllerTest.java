package badIceCream.controller.game;

import badIceCream.GUI.GUI;
import badIceCream.GUI.Graphics;
import badIceCream.Game;
import badIceCream.model.Position;
import badIceCream.model.game.arena.Arena;
import badIceCream.model.game.elements.IceCream;
import badIceCream.model.game.elements.monsters.Monster;
import badIceCream.states.State;
import badIceCream.utils.Type;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class IceCreamControllerTest {
    private IceCreamController controller;
    @Mock
    private Game game;
    private IceCream iceCream;
    @Mock
    private State state;
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

        iceCream = mock(IceCream.class);
        arena = mock(Arena.class);
        when(arena.getIceCream()).thenReturn(iceCream);
        when(arena.getWalls()).thenReturn(new ArrayList<>());
        when(arena.getFruits()).thenReturn(new ArrayList<>());
        when(arena.getMonsters()).thenReturn(new ArrayList<>());

        position = mock(Position.class);
        when(position.getRight()).thenReturn(position);
        when(position.getUp()).thenReturn(position);
        when(position.getLeft()).thenReturn(position);
        when(position.getDown()).thenReturn(position);
        when(iceCream.getPosition()).thenReturn(position);

        controller = new IceCreamController(arena);
        when(game.getGraphicsForGame(any(Type.class), anyInt(), anyInt())).thenReturn(graphics);
    }

    @Test
    void testNoMovementIceCream() {
        Field firstField;
        try {
            firstField = IceCreamController.class.getDeclaredField("lastTime");
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        firstField.setAccessible(true);
        try {
            firstField.set(controller, 15L);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        controller.step(game, GUI.ACTION.DOWN, 16L);
        controller.step(game, GUI.ACTION.UP, 17L);
        controller.step(game, GUI.ACTION.RIGHT, 29L);
        controller.step(game, GUI.ACTION.LEFT, 28L);

        verify(iceCream, never()).setPosition(any());
    }

    @Test
    void testMoveIceCreamUpNoMonsterNoStrawberry() {
        when(iceCream.getPosition()).thenReturn(position);

        Field firstField;
        try {
            firstField = IceCreamController.class.getDeclaredField("lastTime");
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        firstField.setAccessible(true);
        try {
            firstField.set(controller, 15L);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        when(arena.isEmpty(position)).thenReturn(true);
        when(arena.hasMonster(position)).thenReturn(null);
        when(iceCream.isStrawberryActive()).thenReturn(false);

        controller.step(game, GUI.ACTION.DOWN, 30L);
        controller.step(game, GUI.ACTION.UP, 30L);
        controller.step(game, GUI.ACTION.RIGHT, 30L);
        controller.step(game, GUI.ACTION.LEFT, 30L);

        verify(iceCream, times(4)).setPosition(position);
        verify(iceCream, times(1)).setLastMovement(GUI.ACTION.DOWN);
        verify(iceCream, times(1)).setLastMovement(GUI.ACTION.UP);
        verify(iceCream, times(1)).setLastMovement(GUI.ACTION.LEFT);
        verify(iceCream, times(1)).setLastMovement(GUI.ACTION.RIGHT);
        verify(iceCream, never()).changeAlive();
    }

    @Test
    void testMoveIceCreamBlocked() {
        Position position = mock(Position.class);
        Position previous = mock(Position.class);
        when(iceCream.getPosition()).thenReturn(previous);
        when(previous.getRight()).thenReturn(position);
        when(arena.isEmpty(position)).thenReturn(false);
        when(arena.hasMonster(position)).thenReturn(null);
        when(iceCream.isStrawberryActive()).thenReturn(false);

        Field firstField;
        try {
            firstField = IceCreamController.class.getDeclaredField("lastTime");
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        firstField.setAccessible(true);
        try {
            firstField.set(controller, 15L);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        controller.step(game, GUI.ACTION.UP, 30L);

        verify(iceCream, never()).setPosition(position);
        verify(iceCream, times(1)).setLastMovement(GUI.ACTION.UP);

        controller.step(game, GUI.ACTION.DOWN, 30L);

        verify(iceCream, never()).setPosition(position);
        verify(iceCream, times(1)).setLastMovement(GUI.ACTION.DOWN);

        controller.step(game, GUI.ACTION.LEFT, 30L);

        verify(iceCream, never()).setPosition(position);
        verify(iceCream, times(1)).setLastMovement(GUI.ACTION.LEFT);

        controller.step(game, GUI.ACTION.RIGHT, 30L);

        verify(iceCream, never()).setPosition(position);
        verify(iceCream, times(1)).setLastMovement(GUI.ACTION.RIGHT);
    }

    @Test
    void testMoveIceCreamMonsterNoStrawberry() {
        when(iceCream.getPosition()).thenReturn(position);

        when(arena.isEmpty(position)).thenReturn(true);

        Monster monster = mock(Monster.class);
        when(arena.hasMonster(position)).thenReturn(monster);
        when(iceCream.isStrawberryActive()).thenReturn(false);

        Field firstField;
        try {
            firstField = IceCreamController.class.getDeclaredField("lastTime");
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        firstField.setAccessible(true);
        try {
            firstField.set(controller, 15L);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        controller.step(game, GUI.ACTION.DOWN, 30L);
        controller.step(game, GUI.ACTION.UP, 30L);
        controller.step(game, GUI.ACTION.RIGHT, 30L);
        controller.step(game, GUI.ACTION.LEFT, 30L);

        verify(iceCream, times(4)).setPosition(position);
        verify(iceCream, times(1)).setLastMovement(GUI.ACTION.DOWN);
        verify(iceCream, times(1)).setLastMovement(GUI.ACTION.UP);
        verify(iceCream, times(1)).setLastMovement(GUI.ACTION.LEFT);
        verify(iceCream, times(1)).setLastMovement(GUI.ACTION.RIGHT);
        verify(iceCream, times(4)).changeAlive();
    }

    @Test
    void testMoveIceCreamMonsterStrawberry() {

        when(arena.isEmpty(position)).thenReturn(true);

        Monster monster = mock(Monster.class);
        when(arena.hasMonster(position)).thenReturn(monster);
        when(iceCream.isStrawberryActive()).thenReturn(true);

        Field firstField;
        try {
            firstField = IceCreamController.class.getDeclaredField("lastTime");
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        firstField.setAccessible(true);
        try {
            firstField.set(controller, 15L);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        controller.step(game, GUI.ACTION.DOWN, 30L);
        controller.step(game, GUI.ACTION.UP, 30L);
        controller.step(game, GUI.ACTION.RIGHT, 30L);
        controller.step(game, GUI.ACTION.LEFT, 30L);

        verify(iceCream, times(4)).setPosition(position);
        verify(iceCream, times(1)).setLastMovement(GUI.ACTION.DOWN);
        verify(iceCream, times(1)).setLastMovement(GUI.ACTION.UP);
        verify(iceCream, times(1)).setLastMovement(GUI.ACTION.LEFT);
        verify(iceCream, times(1)).setLastMovement(GUI.ACTION.RIGHT);
        verify(iceCream, never()).changeAlive();
    }

    @Test
    void eatFruitTest() {
        when(arena.eatFruit(any())).thenReturn(1);

        assertEquals(controller.eatFruit(), 1);
    }

    @Test
    void powerIceCreamTest() {
        controller.step(game, GUI.ACTION.UP, System.currentTimeMillis());
        controller.step(game, GUI.ACTION.SPACE, System.currentTimeMillis());

        verify(arena).powerIceCream(GUI.ACTION.UP);
        verify(iceCream, never()).setPosition(any());
    }

}
