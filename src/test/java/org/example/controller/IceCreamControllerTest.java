package org.example.controller;

import org.example.GUI.GUI;
import org.example.Game;
import org.example.controller.game.IceCreamController;
import org.example.model.Position;
import org.example.model.game.arena.Arena;
import org.example.model.game.elements.IceCream;
import org.example.model.game.elements.IceWall;
import org.example.model.game.elements.StoneWall;
import org.example.model.game.elements.monsters.DefaultMonster;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
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
        assertEquals(new Position(6,5), iceCream.getPosition());
    }

    @Test
    void testMoveIceCreamRightNotEmptyStone() {
        arena.setWalls(List.of(new StoneWall(6, 5)));
        controller = new IceCreamController(arena);
        controller.moveIceCreamRight();
        assertEquals(new Position(5,5), iceCream.getPosition());
    }

    @Test
    void testMoveIceCreamRightNotEmptyIce() {
        arena.setWalls(List.of(new IceWall(6, 5)));

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
        arena.setWalls(List.of(new StoneWall(4, 5)));

        controller = new IceCreamController(arena);
        controller.moveIceCreamLeft();
        assertEquals(new Position(5,5), iceCream.getPosition());
    }

    @Test
    void testMoveIceCreamLeftNotEmptyIce() {
        arena.setWalls(List.of(new IceWall(4, 5)));
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
        arena.setWalls(List.of(new StoneWall(5, 6)));

        controller = new IceCreamController(arena);
        controller.moveIceCreamDown();
        assertEquals(new Position(5,5), iceCream.getPosition());
    }

    @Test
    void testMoveIceCreamDownNotEmptyIce() {
        arena.setWalls(List.of(new IceWall(5, 6)));

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
        arena.setWalls(List.of(new StoneWall(5, 4)));

        controller = new IceCreamController(arena);
        controller.moveIceCreamUp();
        assertEquals(new Position(5,5), iceCream.getPosition());
    }

    @Test
    void testMoveIceCreamUpNotEmptyIce() {
        arena.setWalls(List.of(new IceWall(5, 4)));

        controller = new IceCreamController(arena);
        controller.moveIceCreamUp();
        assertEquals(new Position(5,5), iceCream.getPosition());
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
    void testAction() throws IOException, URISyntaxException, FontFormatException {
        game = Mockito.mock(Game.class);
        controller = new IceCreamController(arena);
        controller.step(game, GUI.ACTION.UP, 0);
        assertEquals(new Position(5,4), iceCream.getPosition());
    }
}
