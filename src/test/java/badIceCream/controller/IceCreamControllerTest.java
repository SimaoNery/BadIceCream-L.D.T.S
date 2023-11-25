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
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IceCreamControllerTest {
    private IceCreamController controller;

    private Game game;
    private IceCream iceCream;
    private Arena arena;

    @BeforeEach
    void setUp() {
        arena = new Arena(10,10);
        iceCream = new IceCream(5,5);

        arena.setIceCream(iceCream);
        arena.setWalls(List.of());
        arena.setMonsters(List.of());
    }

    @Test
    void testMoveIceCreamRightEmpty() {
        controller = new IceCreamController(arena);
        controller.moveIceCreamRight();
        Assertions.assertEquals(new Position(6,5), iceCream.getPosition());
    }

    @Test
    void testMoveIceCreamRightNotEmptyStone() {
        arena.setWalls(List.of(new StoneWall(6, 5)));
        controller = new IceCreamController(arena);
        controller.moveIceCreamRight();
        Assertions.assertEquals(new Position(5,5), iceCream.getPosition());
    }

    @Test
    void testMoveIceCreamRightNotEmptyIce() {
        arena.setWalls(List.of(new IceWall(6, 5)));

        controller = new IceCreamController(arena);
        controller.moveIceCreamRight();
        Assertions.assertEquals(new Position(5,5), iceCream.getPosition());
    }

    @Test
    void testMoveIceCreamLeftEmpty() {
        controller = new IceCreamController(arena);
        controller.moveIceCreamLeft();
        Assertions.assertEquals(new Position(4,5), iceCream.getPosition());
    }

    @Test
    void testMoveIceCreamLeftNotEmptyStone() {
        arena.setWalls(List.of(new StoneWall(4, 5)));

        controller = new IceCreamController(arena);
        controller.moveIceCreamLeft();
        Assertions.assertEquals(new Position(5,5), iceCream.getPosition());
    }

    @Test
    void testMoveIceCreamLeftNotEmptyIce() {
        arena.setWalls(List.of(new IceWall(4, 5)));
        controller = new IceCreamController(arena);
        controller.moveIceCreamLeft();
        Assertions.assertEquals(new Position(5,5), iceCream.getPosition());
    }

    @Test
    void testMoveIceCreamDownEmpty() {
        controller = new IceCreamController(arena);
        controller.moveIceCreamDown();
        Assertions.assertEquals(new Position(5,6), iceCream.getPosition());
    }

    @Test
    void testMoveIceCreamDownNotEmptyStone() {
        arena.setWalls(List.of(new StoneWall(5, 6)));

        controller = new IceCreamController(arena);
        controller.moveIceCreamDown();
        Assertions.assertEquals(new Position(5,5), iceCream.getPosition());
    }

    @Test
    void testMoveIceCreamDownNotEmptyIce() {
        arena.setWalls(List.of(new IceWall(5, 6)));

        controller = new IceCreamController(arena);
        controller.moveIceCreamDown();
        Assertions.assertEquals(new Position(5,5), iceCream.getPosition());
    }

    @Test
    void testMoveIceCreamUpEmpty() {
        controller = new IceCreamController(arena);
        controller.moveIceCreamUp();
        Assertions.assertEquals(new Position(5,4), iceCream.getPosition());
    }

    @Test
    void testMoveIceCreamUpNotEmptyStone() {
        arena.setWalls(List.of(new StoneWall(5, 4)));

        controller = new IceCreamController(arena);
        controller.moveIceCreamUp();
        Assertions.assertEquals(new Position(5,5), iceCream.getPosition());
    }

    @Test
    void testMoveIceCreamUpNotEmptyIce() {
        arena.setWalls(List.of(new IceWall(5, 4)));

        controller = new IceCreamController(arena);
        controller.moveIceCreamUp();
        Assertions.assertEquals(new Position(5,5), iceCream.getPosition());
    }

    @Test
    void testMonsterColision() {
        arena.setMonsters(List.of(new DefaultMonster(5, 4)));

        controller = new IceCreamController(arena);
        controller.moveIceCreamUp();
        assertFalse(iceCream.getAlive());
    }

    @Test
    void testMonsterNoColision() {
        arena.setMonsters(List.of(new DefaultMonster(5, 6)));

        controller = new IceCreamController(arena);
        controller.moveIceCreamUp();
        assertTrue(iceCream.getAlive());
    }

    @Test
    void testAction() {
        game = Mockito.mock(Game.class);
        controller = new IceCreamController(arena);
        controller.step(game, GUI.ACTION.UP, 0);
        Assertions.assertEquals(new Position(5,4), iceCream.getPosition());
    }
}
