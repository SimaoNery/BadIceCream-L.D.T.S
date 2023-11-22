package org.example.viewer.game;

import org.example.GUI.GUI;
import org.example.model.game.elements.monsters.Monster;

public class MonsterViewer implements ElementViewer<Monster>{
    @Override
    public void draw(Monster monster, GUI gui){
        switch (monster.getType()) {
            case 1: gui.drawDefaultMonster(monster.getPosition());
                break;
            case 2: gui.drawJumperMonster(monster.getPosition());
                break;
            case 3: gui.drawRunnerMonster(monster.getPosition());
                break;
            case 4: gui.drawWallBreakerMonster(monster.getPosition());
                break;
        }
    }
}
