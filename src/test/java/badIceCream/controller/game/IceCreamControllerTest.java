package badIceCream.controller.game;

import badIceCream.GUI.GUI;
import badIceCream.Game;
import badIceCream.controller.game.IceCreamController;
import badIceCream.model.Position;
import badIceCream.model.game.arena.Arena;
import badIceCream.model.game.elements.IceCream;
import badIceCream.model.game.elements.monsters.Monster;
import badIceCream.states.State;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class IceCreamControllerTest {
    private IceCreamController controller;
    private Game game;
    private IceCream iceCream;
    private State state;
    private Arena arena;
    private Position position;

    @BeforeEach
    void setUp() {
        game = mock(Game.class);
        state = mock(State.class);

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
    }

    @Test
    void testMoveIceCreamUpNoMonsterNoStrawberry() {
        when(iceCream.getPosition()).thenReturn(position);

        when(arena.isEmpty(position)).thenReturn(true);
        when(arena.hasMonster(position)).thenReturn(null);
        when(iceCream.isStrawberryActive()).thenReturn(false);

        controller.step(game, GUI.ACTION.DOWN, 100L);
        controller.step(game, GUI.ACTION.UP, 100L);
        controller.step(game, GUI.ACTION.RIGHT, 100L);
        controller.step(game, GUI.ACTION.LEFT, 100L);

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
        when(iceCream.getPosition().getRight()).thenReturn(position);
        when(arena.isEmpty(position)).thenReturn(false);
        when(arena.hasMonster(position)).thenReturn(null);
        when(iceCream.isStrawberryActive()).thenReturn(false);
        controller.step(game, GUI.ACTION.UP, 100L);

        verify(iceCream, never()).setPosition(position);
        verify(iceCream, times(1)).setLastMovement(GUI.ACTION.UP);

        controller.step(game, GUI.ACTION.DOWN, 100L);

        verify(iceCream, never()).setPosition(position);
        verify(iceCream, times(1)).setLastMovement(GUI.ACTION.DOWN);

        controller.step(game, GUI.ACTION.LEFT, 100L);

        verify(iceCream, never()).setPosition(position);
        verify(iceCream, times(1)).setLastMovement(GUI.ACTION.LEFT);

        controller.step(game, GUI.ACTION.RIGHT, 100L);

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

        controller.step(game, GUI.ACTION.DOWN, 100L);
        controller.step(game, GUI.ACTION.UP, 100L);
        controller.step(game, GUI.ACTION.RIGHT, 100L);
        controller.step(game, GUI.ACTION.LEFT, 100L);

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

        controller.step(game, GUI.ACTION.DOWN, 100L);
        controller.step(game, GUI.ACTION.UP, 100L);
        controller.step(game, GUI.ACTION.RIGHT, 100L);
        controller.step(game, GUI.ACTION.LEFT, 100L);

        verify(iceCream, times(4)).setPosition(position);
        verify(iceCream, times(1)).setLastMovement(GUI.ACTION.DOWN);
        verify(iceCream, times(1)).setLastMovement(GUI.ACTION.UP);
        verify(iceCream, times(1)).setLastMovement(GUI.ACTION.LEFT);
        verify(iceCream, times(1)).setLastMovement(GUI.ACTION.RIGHT);
        verify(iceCream, never()).changeAlive();
    }

    @Test
    void eatFruitTest() {
        when(arena.eatFruit(iceCream.getPosition())).thenReturn(1);

        assertEquals(controller.eatFruit(), 1);
    }

    @Test
    void powerIceCreamTest() {
        controller.step(game, GUI.ACTION.UP, System.currentTimeMillis());
        controller.step(game, GUI.ACTION.SPACE, System.currentTimeMillis());

        verify(arena).powerIceCream(GUI.ACTION.UP);
    }

}
