package org.example.controller.game.monsters;

import org.example.GUI.GUI;
import org.example.controller.game.MonsterController;
import org.example.model.Position;
import org.example.model.game.arena.Arena;
import org.example.model.game.elements.monsters.Monster;

import java.io.IOException;
import java.util.List;

public class DefaultController implements MonsterController {
    private final Arena arena;
    private long lastMovement;

    public DefaultController(Arena arena) {
        this.arena = arena; this.lastMovement = 0;
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

        options.removeIf(pos -> !arena.isEmpty(pos));

        if (options.isEmpty()) return null;

        java.util.Random random = new java.util.Random();
        int randomIndex = random.nextInt(options.size());

        return options.get(randomIndex);
    }

    @Override
    public void moveMonster(Monster monster, Position position) {
        monster.setPosition(position);
        if (arena.getIceCream().getPosition().equals(position))
            arena.getIceCream().changeAlive();

    }
}
