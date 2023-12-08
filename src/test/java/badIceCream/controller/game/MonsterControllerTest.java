package badIceCream.controller.game;

import badIceCream.Game;
import badIceCream.controller.game.ArenaController;
import badIceCream.controller.game.MonsterController;
import badIceCream.controller.game.StepMonsters;
import badIceCream.model.Position;
import badIceCream.model.game.arena.Arena;
import badIceCream.model.game.elements.IceCream;
import badIceCream.model.game.elements.monsters.Monster;
import badIceCream.states.State;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MonsterControllerTest {

    private Arena arena;
    private Game game;
    private IceCream iceCream;
    private StepMonsters step;
    private Monster monster;
    private MonsterController monsterController;

    @BeforeEach
    void setUp() {
        arena = mock(Arena.class);
        iceCream = mock(IceCream.class);
        step = mock(StepMonsters.class);
        monster = mock(Monster.class);
        when(iceCream.getPosition()).thenReturn(new Position(5, 5));
        when(monster.getPosition()).thenReturn(new Position(1, 2));
        when(arena.getIceCream()).thenReturn(iceCream);
        monsterController = new MonsterController(arena, step, monster);

        State state = mock(State.class);
        game = mock(Game.class);
        when(game.getState()).thenReturn(state);
    }

    @Test
    void testRunnerMonsterSwitchesMovement() throws IOException {
        when(monster.getType()).thenReturn(3);

        long time = System.currentTimeMillis();
        monsterController.step(time);

        verify(monster).startRunning();
    }

    @Test
    void testRunnerMonsterSwitchesMovementOff() throws IOException {
        when(monster.getType()).thenReturn(3);


        Field runnerOn = null;
        try {
            runnerOn = MonsterController.class.getDeclaredField("runnerOn");
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        runnerOn.setAccessible(true);
        try {
            runnerOn.set(monsterController, true);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }


        monsterController.step(System.currentTimeMillis());

        verify(monster, times(1)).stopRunning();
    }

    @Test
    void testStepMonster() throws IOException {
        long time = System.currentTimeMillis();
        monsterController.step(time);

        verify(step).step(monster, arena, time, 0);
    }
}
