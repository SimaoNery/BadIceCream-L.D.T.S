package badIceCream.GUI;

import badIceCream.model.Position;
import badIceCream.model.game.arena.Arena;
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

public class GameGraphics implements GUI{
    private Screen screen;
    public GameGraphics(int width, int height) throws IOException{
        Terminal terminal = createGameTerminal(width, height);
        this.screen = createScreen(terminal);
    }

    private Terminal createGameTerminal(int width, int height) throws IOException {
        try {
            String rootPath = new File(System.getProperty("user.dir")).getPath();
            String mapLocation = rootPath + "/src/main/resources/FontForge/Untitled1.otf";
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File(mapLocation));
            font = font.deriveFont(Font.PLAIN, 35);
            AWTTerminalFontConfiguration cfg = new SwingTerminalFontConfiguration(true, AWTTerminalFontConfiguration.BoldMode.NOTHING, font);
            Terminal gameTerminal = new DefaultTerminalFactory().setInitialTerminalSize(new TerminalSize(width, height)).setTerminalEmulatorFontConfiguration(cfg).createTerminal();

            return gameTerminal;
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
            throw new IOException("Error creating terminal with custom font.", e);
        }
    }

    private Screen createScreen(Terminal terminal) throws IOException{
        final Screen screen;
        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        return screen;
    }

    @Override
    public void drawCharacter(int a, int b, char c, String color) {
        TextGraphics textGraphics = screen.newTextGraphics();
        textGraphics.setForegroundColor(TextColor.Factory.fromString(color));
        textGraphics.putString(a, b, "" + c);
    }
    @Override
    public ACTION getNextAction() throws IOException{
        KeyStroke keyStroke = screen.pollInput();

        if(keyStroke == null) return ACTION.NONE;
        if(keyStroke.getKeyType() == KeyType.ArrowDown) return ACTION.DOWN;
        if(keyStroke.getKeyType() == KeyType.ArrowUp) return ACTION.UP;
        if(keyStroke.getKeyType() == KeyType.ArrowRight) return ACTION.RIGHT;
        if(keyStroke.getKeyType() == KeyType.ArrowLeft) return ACTION.LEFT;
        if(keyStroke.getKeyType() == KeyType.Escape) return ACTION.PAUSE;
        if(keyStroke.getCharacter() == ' ') return ACTION.SPACE;

        return ACTION.NONE;
    }

    @Override
    public void drawText(Position position, String text, String color){
        TextGraphics textGraphics = screen.newTextGraphics();
        textGraphics.setForegroundColor(TextColor.Factory.fromString(color));
        textGraphics.putString(position.getX(), position.getY(), text);
    }

    public void clear(){
        screen.clear();
    }

    public void refresh() throws IOException{
        screen.refresh();
    }

    public void close() throws IOException{
        screen.close();
    }
}
