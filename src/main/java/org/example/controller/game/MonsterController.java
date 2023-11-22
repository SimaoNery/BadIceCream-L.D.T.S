package org.example.controller.game;

import org.example.GUI.GUI;
import org.example.Game;
import org.example.model.game.arena.Arena;
import org.example.model.game.elements.monsters.Monster;

import java.io.IOException;

public class MonsterController extends GameController {
    private final DefaultController defaultController;
    private final JumperController jumperController;
    private final RunnerController runnerController;
    private final WallBreakerController wallBreakerController;
    private long lastMovement;

    public MonsterController(Arena arena) {
        super(arena);
        defaultController = new DefaultController();
        jumperController = new JumperController();
        runnerController = new RunnerController();
        wallBreakerController = new WallBreakerController();
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        for (Monster monster : getModel().getMonsters()) {
            final int type = monster.getType();

            switch (type) {
                case 1: defaultController.step(monster, action, time);
                case 2: jumperController.step(monster, action, time);
                case 3: runnerController.step(monster, action, time);
                case 4: wallBreakerController.step(monster, action, time);
            }
        }
    }

}
