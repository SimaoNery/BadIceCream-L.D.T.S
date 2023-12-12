package badIceCream.controller.game;

import badIceCream.GUI.Graphics;
import badIceCream.Game;
import badIceCream.model.Position;
import badIceCream.model.game.arena.Arena;
import badIceCream.model.game.elements.IceCream;
import badIceCream.model.game.elements.monsters.Monster;
import badIceCream.states.State;
import badIceCream.utils.Audio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.io.IOException;
import java.lang.reflect.Field;
import static org.mockito.Mockito.*;

public class MonsterControllerTest {
    @Mock
    private Arena arena;
    @Mock
    private Game game;
    @Mock
    private IceCream iceCream;
    @Mock
    private StepMonsters step;
    @Mock
    private Monster monster;
    @Mock
    private State state;
    @Mock
    private Graphics graphics;
    @Mock
    private Audio audio;
    private MonsterController monsterController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        when(iceCream.getPosition()).thenReturn(new Position(5, 5));
        when(monster.getPosition()).thenReturn(new Position(1, 2));
        when(arena.getIceCream()).thenReturn(iceCream);
        monsterController = new MonsterController(arena, step, monster);
        when(game.getState()).thenReturn(state);
        game.setAll(state, graphics, audio);
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


        Field runnerOn;
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
