package badIceCream.controller.game;

import badIceCream.model.game.arena.Arena;
import badIceCream.controller.Controller;

public abstract class GameController extends Controller<Arena> {
    public GameController(Arena arena) {
        super(arena);
    }
}
