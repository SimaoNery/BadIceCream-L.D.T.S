package badIceCream.Viewer;

import badIceCream.model.game.elements.monsters.*;
import badIceCream.GUI.GUI;
import badIceCream.viewer.game.MonsterViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class MonsterViewerTest {
    private List<Monster> monsters;
    private MonsterViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        monsters = Arrays.asList(
                new DefaultMonster(1, 2), new DefaultMonster(1, 3),
                new JumperMonster(1, 4), new JumperMonster(1, 5),
                new RunnerMonster(1, 6), new RunnerMonster(1, 7),
                new WallBreakerMonster(1, 8), new WallBreakerMonster(1, 9));

        viewer = new MonsterViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawWalls() throws IOException {
        for(Monster monster : monsters){
            viewer.draw(monster, gui);

            switch (monster.getType()){
                case 1: Mockito.verify(gui, Mockito.times(1)).drawDefaultMonster(monster.getPosition());
                    break;
                case 2: Mockito.verify(gui, Mockito.times(1)).drawJumperMonster(monster.getPosition());
                    break;
                case 3: Mockito.verify(gui, Mockito.times(1)).drawRunnerMonster(monster.getPosition());
                    break;
                case 4:Mockito.verify(gui, Mockito.times(1)).drawWallBreakerMonster(monster.getPosition());
                    break;
            }

        }
    }
}
