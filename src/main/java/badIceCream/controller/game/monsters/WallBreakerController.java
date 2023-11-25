package badIceCream.controller.game.monsters;

import badIceCream.controller.game.MonsterController;
import badIceCream.model.game.arena.Arena;
import badIceCream.model.game.elements.monsters.Monster;
import badIceCream.GUI.GUI;
import badIceCream.model.Position;


import java.io.IOException;

public class WallBreakerController extends MonsterController {

    public WallBreakerController(Arena arena) {
        super(arena);
    }
    @Override
    public void step(Monster monster, GUI.ACTION action, long time) throws IOException {
        if (time - lastMovement >= 500) {
            moveMonster(monster, new Position(1,1));
            lastMovement = time;
        }
    }

    @Override
    protected void moveMonster(Monster monster, Position position) {
        if (arena.isEmpty(position)) {
            monster.setPosition(position);
            if (arena.getIceCream().getPosition().equals(position))
                arena.getIceCream().changeAlive();
        }
    }
}
