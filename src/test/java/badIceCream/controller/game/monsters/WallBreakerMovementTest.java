package badIceCream.controller.game.monsters;

import badIceCream.GUI.GUI;
import badIceCream.model.Position;
import badIceCream.model.game.arena.Arena;
import badIceCream.model.game.elements.IceCream;
import badIceCream.model.game.elements.monsters.Monster;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class WallBreakerMovementTest {

    private WallBreakerMovement wallBreakerMovement;
    @Mock
    private Arena arena;
    @Mock
    private Monster monster;
    @Mock
    private IceCream iceCream;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        wallBreakerMovement = new WallBreakerMovement();
        when(arena.getIceCream()).thenReturn(iceCream);
    }

    @Test
    void testMoveMonsterUpdatesPositionAndChecksIceCream() {
        Position newPosition = new Position(2, 2);
        when(iceCream.getAlive()).thenReturn(false);
        when(iceCream.getPosition()).thenReturn(newPosition);

        wallBreakerMovement.moveMonster(monster, newPosition, arena);

        verify(monster, times(1)).setPosition(newPosition);
        verify(iceCream, times(1)).isStrawberryActive();
        verify(iceCream, times(1)).getPosition();
        verify(iceCream, times(1)).changeAlive();
    }

    @Test
    void testStepDoesNotMoveMonsterBeforeInterval() throws IOException {
        long currentTime = 299L;
        long lastMovement = 100L;

        wallBreakerMovement.step(monster, arena, currentTime, lastMovement);

        verify(monster, never()).setLastAction(any());
        verify(monster, never()).setPosition(any());
    }

    @Test
    void testStepMovesMonsterAfterInterval() throws IOException {
        IceCream mockedIceCream = mock(IceCream.class);
        when(mockedIceCream.getPosition()).thenReturn(new Position(2,2));
        when(mockedIceCream.isStrawberryActive()).thenReturn(true);
        when(arena.getIceCream()).thenReturn(mockedIceCream);
        when(arena.isEmptyNoStoneWall(any(Position.class))).thenReturn(true);
        when(monster.getPosition()).thenReturn(new Position(5,5));

        wallBreakerMovement.step(monster, arena, 400L, 200L);

        verify(monster, times(5)).getPosition();
        verify(monster, times(1)).setLastAction(any(GUI.ACTION.class));
        verify(arena, times(1)).getIceCream();
        verify(iceCream, never()).changeAlive();
    }

    @Test
    void testStepDestroyIceWall() throws IOException {
        IceCream mockedIceCream = mock(IceCream.class);
        when(mockedIceCream.getPosition()).thenReturn(new Position(5,5));
        when(mockedIceCream.isStrawberryActive()).thenReturn(false);

        when(arena.getIceCream()).thenReturn(mockedIceCream);
        when(arena.isEmptyNoStoneWall(new Position(1,2))).thenReturn(true);
        when(arena.isIceWall(new Position(1,2))).thenReturn(true);
        when(monster.getPosition()).thenReturn(new Position(2,2));

        wallBreakerMovement.step(monster, arena, 400L, 200L);

        verify(arena, times(1)).iceWallDestroyed(new Position(1,2));
        verify(monster, times(1)).setLastAction(GUI.ACTION.LEFT);
        verify(monster, times(1)).setPosition(new Position(1,2));
    }

    @Test
    void testStepMovesMonsterLeft() throws IOException {
        IceCream mockedIceCream = mock(IceCream.class);
        when(mockedIceCream.getPosition()).thenReturn(new Position(5,5));

        when(arena.getIceCream()).thenReturn(mockedIceCream);
        when(arena.isEmptyNoStoneWall(new Position(1,2))).thenReturn(true);
        when(monster.getPosition()).thenReturn(new Position(2,2));

        wallBreakerMovement.step(monster, arena, 400L, 200L);

        verify(monster, times(1)).setLastAction(GUI.ACTION.LEFT);
        verify(monster, times(1)).setPosition(new Position(1,2));
        verify(iceCream, never()).changeAlive();
    }

    @Test
    void testStepMovesMonsterRight() throws IOException {
        IceCream mockedIceCream = mock(IceCream.class);
        when(mockedIceCream.getPosition()).thenReturn(new Position(5,5));

        when(arena.getIceCream()).thenReturn(mockedIceCream);
        when(arena.isEmptyNoStoneWall(new Position(3,2))).thenReturn(true);
        when(monster.getPosition()).thenReturn(new Position(2,2));

        wallBreakerMovement.step(monster, arena, 400L, 200L);

        verify(monster, times(1)).setLastAction(GUI.ACTION.RIGHT);
        verify(monster, times(1)).setPosition(new Position(3,2));
        verify(iceCream, never()).changeAlive();
    }

    @Test
    void testStepMovesMonsterUp() throws IOException {
        IceCream mockedIceCream = mock(IceCream.class);
        when(mockedIceCream.getPosition()).thenReturn(new Position(5,5));

        when(arena.getIceCream()).thenReturn(mockedIceCream);
        when(arena.isEmptyNoStoneWall(new Position(2,1))).thenReturn(true);
        when(monster.getPosition()).thenReturn(new Position(2,2));

        wallBreakerMovement.step(monster, arena, 400L, 200L);

        verify(monster, times(1)).setLastAction(GUI.ACTION.UP);
        verify(monster, times(1)).setPosition(new Position(2,1));
        verify(iceCream, never()).changeAlive();
    }

    @Test
    void testStepMovesMonsterDown() throws IOException {
        IceCream mockedIceCream = mock(IceCream.class);
        when(mockedIceCream.getPosition()).thenReturn(new Position(5,5));

        when(arena.getIceCream()).thenReturn(mockedIceCream);
        when(arena.isEmptyNoStoneWall(new Position(2,3))).thenReturn(true);
        when(monster.getPosition()).thenReturn(new Position(2,2));

        wallBreakerMovement.step(monster, arena, 400L, 200L);

        verify(monster, times(1)).setLastAction(GUI.ACTION.DOWN);
        verify(monster, times(1)).setPosition(new Position(2,3));
        verify(iceCream, never()).changeAlive();
    }
}
