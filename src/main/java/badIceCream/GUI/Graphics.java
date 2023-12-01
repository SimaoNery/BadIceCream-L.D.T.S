package badIceCream.GUI;

import badIceCream.states.GameState;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import badIceCream.model.Position;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.googlecode.lanterna.terminal.swing.SwingTerminalFontConfiguration;

import java.awt.*;
import java.io.File;
import java.io.IOException;


public class Graphics {
    private GUI gui;

    public Graphics(GUI gui) throws IOException {
        this.gui = gui;
    }
    public GUI.ACTION getNextAction() throws IOException{
        return gui.getNextAction();
    }
    public GUI getGui(){
        return gui;
    }
    public void clear(){
        gui.clear();
    }

    public void refresh() throws IOException{
        gui.refresh();
    }

    public void close() throws IOException{
        gui.close();
    }
}
