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
        String s0 = "                        ....                .                                     ";
        String s1 = "                       |  . \\              | |                                    ";
        String s2 = "                       | |.) |   .. .    ..| |                                    ";
        String s3 = "                       |  . <   / .` |  / .` |                                    ";
        String s4 = "                       | |.) | | (.| | | (.| |                                    ";
        String s5 = "                       |...../  \\..,.|  \\..,.|                                    ";
        String s6 = "                                                                                   ";
        String s7 = "                                                                                   ";
        String s8 = "  .....                            .....                                           ";
        String s9 = " |.   .|                          / ....|                                          ";
        String s10= "   | |     ...    ...    ......  | |       . ..    ...    .. .   . .. ...        ";
        String s11= "   | |    / ..|  / . \\  |......| | |      | '..|  / . \\  / .` | | '. ` . \\      ";
        String s12= "  .| |.  | (..  |  ../           | |....  | |    |  ../ | (.| | | | | | | |      ";
        String s13= " |.....|  \\...|  \\...|            \\.....| |.|     \\...|  \\..,.| |.| |.| |.|      ";

        gui.drawText(new Position(35, 1), s0, "  #f7dc6f  ");
        gui.drawText(new Position(35, 2), s1, "  #f7dc6f  ");
        gui.drawText(new Position(35, 3), s2, "  #f7dc6f  ");
        gui.drawText(new Position(35, 4), s3, "  #f7dc6f  ");
        gui.drawText(new Position(35, 5), s4, "  #f7dc6f  ");
        gui.drawText(new Position(35, 6), s5, "  #f7dc6f  ");
        gui.drawText(new Position(35, 7), s6, " #bb8fce ");
        gui.drawText(new Position(35, 8), s7, " #bb8fce ");
        gui.drawText(new Position(35, 9), s8, " #bb8fce ");
        gui.drawText(new Position(35, 10), s9, " #bb8fce ");
        gui.drawText(new Position(35, 11), s10, " #bb8fce ");
        gui.drawText(new Position(35, 12), s11, " #bb8fce ");
        gui.drawText(new Position(35, 13), s12, " #bb8fce ");
        gui.drawText(new Position(35, 14), s13, " #bb8fce ");
    }
    @Override
    public void drawElements(Graphics gui) {
        drawTitle(gui);
        int heigth = 20;
        for(int i = 0; i < getModel().getNumberEntries(); i++){
            gui.drawText(new Position(45, heigth + i), getModel().getEntry(i), getModel().isSelected(i) ? "#D1D100" : "#FFFFFF" );
            heigth += 3;
        }
    }
}
