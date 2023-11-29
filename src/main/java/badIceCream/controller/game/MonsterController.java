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
    private final Arena arena;
    private final int TIME_CONST;

    public MonsterController(Arena arena, Step step, Monster monster, int TIME_CONST) {
        this.arena = arena;
        this.step = step;
        this.monster = monster;
        this.TIME_CONST = TIME_CONST;
        lastMovement = 0;
    }
    public void step(long time) throws IOException {
        if (time - lastMovement >= TIME_CONST) {
            this.step.step(monster, arena);
            lastMovement = time;
        }
    }
    public void setStep(Step step) {
        this.step = step;
    }
}
