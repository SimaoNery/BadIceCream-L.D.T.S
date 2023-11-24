package org.example.controller.game;

import org.example.GUI.GUI;
import org.example.model.Position;
import org.example.model.game.arena.Arena;
import org.example.model.game.elements.monsters.Monster;

import java.io.IOException;

public class JumperController implements MonsterController {
    private final Arena arena;
    private long lastMovement;

    public JumperController(Arena arena) {
        this.arena = arena;
        this.lastMovement = 0;
    }

    @Override
    public void step(Monster monster, GUI.ACTION action, long time) throws IOException {
        if (time - lastMovement >= 500) {
            moveMonster(monster, new Position(1, 1));
            lastMovement = time;
        }
    }

    @Override
    public void moveMonster(Monster monster, Position position) {
        if (arena.isEmpty(position)) {
            monster.setPosition(position);
            if (arena.getIceCream().getPosition().equals(position))
                arena.getIceCream().changeAlive();
        }
    }
}
