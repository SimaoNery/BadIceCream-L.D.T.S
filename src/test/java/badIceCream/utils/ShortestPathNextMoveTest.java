package badIceCream.utils;

import badIceCream.model.Position;
import badIceCream.model.game.arena.Arena;
import badIceCream.model.game.elements.IceCream;
import badIceCream.model.game.elements.StoneWall;
import badIceCream.model.game.elements.Wall;
import badIceCream.model.game.elements.monsters.DefaultMonster;
import badIceCream.model.game.elements.monsters.Monster;
import badIceCream.model.game.elements.monsters.RunnerMonster;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

public class ShortestPathNextMoveTest {
    private ShortestPathNextMove shortestPathNextMove;
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
    @Mock
    private StoneWall stoneWall5;
    @Mock
    private StoneWall stoneWall6;
    @Mock
    private StoneWall stoneWall7;
    @Mock
    private StoneWall stoneWall8;
    @Mock
    private StoneWall stoneWall9;
    @Mock
    private StoneWall stoneWall10;
    @Mock
    private StoneWall stoneWall11;
    @Mock
    private StoneWall stoneWall12;
    @Mock
    private StoneWall stoneWall13;
    @Mock
    private StoneWall stoneWall14;
    @Mock
    private StoneWall stoneWall15;
    @Mock
    private StoneWall stoneWall16;
    @Mock
    private StoneWall stoneWall17;
    @Mock
    private StoneWall stoneWall18;
    @Mock
    private DefaultMonster defaultmonster;


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        this.shortestPathNextMove = new ShortestPathNextMove();
        arena = new Arena(5,5);
        when(stoneWall1.getPosition()).thenReturn(new Position(0,0));
        when(stoneWall2.getPosition()).thenReturn(new Position(1,0));
        when(stoneWall3.getPosition()).thenReturn(new Position(2,0));
        when(stoneWall4.getPosition()).thenReturn(new Position(3,0));
        when(stoneWall5.getPosition()).thenReturn(new Position(4,0));
        when(stoneWall6.getPosition()).thenReturn(new Position(0,1));
        when(stoneWall7.getPosition()).thenReturn(new Position(4,1));
        when(stoneWall8.getPosition()).thenReturn(new Position(0,2));
        when(stoneWall9.getPosition()).thenReturn(new Position(4,2));
        when(stoneWall10.getPosition()).thenReturn(new Position(0,3));
        when(stoneWall11.getPosition()).thenReturn(new Position(4,3));
        when(stoneWall12.getPosition()).thenReturn(new Position(0,4));
        when(stoneWall13.getPosition()).thenReturn(new Position(1,4));
        when(stoneWall14.getPosition()).thenReturn(new Position(2,4));
        when(stoneWall15.getPosition()).thenReturn(new Position(3,4));
        when(stoneWall16.getPosition()).thenReturn(new Position(4,4));
        when(iceCream.getPosition()).thenReturn(new Position(1,1));
        arena.setIceCream(iceCream);
        when(runnerMonster.getPosition()).thenReturn(new Position(3,1));
    }
    @Test
    public void findShortestPathNoWall(){
        List<Wall> walls = new ArrayList<>(Arrays.asList(stoneWall1, stoneWall2, stoneWall3,
                stoneWall4, stoneWall5, stoneWall6, stoneWall7, stoneWall8, stoneWall9,
                stoneWall10, stoneWall11, stoneWall12, stoneWall13, stoneWall14,
                stoneWall15, stoneWall16));
        arena.setWalls(walls);
        List<Monster> monsters = new ArrayList<>(List.of(runnerMonster));
        arena.setMonsters(monsters);
        Position position = shortestPathNextMove.findShortestPath(runnerMonster, arena);
        assertEquals(2, position.getX());
        assertEquals(1, position.getY());
    }
    @Test
    public void findShortestPathWallAndMonsters(){
        when(stoneWall17.getPosition()).thenReturn(new Position(2,1));
        List<Wall> walls = new ArrayList<>(Arrays.asList(stoneWall1, stoneWall2, stoneWall3,
                stoneWall4, stoneWall5, stoneWall6, stoneWall7, stoneWall8, stoneWall9,
                stoneWall10, stoneWall11, stoneWall12, stoneWall13, stoneWall14,
                stoneWall15, stoneWall16, stoneWall17));
        arena.setWalls(walls);
        when(defaultmonster.getPosition()).thenReturn(new Position(2,3));
        List<Monster> monsters = new ArrayList<>(List.of(runnerMonster, defaultmonster));
        arena.setMonsters(monsters);
        Position position = shortestPathNextMove.findShortestPath(runnerMonster, arena);
        assertEquals(3, position.getX());
        assertEquals(2, position.getY());
    }
    @Test
    public void findShortestPathBlocked(){
        when(stoneWall17.getPosition()).thenReturn(new Position(2,1));
        when(stoneWall18.getPosition()).thenReturn(new Position(2,2));
        List<Wall> walls = new ArrayList<>(Arrays.asList(stoneWall1, stoneWall2, stoneWall3,
                stoneWall4, stoneWall5, stoneWall6, stoneWall7, stoneWall8, stoneWall9,
                stoneWall10, stoneWall11, stoneWall12, stoneWall13, stoneWall14,
                stoneWall15, stoneWall16, stoneWall17, stoneWall18));
        arena.setWalls(walls);
        when(defaultmonster.getPosition()).thenReturn(new Position(2,3));
        List<Monster> monsters = new ArrayList<>(List.of(runnerMonster, defaultmonster));
        arena.setMonsters(monsters);
        Position position = shortestPathNextMove.findShortestPath(runnerMonster, arena);
        assertNull(position);
    }
}
