package badIceCream.controller.game.monsters;

import badIceCream.controller.game.MonsterController;
import badIceCream.model.game.arena.Arena;
import badIceCream.model.game.elements.monsters.Monster;
import badIceCream.GUI.GUI;
import badIceCream.model.Position;

import java.io.IOException;
import java.util.List;

public class DefaultController extends MonsterController {

    public DefaultController(Arena arena) {
        super(arena);
    }

    @Override
    public void step(Monster monster, GUI.ACTION action, long time) throws IOException {
        if (time - lastMovement >= 750) {
            Position pos = getPossible(monster);
            if (pos != null) moveMonster(monster, pos);
            lastMovement = time;
        }
    }

    private Position getPossible(Monster monster) {
        List<Position> options = new java.util.ArrayList<>(List.of(new Position[]{monster.getPosition().getDown(), monster.getPosition().getLeft(), monster.getPosition().getUp(), monster.getPosition().getRight()}));

        options.removeIf(pos -> !arena.isEmptyMonsters(pos));

        if (options.isEmpty()) return null;

        java.util.Random random = new java.util.Random();
        int randomIndex = random.nextInt(options.size());

        return options.get(randomIndex);
    }

    @Override
    protected void moveMonster(Monster monster, Position position) {
        monster.setPosition(position);
        if (arena.getIceCream().getPosition().equals(position))
            arena.getIceCream().changeAlive();

    }
}
