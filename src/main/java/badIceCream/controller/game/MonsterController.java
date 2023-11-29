package badIceCream.controller.game;

import badIceCream.model.game.arena.Arena;
import badIceCream.model.game.elements.monsters.Monster;
import badIceCream.GUI.GUI;
import badIceCream.model.Position;

import java.io.IOException;

public class MonsterController {
    Monster monster;
    private Step step;
    private long lastMovement;

    private final int TIME_CONST;

    public MonsterController(Step step, Monster monster, int TIME_CONST) {
        this.step = step;
        this.monster = monster;
        this.TIME_CONST = TIME_CONST;
        lastMovement = 0;
    }
    public void step(GUI.ACTION action, long time) throws IOException {
        this.step.step(monster, action, time, TIME_CONST);
    }
    public void moveMonster(Position position) {
        this.step.moveMonster(monster, position);
    }
}
