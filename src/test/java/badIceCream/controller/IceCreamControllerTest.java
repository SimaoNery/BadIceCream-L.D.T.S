package badIceCream.controller;

import badIceCream.GUI.GUI;
import badIceCream.Game;
import badIceCream.controller.game.IceCreamController;
import badIceCream.model.Position;
import badIceCream.model.game.arena.Arena;
import badIceCream.model.game.elements.IceCream;
import badIceCream.model.game.elements.IceWall;
import badIceCream.model.game.elements.StoneWall;
import badIceCream.model.game.elements.monsters.DefaultMonster;
import badIceCream.states.State;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class IceCreamControllerTest {
    private IceCreamController controller;
    private Game game;
    private IceCream iceCream;
    private Arena arena;

    @BeforeEach
    void setUp() {
        game = mock(Game.class);
        State mockedState = mock(State.class);

        when(game.getState()).thenReturn(mockedState);

        iceCream = new IceCream(5,5);
        arena = new Arena(10, 10);

        arena.setIceCream(iceCream);
        arena.setWalls(new ArrayList<>());
        arena.setFruits(new ArrayList<>());
        arena.setMonsters(new ArrayList<>());
        controller = new IceCreamController(arena);
    }

    @Test
    void testMoveIceCreamRightEmpty() {
        controller.step(game, GUI.ACTION.RIGHT, System.currentTimeMillis());
        Assertions.assertEquals(new Position(6,5), iceCream.getPosition());
    }

    @Test
    void testMoveIceCreamRightNotEmptyStone() {
        arena.setWalls(List.of(new StoneWall(6, 5)));
        controller.step(game, GUI.ACTION.RIGHT, System.currentTimeMillis());
        Assertions.assertEquals(new Position(5,5), iceCream.getPosition());
    }

    @Test
    void testMoveIceCreamRightNotEmptyIce() {
        arena.setWalls(List.of(new IceWall(6, 5)));

        controller.step(game, GUI.ACTION.RIGHT, System.currentTimeMillis());
        Assertions.assertEquals(new Position(5,5), iceCream.getPosition());
    }

    @Test
    void testMoveIceCreamLeftEmpty() {
        controller.step(game, GUI.ACTION.LEFT, System.currentTimeMillis());
        Assertions.assertEquals(new Position(4,5), iceCream.getPosition());
    }

    @Test
    void testMoveIceCreamLeftNotEmptyStone() {
        arena.setWalls(List.of(new StoneWall(4, 5)));

        controller.step(game, GUI.ACTION.LEFT, System.currentTimeMillis());
        Assertions.assertEquals(new Position(5,5), iceCream.getPosition());
    }

    @Test
    void testMoveIceCreamLeftNotEmptyIce() {
        arena.setWalls(List.of(new IceWall(4, 5)));

        controller.step(game, GUI.ACTION.LEFT, System.currentTimeMillis());
        Assertions.assertEquals(new Position(5,5), iceCream.getPosition());
    }

    @Test
    void testMoveIceCreamDownEmpty() {
        controller.step(game, GUI.ACTION.DOWN, System.currentTimeMillis());
        Assertions.assertEquals(new Position(5,6), iceCream.getPosition());
    }

    @Test
    void testMoveIceCreamDownNotEmptyStone() {
        arena.setWalls(List.of(new StoneWall(5, 6)));

        controller.step(game, GUI.ACTION.DOWN, System.currentTimeMillis());
        Assertions.assertEquals(new Position(5,5), iceCream.getPosition());
    }

    @Test
    void testMoveIceCreamDownNotEmptyIce() {
        arena.setWalls(List.of(new IceWall(5, 6)));

        controller.step(game, GUI.ACTION.DOWN, System.currentTimeMillis());
        Assertions.assertEquals(new Position(5,5), iceCream.getPosition());
    }

    @Test
    void testMoveIceCreamUpEmpty() {

        controller.step(game, GUI.ACTION.UP, System.currentTimeMillis());
        Assertions.assertEquals(new Position(5,4), iceCream.getPosition());
    }

    @Test
    void testMoveIceCreamUpNotEmptyStone() {
        arena.setWalls(List.of(new StoneWall(5, 4)));

        controller.step(game, GUI.ACTION.UP, System.currentTimeMillis());
        Assertions.assertEquals(new Position(5,5), iceCream.getPosition());
    }

    @Test
    void testMoveIceCreamUpNotEmptyIce() {
        arena.setWalls(List.of(new IceWall(5, 4)));

        controller.step(game, GUI.ACTION.UP, System.currentTimeMillis());
        Assertions.assertEquals(new Position(5,5), iceCream.getPosition());
    }

    @Test
    void testMonsterColision() {
        arena.setMonsters(List.of(new DefaultMonster(5, 4)));

        controller.step(game, GUI.ACTION.UP, System.currentTimeMillis());
        assertFalse(iceCream.getAlive());
    }

    @Test
    void testMonsterNoColision() {
        arena.setMonsters(List.of(new DefaultMonster(5, 6)));

        controller.step(game, GUI.ACTION.UP, System.currentTimeMillis());
        assertTrue(iceCream.getAlive());
    }
}
