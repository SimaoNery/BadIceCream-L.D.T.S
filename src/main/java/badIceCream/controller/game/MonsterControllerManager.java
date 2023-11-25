package badIceCream.controller.game;

import badIceCream.Game;
import badIceCream.controller.game.monsters.DefaultController;
import badIceCream.controller.game.monsters.JumperController;
import badIceCream.controller.game.monsters.RunnerController;
import badIceCream.controller.game.monsters.WallBreakerController;
import badIceCream.model.game.arena.Arena;
import badIceCream.model.game.elements.monsters.*;
import badIceCream.GUI.GUI;

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
