package badIceCream.controller.game;

import badIceCream.controller.game.monsters.RunnerMovementEnabled;
import badIceCream.controller.game.monsters.RunnerMovementDisabled;
import badIceCream.model.game.arena.Arena;
import badIceCream.model.game.elements.monsters.Monster;

import java.io.IOException;

public class MonsterController {
    Monster monster;
    private Step step;
    private long lastMovement;
    private long lastChange;
    private final Arena arena;
    boolean runnerOn;

    public MonsterController(Arena arena, Step step, Monster monster) {
        this.arena = arena;
        this.step = step;
        this.monster = monster;
        lastMovement = 0;
        lastChange = 0;
    }
    public void step(long time) throws IOException {

        if (monster.getType() == 3 && time - lastChange >= 10000) {
            runnerOn = !runnerOn;

            if (runnerOn) {
                this.step = new RunnerMovementEnabled();
            }
            else {
                this.step = new RunnerMovementDisabled();
            }
            lastChange = time;
        }

        this.step.step(monster, arena, time, lastMovement);
        lastMovement = time;
    }
}
