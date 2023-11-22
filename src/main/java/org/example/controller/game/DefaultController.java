package org.example.controller.game;

import org.example.GUI.GUI;
import org.example.model.Position;
import org.example.model.game.elements.monsters.Monster;

import java.io.IOException;

public class DefaultController {
    private long lastMovement;

    public DefaultController() {
        this.lastMovement = 0;
    }

    public void step(Monster monster, GUI.ACTION action, long time) throws IOException {

    }

    private void moveMonster(Monster monster, Position position) {

    }
}
