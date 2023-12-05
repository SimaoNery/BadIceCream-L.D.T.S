package badIceCream.controller;

import badIceCream.GUI.GUI;
import badIceCream.controller.game.monsters.DefaultMovement;
import badIceCream.model.Position;
import badIceCream.model.game.arena.Arena;
import badIceCream.model.game.elements.IceCream;
import badIceCream.model.game.elements.monsters.Monster;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class DefaultMovementTest {
    private DefaultMovement defaultMovement;
    private Arena arena;
    private Monster monster;

    @BeforeEach
    void setUp() {
        defaultMovement = new DefaultMovement();
        arena = mock(Arena.class);
        monster = mock(Monster.class);
    }

    @Test
    void testMoveMonsterUpdatesPositionAndChecksIceCream() {
        Position newPosition = new Position(2, 2);
        when(arena.getIceCream()).thenReturn(mock(IceCream.class));
        when(arena.getIceCream().isStrawberryActive()).thenReturn(false);
        when(arena.getIceCream().getPosition()).thenReturn(newPosition);

        defaultMovement.moveMonster(monster, newPosition, arena);

        verify(monster, times(1)).setPosition(newPosition);
        verify(arena.getIceCream(), times(1)).isStrawberryActive();
        verify(arena.getIceCream(), times(1)).getPosition();
        verify(arena.getIceCream(), times(1)).changeAlive();
    }

    @Test
    void testStepDoesNotMoveMonsterBeforeInterval() throws IOException {
        long currentTime = 200L;
        long lastMovement = 100L;

        defaultMovement.step(monster, arena, currentTime, lastMovement);

        verify(monster, never()).setLastAction(any());
        verify(monster, never()).setPosition(any());
    }

    @Test
    void testStepMovesMonsterAfterInterval() throws IOException {
        IceCream mockedIceCream = mock(IceCream.class);
        when(mockedIceCream.getPosition()).thenReturn(new Position(1,1));
        when(mockedIceCream.isStrawberryActive()).thenReturn(true);
        when(arena.getIceCream()).thenReturn(mockedIceCream);
        long currentTime = 500L;
        long lastMovement = 200L;
        when(monster.getPosition()).thenReturn(new Position(1, 1));
        when(arena.isEmptyMonsters(any())).thenReturn(true);

        defaultMovement.step(monster, arena, currentTime, lastMovement);

        verify(monster, times(1)).setLastAction(any());
        verify(monster, times(1)).setPosition(any());
        verify(arena, times(1)).getIceCream();
        verify(arena.getIceCream(), never()).changeAlive();
    }

    @Test
    void testMoveMonsterUpdatesPositionAndChecksIceCreamStrawberryOn() {
        Position newPosition = new Position(2, 2);
        IceCream mockedIceCream = mock(IceCream.class);
        when(mockedIceCream.getPosition()).thenReturn(new Position(2,2));
        when(mockedIceCream.isStrawberryActive()).thenReturn(true);
        when(arena.getIceCream()).thenReturn(mockedIceCream);

        defaultMovement.moveMonster(monster, newPosition, arena);

        verify(monster, times(1)).setPosition(newPosition);
        verify(arena.getIceCream(), times(1)).isStrawberryActive();
        verify(arena.getIceCream(), never()).changeAlive();
    }

    @Test
    void testMoveMonsterUpdatesLeft() throws IOException {
        Position newPosition = new Position(1, 2);
        when(arena.getIceCream()).thenReturn(mock(IceCream.class));
        when(arena.getIceCream().isStrawberryActive()).thenReturn(false);
        when(arena.getIceCream().getPosition()).thenReturn(new Position(1,2));
        when(monster.getPosition()).thenReturn(new Position(2,2));

        when(arena.isEmptyMonsters(newPosition)).thenReturn(true);

        defaultMovement.step(monster, arena, 500L, 200L);

        verify(monster, times(1)).setPosition(newPosition);
        verify(monster, times(1)).setLastAction(any());
        verify(arena.getIceCream(), times(1)).isStrawberryActive();
        verify(arena.getIceCream(), times(1)).getPosition();
    }

    @Test
    void testMoveMonsterUpdatesDown() throws IOException {
        Position newPosition = new Position(2, 3);
        when(arena.getIceCream()).thenReturn(mock(IceCream.class));
        when(arena.getIceCream().isStrawberryActive()).thenReturn(false);
        when(arena.getIceCream().getPosition()).thenReturn(new Position(1,2));
        when(monster.getPosition()).thenReturn(new Position(2,2));

        when(arena.isEmptyMonsters(newPosition)).thenReturn(true);

        defaultMovement.step(monster, arena, 500L, 200L);

        verify(monster, times(1)).setPosition(newPosition);
        verify(monster, times(1)).setLastAction(any());
        verify(arena.getIceCream(), times(1)).isStrawberryActive();
        verify(arena.getIceCream(), times(1)).getPosition();
    }

    @Test
    void testMoveMonsterUpdatesUp() throws IOException {
        Position newPosition = new Position(2, 1);
        when(arena.getIceCream()).thenReturn(mock(IceCream.class));
        when(arena.getIceCream().isStrawberryActive()).thenReturn(false);
        when(arena.getIceCream().getPosition()).thenReturn(new Position(1,2));
        when(monster.getPosition()).thenReturn(new Position(2,2));

        when(arena.isEmptyMonsters(newPosition)).thenReturn(true);

        defaultMovement.step(monster, arena, 500L, 200L);

        verify(monster, times(1)).setPosition(newPosition);
        verify(monster, times(1)).setLastAction(any());
        verify(arena.getIceCream(), times(1)).isStrawberryActive();
        verify(arena.getIceCream(), times(1)).getPosition();
    }

    @Test
    void testMoveMonsterUpdatesRight() throws IOException {
        Position newPosition = new Position(3, 2);
        when(arena.getIceCream()).thenReturn(mock(IceCream.class));
        when(arena.getIceCream().isStrawberryActive()).thenReturn(false);
        when(arena.getIceCream().getPosition()).thenReturn(new Position(1,2));
        when(monster.getPosition()).thenReturn(new Position(2,2));

        when(arena.isEmptyMonsters(newPosition)).thenReturn(true);

        defaultMovement.step(monster, arena, 500L, 200L);

        verify(monster, times(1)).setPosition(newPosition);
        verify(monster, times(1)).setLastAction(any());
        verify(arena.getIceCream(), times(1)).isStrawberryActive();
        verify(arena.getIceCream(), times(1)).getPosition();
    }

}
