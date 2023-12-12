package badIceCream.model.utils;

import badIceCream.model.Position;
import badIceCream.model.game.arena.Arena;
import badIceCream.model.game.elements.IceCream;
import badIceCream.model.game.elements.StoneWall;
import badIceCream.model.game.elements.Wall;
import badIceCream.model.game.elements.fruits.BananaFruit;
import badIceCream.model.game.elements.monsters.Monster;
import badIceCream.model.game.elements.monsters.RunnerMonster;
import badIceCream.utils.ShortestPathNextMove;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

public class ShortestPathNextMoveTest {
    private Arena arena;
    @Mock
    private IceCream iceCream;
    @Mock
    private RunnerMonster runnerMonster;
    @Mock
    private StoneWall stoneWall1;
    @Mock
    private StoneWall stoneWall2;
    @Mock
    private StoneWall stoneWall3;
    @Mock
    private StoneWall stoneWall4;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        arena = new Arena(4,4);
        when(iceCream.getPosition()).thenReturn(new Position(0,0));
        arena.setIceCream(iceCream);
        when(runnerMonster.getPosition()).thenReturn(new Position(3,0));
        List<Monster> monsters = new ArrayList<>(List.of(runnerMonster));
        arena.setMonsters(monsters);
    }
    @Test
    public void findShortestPathNoWall(){
        List<Wall> walls = new ArrayList<>();
        arena.setWalls(walls);
        Position position = ShortestPathNextMove.findShortestPath(runnerMonster, arena);
        assertEquals(2, position.getX());
        assertEquals(0, position.getY());
    }
    /*@Test
    public void findShortestPathWall(){
        when(stoneWall1.getPosition()).thenReturn(new Position(2,0));
        when(stoneWall2.getPosition()).thenReturn(new Position(2,1));
        when(stoneWall3.getPosition()).thenReturn(new Position(2,2));
        List<Wall> walls = new ArrayList<>(Arrays.asList(stoneWall1,stoneWall2,stoneWall3));
        arena.setWalls(walls);
        Position position = ShortestPathNextMove.findShortestPath(runnerMonster, arena);
        assertEquals(3, position.getX());
        assertEquals(1, position.getY());
    }
    @Test
    public void findShortestPathBlocked(){
        when(stoneWall1.getPosition()).thenReturn(new Position(2,0));
        when(stoneWall2.getPosition()).thenReturn(new Position(2,1));
        when(stoneWall3.getPosition()).thenReturn(new Position(2,2));
        when(stoneWall4.getPosition()).thenReturn(new Position(2,3));
        List<Wall> walls = new ArrayList<>(Arrays.asList(stoneWall1,stoneWall2,stoneWall3, stoneWall4));
        arena.setWalls(walls);
        Position position = ShortestPathNextMove.findShortestPath(runnerMonster, arena);
        assertNull(position);
    }*/
}
