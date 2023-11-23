package org.example.controller;

import org.example.controller.game.IceCreamController;
import org.example.model.Position;
import org.example.model.game.arena.Arena;
import org.example.model.game.elements.IceCream;
import org.example.model.game.elements.IceWall;
import org.example.model.game.elements.StoneWall;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IceCreamControllerTest {
    private IceCreamController controller;
    private IceCream iceCream;
    private Arena arena;

    @BeforeEach
    void setUp() {
        arena = new Arena(10,10);
        iceCream = new IceCream(5,5);

        arena.setIceCream(iceCream);
        arena.setWalls(Arrays.asList());
        arena.setMonsters(Arrays.asList());
    }

    @Test
    void testMoveIceCreamRightEmpty() {
        controller = new IceCreamController(arena);
        controller.moveIceCreamRight();
        assertEquals(new Position(6,5), iceCream.getPosition());
    }

    @Test
    void testMoveIceCreamRightNotEmptyStone() {
        arena.setWalls(Arrays.asList(new StoneWall(6,5)));
        controller = new IceCreamController(arena);
        controller.moveIceCreamRight();
        assertEquals(new Position(5,5), iceCream.getPosition());
    }

    @Test
    void testMoveIceCreamRightNotEmptyIce() {
        arena.setWalls(Arrays.asList(new IceWall(6,5)));

        controller = new IceCreamController(arena);
        controller.moveIceCreamRight();
        assertEquals(new Position(5,5), iceCream.getPosition());
    }

    @Test
    void testMoveIceCreamLeftEmpty() {
        controller = new IceCreamController(arena);
        controller.moveIceCreamLeft();
        assertEquals(new Position(4,5), iceCream.getPosition());
    }

    @Test
    void testMoveIceCreamLeftNotEmptyStone() {
        arena.setWalls(Arrays.asList(new StoneWall(4,5)));

        controller = new IceCreamController(arena);
        controller.moveIceCreamLeft();
        assertEquals(new Position(5,5), iceCream.getPosition());
    }

    @Test
    void testMoveIceCreamLeftNotEmptyIce() {
        arena.setWalls(Arrays.asList(new IceWall(4,5)));
        controller = new IceCreamController(arena);
        controller.moveIceCreamLeft();
        assertEquals(new Position(5,5), iceCream.getPosition());
    }

    @Test
    void testMoveIceCreamDownEmpty() {
        controller = new IceCreamController(arena);
        controller.moveIceCreamDown();
        assertEquals(new Position(5,6), iceCream.getPosition());
    }

    @Test
    void testMoveIceCreamDownNotEmptyStone() {
        arena.setWalls(Arrays.asList(new StoneWall(5,6)));

        controller = new IceCreamController(arena);
        controller.moveIceCreamDown();
        assertEquals(new Position(5,5), iceCream.getPosition());
    }

    @Test
    void testMoveIceCreamDownNotEmptyIce() {
        arena.setWalls(Arrays.asList(new IceWall(5,6)));

        controller = new IceCreamController(arena);
        controller.moveIceCreamDown();
        assertEquals(new Position(5,5), iceCream.getPosition());
    }

    @Test
    void testMoveIceCreamUpEmpty() {
        controller = new IceCreamController(arena);
        controller.moveIceCreamUp();
        assertEquals(new Position(5,4), iceCream.getPosition());
    }

    @Test
    void testMoveIceCreamUpNotEmptyStone() {
        arena.setWalls(Arrays.asList(new StoneWall(5,4)));

        controller = new IceCreamController(arena);
        controller.moveIceCreamUp();
        assertEquals(new Position(5,5), iceCream.getPosition());
    }

    @Test
    void testMoveIceCreamUpNotEmptyIce() {
        arena.setWalls(Arrays.asList(new IceWall(5,4)));

        controller = new IceCreamController(arena);
        controller.moveIceCreamUp();
        assertEquals(new Position(5,5), iceCream.getPosition());
    }
}
