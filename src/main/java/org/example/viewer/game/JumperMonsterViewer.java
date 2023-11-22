package org.example.viewer.game;

import org.example.GUI.GUI;
import org.example.model.game.elements.JumperMonster;

public class JumperMonsterViewer implements ElementViewer<JumperMonster>{
    @Override
    public void draw(JumperMonster jumperMonster, GUI gui){
        gui.drawMonster(jumperMonster.getPosition());
    }
}
