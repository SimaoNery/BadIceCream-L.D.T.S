package badIceCream.controller.MonsterMovements;

import badIceCream.GUI.GUI;
import badIceCream.controller.game.monsters.RunnerMovementDisabled;
import badIceCream.model.Position;
import badIceCream.model.game.arena.Arena;
import badIceCream.model.game.elements.IceCream;
import badIceCream.model.game.elements.monsters.Monster;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class RunnerMovementDisabledTest {
    private RunnerMovementDisabled runnerMovementDisabled;
    private Arena arena;
    private Monster monster;

    @BeforeEach
    void setUp() {
        runnerMovementDisabled = new RunnerMovementDisabled();
        arena = mock(Arena.class);
        monster = mock(Monster.class);
    }

    @Test
    void testMoveMonsterUpdatesPositionAndChecksIceCream() {
        Position newPosition = new Position(2, 2);
        when(arena.getIceCream()).thenReturn(mock(IceCream.class));
        when(arena.getIceCream().isStrawberryActive()).thenReturn(false);
        when(arena.getIceCream().getPosition()).thenReturn(newPosition);

        runnerMovementDisabled.moveMonster(monster, newPosition, arena);

        verify(monster, times(1)).setPosition(newPosition);
        verify(arena.getIceCream(), times(1)).isStrawberryActive();
        verify(arena.getIceCream(), times(1)).getPosition();
        verify(arena.getIceCream(), times(1)).changeAlive();
    }

    @Test
    void testStepDoesNotMoveMonsterBeforeInterval() throws IOException {
        long currentTime = 200L;
        long lastMovement = 100L;

        runnerMovementDisabled.step(monster, arena, currentTime, lastMovement);

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

        runnerMovementDisabled.step(monster, arena, currentTime, lastMovement);

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

        runnerMovementDisabled.moveMonster(monster, newPosition, arena);

        verify(monster, times(1)).setPosition(newPosition);
        verify(arena.getIceCream(), times(1)).isStrawberryActive();
        verify(arena.getIceCream(), never()).changeAlive();
    }

    @Test
    void testMoveMonsterLocked() throws IOException {
        Position newPosition = new Position(3, 2);
        when(arena.getIceCream()).thenReturn(mock(IceCream.class));
        when(arena.getIceCream().isStrawberryActive()).thenReturn(false);
        when(arena.getIceCream().getPosition()).thenReturn(new Position(1,2));
        when(monster.getPosition()).thenReturn(new Position(2,2));

        when(arena.isEmptyMonsters(any(Position.class))).thenReturn(false);

        runnerMovementDisabled.step(monster, arena, 500L, 200L);

        verify(monster, never()).setPosition(newPosition);
        verify(monster, never()).setLastAction(any(GUI.ACTION.class));;
    }

    @Test
    void testMoveMonsterUpdatesLeft() throws IOException {
        Position newPosition = new Position(1, 2);
        when(arena.getIceCream()).thenReturn(mock(IceCream.class));
        when(arena.getIceCream().getPosition()).thenReturn(new Position(5,5));
        when(monster.getPosition()).thenReturn(new Position(2,2));

        when(arena.isEmptyMonsters(newPosition)).thenReturn(true);

        runnerMovementDisabled.step(monster, arena, 500L, 200L);

        verify(monster, times(1)).setPosition(newPosition);
        verify(monster, times(1)).setLastAction(GUI.ACTION.LEFT);
        verify(arena.getIceCream(), times(1)).isStrawberryActive();
        verify(arena.getIceCream(), times(1)).getPosition();
        verify(arena.getIceCream(), never()).changeAlive();
    }

    @Test
    void testMoveMonsterUpdatesDown() throws IOException {
        Position newPosition = new Position(2, 3);
        when(arena.getIceCream()).thenReturn(mock(IceCream.class));
        when(arena.getIceCream().getPosition()).thenReturn(new Position(1,2));
        when(monster.getPosition()).thenReturn(new Position(2,2));

        when(arena.isEmptyMonsters(newPosition)).thenReturn(true);

        runnerMovementDisabled.step(monster, arena, 500L, 200L);

        verify(monster, times(1)).setPosition(newPosition);
        verify(monster, times(1)).setLastAction(GUI.ACTION.DOWN);
        verify(arena.getIceCream(), times(1)).isStrawberryActive();
        verify(arena.getIceCream(), times(1)).getPosition();
        verify(arena.getIceCream(), never()).changeAlive();
    }

    @Test
    void testMoveMonsterUpdatesUp() throws IOException {
        Position newPosition = new Position(2, 1);
        when(arena.getIceCream()).thenReturn(mock(IceCream.class));
        when(arena.getIceCream().getPosition()).thenReturn(new Position(1,2));
        when(monster.getPosition()).thenReturn(new Position(2,2));

        when(arena.isEmptyMonsters(newPosition)).thenReturn(true);

        runnerMovementDisabled.step(monster, arena, 500L, 200L);

        verify(monster, times(1)).setPosition(newPosition);
        verify(monster, times(1)).setLastAction(GUI.ACTION.UP);
        verify(arena.getIceCream(), times(1)).isStrawberryActive();
        verify(arena.getIceCream(), times(1)).getPosition();
        verify(arena.getIceCream(), never()).changeAlive();
    }

    @Test
    void testMoveMonsterUpdatesRight() throws IOException {
        Position newPosition = new Position(3, 2);
        when(arena.getIceCream()).thenReturn(mock(IceCream.class));
        when(arena.getIceCream().getPosition()).thenReturn(new Position(1,2));
        when(monster.getPosition()).thenReturn(new Position(2,2));

        when(arena.isEmptyMonsters(newPosition)).thenReturn(true);

        runnerMovementDisabled.step(monster, arena, 500L, 200L);

        verify(monster, times(1)).setPosition(newPosition);
        verify(monster, times(1)).setLastAction(GUI.ACTION.RIGHT);
        verify(arena.getIceCream(), times(1)).isStrawberryActive();
        verify(arena.getIceCream(), times(1)).getPosition();
        verify(arena.getIceCream(), never()).changeAlive();
    }
}
