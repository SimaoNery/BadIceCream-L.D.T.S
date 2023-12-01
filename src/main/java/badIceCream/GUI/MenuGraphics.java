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

import java.io.IOException;

public class MenuGraphics implements GUI {
    private Screen screen;

    public MenuGraphics(int width, int height) throws IOException {
        Terminal terminal = createMenuTerminal(width, height);
        this.screen = createScreen(terminal);
    }

    private Terminal createMenuTerminal(int width, int height) throws IOException{
        TerminalSize terminalSize = new TerminalSize(width, height);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        Terminal menuTerminal = terminalFactory.createTerminal();
        return menuTerminal;
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
    public void drawText(Position position, String text, String color){
        TextGraphics textGraphics = screen.newTextGraphics();
        textGraphics.setForegroundColor(TextColor.Factory.fromString(color));
        textGraphics.putString(position.getX(), position.getY(), text);
    }

    @Override
    public GUI.ACTION getNextAction() throws IOException{
        KeyStroke keyStroke = screen.pollInput();
        if(keyStroke == null) return GUI.ACTION.NONE;

        if(keyStroke.getKeyType() == KeyType.ArrowDown) return GUI.ACTION.DOWN;
        if(keyStroke.getKeyType() == KeyType.ArrowUp) return GUI.ACTION.UP;
        if(keyStroke.getKeyType() == KeyType.ArrowRight) return GUI.ACTION.RIGHT;
        if(keyStroke.getKeyType() == KeyType.ArrowLeft) return GUI.ACTION.LEFT;
        if(keyStroke.getKeyType() == KeyType.Backspace) return GUI.ACTION.SPACE;

        if(keyStroke.getKeyType() == KeyType.Enter) return GUI.ACTION.SELECT;
        if(keyStroke.getKeyType() == KeyType.Escape) return GUI.ACTION.PAUSE;

        return GUI.ACTION.NONE;
    }

    @Override
    public void clear(){
        screen.clear();
    }
    @Override
    public void refresh() throws IOException{
        screen.refresh();
    }
    @Override
    public void close() throws IOException{
        screen.close();
    }
}
