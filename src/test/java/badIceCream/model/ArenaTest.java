package badIceCream.model;

import badIceCream.model.game.arena.Arena;
import badIceCream.model.game.elements.IceWall;
import badIceCream.model.game.elements.StoneWall;
import badIceCream.model.game.elements.Wall;

import badIceCream.model.game.elements.fruits.BananaFruit;
import badIceCream.model.game.elements.fruits.Fruit;
import badIceCream.model.game.elements.monsters.Monster;
import badIceCream.model.game.elements.monsters.RunnerMonster;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ArenaTest {
    private Arena arena;
    @Mock
    private Position position;
    @Mock
    private Position otherPosition;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        when(position.equals(any(Position.class))).thenReturn(true);
        boolean ze = position.equals(otherPosition);
        arena = new Arena(10,10);
        StoneWall stoneWall = new StoneWall(0,1);
        IceWall iceWall = new IceWall(0,2);
        List<Wall> walls = new ArrayList<>();
        walls.add(stoneWall);
        walls.add(iceWall);
        arena.setWalls(walls);
        RunnerMonster runnerMonster = new RunnerMonster(0,3);
        List<Monster> monsters = new ArrayList<>();
        monsters.add(runnerMonster);
        arena.setMonsters(monsters);
        BananaFruit bananaFruit = new BananaFruit(0,4);
        List<Fruit> fruits = new ArrayList<>();
        fruits.add(bananaFruit);
        arena.setFruits(fruits);
    }

    @Test
    public void isNotEmpty() {
        assertFalse(arena.isEmpty(new Position(0,1)));
    }
    @Test
    public void isEmpty() {
        assertTrue(arena.isEmpty(new Position(0,0)));
    }
    @Test
    public void isEmptyMonsters() {
        assertTrue(arena.isEmptyMonsters(new Position(0,0)));
    }
    @Test
    public void isNotEmptyMonstersCase1() {
        assertFalse(arena.isEmptyMonsters(new Position(0,1)));
    }
    @Test
    public void isNotEmptyMonstersCase2() {
        assertFalse(arena.isEmptyMonsters(new Position(0,3)));
    }
    @Test
    public void isEmptyNoStoneWall() {
        assertTrue(arena.isEmptyNoStoneWall(new Position(0,0)));
    }
    @Test
    public void isNotEmptyNoStoneWallCaseIceWall() {
        assertTrue(arena.isEmptyNoStoneWall(new Position(0,2)));
    }
    @Test
    public void isNotEmptyNoStoneWallCaseStoneWall() {
        assertFalse(arena.isEmptyNoStoneWall(new Position(0,1)));
    }
    @Test
    public void isNotEmptyNoStoneWallCaseMonster() {
        assertFalse(arena.isEmptyNoStoneWall(new Position(0,3)));
    }
    @Test
    public void isEmptySpawnFruit() {
        assertTrue(arena.isEmptySpawnFruit(new Position(0,0)));
    }
    @Test
    public void isNotEmptySpawnFruitCaseStoneWall() {
        assertFalse(arena.isEmptyNoStoneWall(new Position(0,1)));
    }
    @Test
    public void isEmptyNoStoneWallCaseMonster() {
        assertFalse(arena.isEmptyNoStoneWall(new Position(0,3)));
    }
}
