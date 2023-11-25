package badIceCream.controller.game;

import badIceCream.model.game.arena.Arena;
import badIceCream.model.game.elements.monsters.Monster;
import badIceCream.GUI.GUI;
import badIceCream.model.Position;

import java.io.IOException;

public abstract class MonsterController {
    protected final Arena arena;
    protected long lastMovement;

    public MonsterController(Arena arena) {
        this.arena = arena;
        lastMovement = 0;
    }
    public abstract void step(Monster monster, GUI.ACTION action, long time) throws IOException;
    protected abstract void moveMonster(Monster monster, Position position);
}
