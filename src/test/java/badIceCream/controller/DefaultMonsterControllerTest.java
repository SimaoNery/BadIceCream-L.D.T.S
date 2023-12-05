package badIceCream.controller;

import badIceCream.model.game.arena.Arena;
import badIceCream.GUI.GUI;
import badIceCream.model.Position;
import badIceCream.model.game.elements.IceCream;
import badIceCream.model.game.elements.StoneWall;
import badIceCream.model.game.elements.monsters.DefaultMonster;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
/*
class DefaultMonsterControllerTest {
    private DefaultController controller;
    private Arena arena;

    private IceCream iceCream;


    @BeforeEach
    void setUp() {
        arena = new Arena(10, 10);

        iceCream = new IceCream(2,2);

        arena.setIceCream(iceCream);
        arena.setWalls(List.of());
        arena.setMonsters(List.of());

        controller = new DefaultController(arena);
    }

    @Test
    void moveMonster() throws IOException {
        DefaultMonster monster = new DefaultMonster(5, 5);
        arena.setMonsters(List.of(monster));

        controller.step(monster, GUI.ACTION.NONE, 1000);

        assertNotEquals(new Position(5, 5), monster.getPosition());
    }


    @Test
    void moveMonsterUp() throws IOException {
        DefaultMonster monster = new DefaultMonster(5, 5);
        StoneWall stoneWallDown = new StoneWall(5,6);
        StoneWall stoneWallLeft = new StoneWall(4,5);
        StoneWall stoneWallRight = new StoneWall(6,5);
        arena.setMonsters(List.of(monster));
        arena.setWalls(List.of(stoneWallDown,stoneWallLeft,stoneWallRight));

        controller.step(monster, GUI.ACTION.NONE, 1000);

        assertEquals(new Position(5, 4), monster.getPosition());
    }

    @Test
    void moveMonsterRight() throws IOException {
        DefaultMonster monster = new DefaultMonster(5, 5);
        StoneWall stoneWallDown = new StoneWall(5,6);
        StoneWall stoneWallUp = new StoneWall(5,4);
        StoneWall stoneWallLeft = new StoneWall(4,5);
        arena.setMonsters(List.of(monster));
        arena.setWalls(List.of(stoneWallDown,stoneWallUp,stoneWallLeft));

        controller.step(monster, GUI.ACTION.NONE, 1000);

        assertEquals(new Position(6, 5), monster.getPosition());
    }

    @Test
    void moveMonsterLeft() throws IOException {
        DefaultMonster monster = new DefaultMonster(5, 5);
        StoneWall stoneWallDown = new StoneWall(5,6);
        StoneWall stoneWallUp = new StoneWall(5,4);
        StoneWall stoneWallRight = new StoneWall(6,5);
        arena.setMonsters(List.of(monster));
        arena.setWalls(List.of(stoneWallDown,stoneWallUp,stoneWallRight));

        controller.step(monster, GUI.ACTION.NONE, 1000);

        assertEquals(new Position(4, 5), monster.getPosition());
    }

    @Test
    void moveMonsterDown() throws IOException {
        DefaultMonster monster = new DefaultMonster(5, 5);
        StoneWall stoneWallUp = new StoneWall(5,4);
        StoneWall stoneWallLeft = new StoneWall(4,5);
        StoneWall stoneWallRight = new StoneWall(6,5);
        arena.setMonsters(List.of(monster));
        arena.setWalls(List.of(stoneWallUp,stoneWallLeft,stoneWallRight));

        controller.step(monster, GUI.ACTION.NONE, 1000);

        assertEquals(new Position(5, 6), monster.getPosition());
    }

    @Test
    void moveMonsterClosed() throws IOException {
        DefaultMonster monster = new DefaultMonster(5, 5);
        StoneWall stoneWallDown = new StoneWall(5,6);
        StoneWall stoneWallUp = new StoneWall(5,4);
        StoneWall stoneWallRight = new StoneWall(6,5);
        StoneWall stoneWallLeft = new StoneWall(4,5);
        arena.setMonsters(List.of(monster));
        arena.setWalls(List.of(stoneWallDown,stoneWallUp,stoneWallRight, stoneWallLeft));

        for (int i = 0; i < 10; i++)
            controller.step(monster, GUI.ACTION.NONE, 1000);

        assertEquals(new Position(5, 5), monster.getPosition());
    }

    @Test
    void moveTwoMonsterClosed() throws IOException {
        DefaultMonster monster = new DefaultMonster(5, 5);
        DefaultMonster otherMonster = new DefaultMonster(4, 5);

        StoneWall stoneWallDown = new StoneWall(5,6);
        StoneWall stoneWallUp = new StoneWall(5,4);
        StoneWall stoneWallRight = new StoneWall(6,5);
        StoneWall stoneWallLeft = new StoneWall(3,5);
        StoneWall stoneWallDownO = new StoneWall(4,4);
        StoneWall stoneWallUpO = new StoneWall(4,6);

        arena.setMonsters(List.of(monster, otherMonster));
        arena.setWalls(List.of(stoneWallDown,stoneWallUp,stoneWallRight, stoneWallLeft, stoneWallUpO, stoneWallDownO));

        controller.step(monster, GUI.ACTION.NONE, 1000);
        controller.step(otherMonster, GUI.ACTION.NONE, 1000);

        assertEquals(new Position(5, 5), monster.getPosition());
        assertEquals(new Position(4,5), otherMonster.getPosition());
    }

    @Test
    void moveMonsterToIceCream() throws IOException {
        DefaultMonster monster = new DefaultMonster(3, 2);

        StoneWall stoneWallDown = new StoneWall(2,3);
        StoneWall stoneWallUpO = new StoneWall(2,1);
        StoneWall stoneWallUp = new StoneWall(3,1);
        StoneWall stoneWallDownO = new StoneWall(3,3);
        StoneWall stoneWallRight = new StoneWall(1,2);
        StoneWall stoneWallLeft = new StoneWall(4,2);

        arena.setMonsters(List.of(monster));
        arena.setWalls(List.of(stoneWallDown,stoneWallUp,stoneWallRight, stoneWallLeft, stoneWallUpO, stoneWallDownO));

        controller.step(monster, GUI.ACTION.NONE, 1000);

        System.out.println("Monster: " + monster.getPosition().getX() + " " + monster.getPosition().getY());

        assertFalse(iceCream.getAlive());
        assertEquals(new Position(2, 2), monster.getPosition());
    }
}
*/