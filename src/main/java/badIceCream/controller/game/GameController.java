package badIceCream.controller.game;

import badIceCream.model.game.arena.Arena;
import badIceCream.controller.Controller;

public abstract class GameController extends Controller<Arena> {
    protected int level;
    public GameController(Arena arena, int level) {
        super(arena);
        this.level = level;
    }
}
