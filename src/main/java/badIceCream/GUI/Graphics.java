package badIceCream.GUI;

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


public class Graphics implements GUI {
    private final Screen screen;

    private Terminal createTerminal(int width, int height) throws IOException, FontFormatException {
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File("/home/simaonery/Desktop/2Ano/L.D.T.S/Project/project-l10gr08/src/main/resources/FontForge/Untitled1.otf"));
            font = font.deriveFont(Font.PLAIN, 35);
            AWTTerminalFontConfiguration cfg = new SwingTerminalFontConfiguration(true, AWTTerminalFontConfiguration.BoldMode.NOTHING, font);
            Terminal terminal = new DefaultTerminalFactory().setInitialTerminalSize(new TerminalSize(width, height)).setTerminalEmulatorFontConfiguration(cfg).createTerminal();

            return terminal;
    }

    private Screen createScreen(Terminal terminal) throws IOException{
        final Screen screen;
        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        return screen;
    }
    private void drawCharacter(int a, int b, char c, String color) {
        TextGraphics textGraphics = screen.newTextGraphics();
        textGraphics.setForegroundColor(TextColor.Factory.fromString(color));
        textGraphics.putString(a, b, "" + c);
    }


    public Graphics(Screen screen){
        this.screen = screen;
    }
    public Graphics(int width, int height) throws IOException, FontFormatException {
        Terminal terminal = createTerminal(width, height);
        this.screen = createScreen(terminal);
    }

    public ACTION getNextAction() throws IOException{
        KeyStroke keyStroke = screen.pollInput();
        if(keyStroke == null) return ACTION.NONE;

        if(keyStroke.getKeyType() == KeyType.ArrowDown) return ACTION.DOWN;
        if(keyStroke.getKeyType() == KeyType.ArrowUp) return ACTION.UP;
        if(keyStroke.getKeyType() == KeyType.ArrowRight) return ACTION.RIGHT;
        if(keyStroke.getKeyType() == KeyType.ArrowLeft) return ACTION.LEFT;
        if(keyStroke.getKeyType() == KeyType.Backspace) return ACTION.SPACE;

        if(keyStroke.getKeyType() == KeyType.Enter) return ACTION.SELECT;
        if(keyStroke.getKeyType() == KeyType.Escape) return ACTION.PAUSE;

        return ACTION.NONE;
    }

    @Override
    public void drawText(Position position, String text, String color){
        TextGraphics textGraphics = screen.newTextGraphics();
        textGraphics.setForegroundColor(TextColor.Factory.fromString(color));
        textGraphics.putString(position.getX(), position.getY(), text);
    }
    @Override
    public void drawIceCream(Position position){
        drawCharacter(position.getX(), position.getY(), 'Z', "#FFFFFF");
    }
    @Override
    public void drawStoneWall(Position position){
        drawCharacter(position.getX(), position.getY(), 'G', "#696969");
    }
    @Override
    public void drawIceWall(Position position){
        drawCharacter(position.getX(), position.getY(), 'F', "#87CEFA");
    }
    @Override
    public void drawDefaultMonster(Position position){
        drawCharacter(position.getX(), position.getY(), 'Y', "#00FF00");
    }
    @Override
    public void drawJumperMonster(Position position){
        drawCharacter(position.getX(), position.getY(), 'T', "#FF3333");
    }
    @Override
    public void drawRunnerMonster(Position position){
        drawCharacter(position.getX(), position.getY(), 'X', "#FFFF66");
    }
    @Override
    public void drawWallBreakerMonster(Position position){
        drawCharacter(position.getX(), position.getY(), 'U', "#FF99FF");
    }

    @Override
    public void drawAppleFruit(Position position) {
        drawCharacter(position.getX(), position.getY(), 'L', "#FF0000");
    }

    @Override
    public void drawBananaFruit(Position position) {
        drawCharacter(position.getX(), position.getY(), 'M', "#FFFF00");
    }

    @Override
    public void drawPineappleFruit(Position position) {
        drawCharacter(position.getX(), position.getY(), 'O', "#FFFF66");
    }

    @Override
    public void drawPepperFruit(Position position) {
        drawCharacter(position.getX(), position.getY(), 'K', "#FF0000");
    }

    @Override
    public void drawStrawberryFruit(Position position) {
        drawCharacter(position.getX(), position.getY(), 'Q', "#FF0000");
    }

    @Override
    public void drawHotFloor(Position position) {
        drawCharacter(position.getX(), position.getY(), 'E', "#FF0000");
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
