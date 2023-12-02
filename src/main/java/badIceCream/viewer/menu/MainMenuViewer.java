package badIceCream.viewer.menu;

import badIceCream.GUI.GUI;
import badIceCream.GUI.Graphics;
import badIceCream.model.Position;
import badIceCream.model.menu.MainMenu;
import badIceCream.viewer.Viewer;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class MainMenuViewer extends Viewer<MainMenu> {
    public MainMenuViewer(MainMenu menu){
        super(menu);
    }

    private void drawTitle(Graphics gui) {
        String s0 = "                        ____                 _                                   ";
        String s1 = "                       |  _ \\              | |                                  ";
        String s2 = "                       | |_) |   __ _    __| |                                   ";
        String s3 = "                       |  _ <   / _` |  / _` |                                   ";
        String s4 = "                       | |_) | | (_| | | (_| |                                   ";
        String s5 = "                       |____/   \\__,_|  \\__,_|                                 ";
        String s6 = "                                                                                 ";
        String s7 = "                                                                                 ";
        String s8 = "  _____                           _____                                          ";
        String s9 = " |_   _|                         / ____|                                         ";
        String s10= "   | |     ___    ___    ______ | |       _ __    ___      __ _   _ __ ___       ";
        String s11= "   | |    / __|  / _ \\ |______|| |      | '__|  / _ \\   / _` | | '_ ` _ \\     ";
        String s12= "  _| |_  | (__  |  __/          | |____  | |    |  __/   | (_| | | | | | | |     ";
        String s13= " |_____| \\___| \\___|           \\_____||_|     \\___|  \\__,_| |_| |_| |_|     ";

        gui.drawText(new Position(25, 1), s0, "  #bb8fce  ");
        gui.drawText(new Position(25, 2), s1, "  #bb8fce  ");
        gui.drawText(new Position(25, 3), s2, "  #bb8fce  ");
        gui.drawText(new Position(25, 4), s3, "  #bb8fce  ");
        gui.drawText(new Position(25, 5), s4, "  #bb8fce  ");
        gui.drawText(new Position(25, 6), s5, "  #bb8fce  ");
        gui.drawText(new Position(25, 7), s6, " #f7dc6f ");
        gui.drawText(new Position(25, 8), s7, " #f7dc6f ");
        gui.drawText(new Position(25, 9), s8, " #f7dc6f ");
        gui.drawText(new Position(25, 10), s9, " #f7dc6f ");
        gui.drawText(new Position(25, 11), s10, " #f7dc6f ");
        gui.drawText(new Position(25, 12), s11, " #f7dc6f ");
        gui.drawText(new Position(25, 13), s12, " #f7dc6f ");
        gui.drawText(new Position(25, 14), s13, " #f7dc6f ");
    }
    @Override
    public void drawElements(Graphics gui) {
        drawTitle(gui);
        int heigth = 25;
        for(int i = 0; i < getModel().getNumberEntries(); i++){
            gui.drawText(new Position(15, heigth + i), getModel().getEntry(i), getModel().isSelected(i) ? "#D1D100" : "#FFFFFF" );
            heigth += 3;
        }
    }
}
