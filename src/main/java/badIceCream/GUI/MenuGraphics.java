package badIceCream.GUI;

import badIceCream.model.Position;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.googlecode.lanterna.terminal.swing.SwingTerminalFontConfiguration;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MenuGraphics extends GUI {

    public MenuGraphics(int width, int height) throws IOException {
        Terminal terminal = createTerminal(width, height);
        this.screen = createScreen(terminal);
    }

    public MenuGraphics(Screen screen) {
        this.screen = screen;
    }

    protected Terminal createTerminal(int width, int height) throws IOException{
        try {
            String rootPath = new File(System.getProperty("user.dir")).getPath();
            String mapLocation = rootPath + "/src/main/resources/FontForge/TowerofSilence.otf";
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File(mapLocation));
            font = font.deriveFont(Font.PLAIN, 16);
            AWTTerminalFontConfiguration cfg = new SwingTerminalFontConfiguration(true, AWTTerminalFontConfiguration.BoldMode.NOTHING, font);

            return new DefaultTerminalFactory().setInitialTerminalSize(new TerminalSize(width, height)).setTerminalEmulatorFontConfiguration(cfg).createTerminal();
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
            throw new IOException("Error creating terminal with custom font.", e);
        }
    }
}
