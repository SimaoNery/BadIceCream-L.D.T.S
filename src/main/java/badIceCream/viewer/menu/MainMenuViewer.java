package badIceCream.viewer.menu;

import badIceCream.GUI.GUI;
import badIceCream.GUI.Graphics;
import badIceCream.model.Position;
import badIceCream.model.menu.MainMenu;
import badIceCream.viewer.Viewer;

public class MainMenuViewer extends Viewer<MainMenu> {
    public MainMenuViewer(MainMenu menu){
        super(menu);
    }
    @Override
    public void drawElements(Graphics gui){
        gui.drawText(new Position(5, 5), "Menu", "#FFFFFF");

        for(int i = 0; i < getModel().getNumberEntries(); i++){
            gui.drawText(new Position(5, 7 + i), getModel().getEntry(i), getModel().isSelected(i) ? "#D1D100" : "#FFFFFF" );
        }
    }
}
