package org.example.controller.game;

import org.example.GUI.GUI;
import org.example.model.Position;
import org.example.model.game.elements.monsters.Monster;

import java.io.IOException;

public interface MonsterController {
    void step(Monster monster, GUI.ACTION action, long time) throws IOException;
    void moveMonster(Monster monster, Position position);
}
