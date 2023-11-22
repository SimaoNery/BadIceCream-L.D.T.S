package org.example.viewer.game;

import org.example.GUI.GUI;
import org.example.model.game.elements.monsters.DefaultMonster;

public class DefaultMonsterViewer implements  ElementViewer<DefaultMonster>{
    @Override
    public void draw(DefaultMonster defaultMonster, GUI gui){
        gui.drawMonster(defaultMonster.getPosition());
    }
}
