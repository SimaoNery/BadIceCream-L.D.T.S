package org.example.viewer.game;

import org.example.GUI.GUI;
import org.example.model.game.elements.WallBreakerMonster;

public class WallBreakerMonsterViewer implements ElementViewer<WallBreakerMonster>{
    public void draw(WallBreakerMonster wallBreakerMonster, GUI gui){
        gui.drawMonster(wallBreakerMonster.getPosition());
    }
}
