package badIceCream.viewer;

import badIceCream.GUI.GUI;
import badIceCream.GUI.Graphics;
import badIceCream.model.Position;
import badIceCream.model.game.elements.monsters.DefaultMonster;
import badIceCream.model.game.elements.monsters.JumperMonster;
import badIceCream.model.game.elements.monsters.RunnerMonster;
import badIceCream.model.game.elements.monsters.WallBreakerMonster;
import badIceCream.viewer.MonsterViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class MonsterViewerTest {
    private MonsterViewer viewer;
    @Mock
    private Graphics graphics;
    @Mock
    private Position position;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);

        viewer = new MonsterViewer();
    }

    @Test
    void drawDefaultMonster(){
        DefaultMonster defaultMonster = mock(DefaultMonster.class);
        when(defaultMonster.getPosition()).thenReturn(position);
        when(defaultMonster.getLastAction()).thenReturn(GUI.ACTION.UP);

        viewer.draw(defaultMonster, graphics, 1);
        verify(graphics, times(1)).drawDefaultMonster(position, GUI.ACTION.UP);
    }

    @Test
    void drawJumperMonster(){
        JumperMonster jumperMonster = mock(JumperMonster.class);
        when(jumperMonster.getPosition()).thenReturn(position);
        when(jumperMonster.getLastAction()).thenReturn(GUI.ACTION.UP);

        viewer.draw(jumperMonster, graphics, 2);
        verify(graphics, times(1)).drawJumperMonster(position, GUI.ACTION.UP);
    }

    @Test
    void drawRunnerMonsterNotRunning(){
        RunnerMonster runnerMonsterNotRunning = mock(RunnerMonster.class);
        when(runnerMonsterNotRunning.getPosition()).thenReturn(position);
        when(runnerMonsterNotRunning.getLastAction()).thenReturn(GUI.ACTION.UP);
        when(runnerMonsterNotRunning.isRunning()).thenReturn(false);

        viewer.draw(runnerMonsterNotRunning, graphics, 3);
        verify(graphics, times(1)).drawRunnerMonster(position, GUI.ACTION.UP, false);
    }

    @Test
    void drawRunnerMonsterRunning(){
        RunnerMonster runnerMonsterRunning = mock(RunnerMonster.class);
        when(runnerMonsterRunning.getPosition()).thenReturn(position);
        when(runnerMonsterRunning.getLastAction()).thenReturn(GUI.ACTION.UP);
        when(runnerMonsterRunning.isRunning()).thenReturn(true);

        viewer.draw(runnerMonsterRunning, graphics, 3);
        verify(graphics, times( 1)).drawRunnerMonster(position, GUI.ACTION.UP, true);
    }

    @Test
    void drawWallBreakerMonster(){
        WallBreakerMonster wallBreakerMonster = mock(WallBreakerMonster.class);
        when(wallBreakerMonster.getPosition()).thenReturn(position);
        when(wallBreakerMonster.getLastAction()).thenReturn(GUI.ACTION.UP);

        viewer.draw(wallBreakerMonster, graphics, 4);
        verify(graphics, times( 1)).drawWallBreakerMonster(position, GUI.ACTION.UP);
    }
}
