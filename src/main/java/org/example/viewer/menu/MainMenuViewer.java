package org.example.viewer.menu;

import org.example.GUI.GUI;
import org.example.model.Position;
import org.example.model.menu.MainMenu;
import org.example.viewer.Viewer;

public class MainMenuViewer extends Viewer<MainMenu> {
    public MainMenuViewer(MainMenu menu){
        super(menu);
    }
    @Override
    public void drawElements(GUI gui){
        gui.drawText(new Position(5, 5), "Menu", "#FFFFFF");

        for(int i = 0; i < getModel().getNumberEntries(); i++){
            gui.drawText(new Position(5, 7 + i), getModel().getEntry(i), getModel().isSelected(i) ? "#D1D100" : "#FFFFFF" );
        }
    }
}
