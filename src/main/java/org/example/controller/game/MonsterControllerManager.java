package org.example.controller.game;

import org.example.GUI.GUI;
import org.example.Game;
import org.example.controller.game.monsters.DefaultController;
import org.example.controller.game.monsters.JumperController;
import org.example.controller.game.monsters.RunnerController;
import org.example.controller.game.monsters.WallBreakerController;
import org.example.model.game.arena.Arena;
import org.example.model.game.elements.monsters.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MonsterControllerManager extends GameController {
    private final Map<Class<? extends Monster>, MonsterController> monsterControllerMap = new HashMap<>();

    public MonsterControllerManager(Arena arena) {
        super(arena);
        monsterControllerMap.put(DefaultMonster.class, new DefaultController(arena));
        monsterControllerMap.put(JumperMonster.class, new JumperController(arena));
        monsterControllerMap.put(RunnerMonster.class, new RunnerController(arena));
        monsterControllerMap.put(WallBreakerMonster.class, new WallBreakerController(arena));
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        for (Monster monster : getModel().getMonsters()) {
            MonsterController controller = getControllerForMonster(monster);
            controller.step(monster, action, time);
        }
    }

    private MonsterController getControllerForMonster(Monster monster) {
        return monsterControllerMap.get(monster.getClass());
    }

}
