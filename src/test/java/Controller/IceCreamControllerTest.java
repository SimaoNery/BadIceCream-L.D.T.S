package Controller;

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

        arena.setWalls(Arrays.asList());
        arena.setMonsters(Arrays.asList());
    }

    @Test
    void moveIceCreamRightEmpty() {
        controller.moveIceCreamRight();
        assertEquals(new Position(6,5), iceCream.getPosition());
    }

    @Test
    void moveIceCreamRightNotEmptyStone() {
        arena.setWalls(Arrays.asList(new StoneWall(6,5)));
        controller.moveIceCreamRight();
        assertEquals(new Position(5,5), iceCream.getPosition());
    }

    @Test
    void moveIceCreamRightNotEmptyIce() {
        arena.setWalls(Arrays.asList(new IceWall(6,5)));
        controller.moveIceCreamRight();
        assertEquals(new Position(5,5), iceCream.getPosition());
    }

    @Test
    void moveIceCreamLeftEmpty() {
        controller.moveIceCreamLeft();
        assertEquals(new Position(4,5), iceCream.getPosition());
    }

    @Test
    void moveIceCreamLeftNotEmptyStone() {
        arena.setWalls(Arrays.asList(new StoneWall(4,5)));
        controller.moveIceCreamLeft();
        assertEquals(new Position(5,5), iceCream.getPosition());
    }

    @Test
    void moveIceCreamLeftNotEmptyIce() {
        arena.setWalls(Arrays.asList(new IceWall(4,5)));
        controller.moveIceCreamLeft();
        assertEquals(new Position(5,5), iceCream.getPosition());
    }

    @Test
    void moveIceCreamDownEmpty() {
        controller.moveIceCreamDown();
        assertEquals(new Position(5,4), iceCream.getPosition());
    }

    @Test
    void moveIceCreamDownNotEmptyStone() {
        arena.setWalls(Arrays.asList(new StoneWall(5,4)));
        controller.moveIceCreamDown();
        assertEquals(new Position(5,5), iceCream.getPosition());
    }

    @Test
    void moveIceCreamDownNotEmptyIce() {
        arena.setWalls(Arrays.asList(new IceWall(5,4)));
        controller.moveIceCreamDown();
        assertEquals(new Position(5,5), iceCream.getPosition());
    }

    @Test
    void moveIceCreamUpEmpty() {
        controller.moveIceCreamUp();
        assertEquals(new Position(5,6), iceCream.getPosition());
    }

    @Test
    void moveIceCreamUpNotEmptyStone() {
        arena.setWalls(Arrays.asList(new StoneWall(5,6)));
        controller.moveIceCreamUp();
        assertEquals(new Position(5,5), iceCream.getPosition());
    }

    @Test
    void moveIceCreamUpNotEmptyIce() {
        arena.setWalls(Arrays.asList(new IceWall(5,6)));
        controller.moveIceCreamUp();
        assertEquals(new Position(5,5), iceCream.getPosition());
    }
}
