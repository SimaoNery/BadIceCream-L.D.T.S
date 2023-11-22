package org.example.GUI;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import org.example.model.Position;

import javax.swing.*;
import java.io.IOException;
import java.security.Key;


public class Graphics implements GUI{
    private final Screen screen;
    private Terminal createTerminal(int width, int height) throws IOException {
        TerminalSize terminalSize = new TerminalSize(width, height);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        Terminal terminal = terminalFactory.createTerminal();
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
    public Graphics(int width, int height) throws IOException {
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
    public void drawHero(Position position){
        drawCharacter(position.getX(), position.getY(), 'I', "#FFFFFF");
    }
    @Override
    public void drawStoneWall(Position position){
        drawCharacter(position.getX(), position.getY(), '#', "#696969");
    }
    @Override
    public void drawIceWall(Position position){
        drawCharacter(position.getX(), position.getY(), '+', "#87CEFA");
    }
    @Override
    public void drawDefaultMonster(Position position){
        drawCharacter(position.getX(), position.getY(), 'D', "#00FF00");
    }
    @Override
    public void drawJumperMonster(Position position){
        drawCharacter(position.getX(), position.getY(), 'J', "#FF3333");
    }
    @Override
    public void drawRunnerMonster(Position position){
        drawCharacter(position.getX(), position.getY(), 'R', "#FFFF66");
    }
    @Override
    public void drawWallBreakerMonster(Position position){
        drawCharacter(position.getX(), position.getY(), 'W', "#FF99FF");
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
