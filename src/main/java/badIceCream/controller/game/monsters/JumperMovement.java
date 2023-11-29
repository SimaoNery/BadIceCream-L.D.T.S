package badIceCream.controller.game.monsters;

import badIceCream.controller.game.Step;
import badIceCream.model.Position;
import badIceCream.model.game.arena.Arena;
import badIceCream.model.game.elements.monsters.Monster;

import java.io.IOException;
import java.util.List;

public class JumperMovement implements Step {
    @Override
    public void step(Monster monster, Arena arena, long time, long lastMovement) throws IOException {
        if (time - lastMovement >= 200) {
            Position pos = getPossible(monster, arena);
            if (pos != null) moveMonster(monster, pos, arena);
        }
    }

    private Position getPossible(Monster monster, Arena arena) {
        List<Position> options = new java.util.ArrayList<>(List.of(new Position[]{monster.getPosition().getDown(), monster.getPosition().getLeft(), monster.getPosition().getUp(), monster.getPosition().getRight()}));

        options.removeIf(pos -> !arena.isEmptyNoStoneWall(pos));

        if (options.isEmpty()) return null;

        java.util.Random random = new java.util.Random();
        int randomIndex = random.nextInt(options.size());

        return options.get(randomIndex);
    }

    @Override
    public void moveMonster(Monster monster, Position position, Arena arena) {
        monster.setPosition(position);
        if (arena.getIceCream().getPosition().equals(position))
            arena.getIceCream().changeAlive();
    }
}
