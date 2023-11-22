package org.example.viewer.game;

import org.example.GUI.GUI;
import org.example.model.game.elements.monsters.RunnerMonster;

public class RunnerMonsterViewer implements ElementViewer<RunnerMonster>{
    public void draw(RunnerMonster runnerMonster, GUI gui){
        gui.drawMonster(runnerMonster.getPosition());
    }
}
