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


public class Graphics implements Cloneable {
    private GUI gui;

    public Graphics(GUI gui) throws IOException {
        this.gui = gui;
    }

    public void setGui(GUI gui) {
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

    public void drawIceCream(Position position, GUI.ACTION action, boolean strawberry) {
        char c;
        switch (action) {
            case UP: {c = '5'; break;}
            case LEFT: {c = '['; break;}
            case RIGHT: {c = '6'; break;}
            default: c = 'Z';

        }
        gui.drawCharacter(position.getX(), position.getY(), c , "#FFFFFF");
    }
    public void drawStoneWall(Position position) {
        gui.drawCharacter(position.getX(), position.getY(), 'G', "#696969");
    }
    public void drawIceWall(Position position){
        gui.drawCharacter(position.getX(), position.getY(), 'F', "#87CEFA");
    }

    public void drawDefaultMonster(Position position, GUI.ACTION action){
        char c;
        switch (action) {
            case UP: { c = '4'; break;}
            case LEFT: {c = '~'; break;}
            case RIGHT: {c = 'È'; break;}
            default: c = 'Y';

        }
        gui.drawCharacter(position.getX(), position.getY(), c, "#00FF00");
    }

    public void drawJumperMonster(Position position, GUI.ACTION action) {
        char c;
        switch (action) {
            case UP: { c = '/'; break;}
            case LEFT: {c = 'y'; break;}
            case RIGHT: {c = 'è'; break;}
            default: c = 'T';

        }
        gui.drawCharacter(position.getX(), position.getY(), c, "#FF3333");
    }

    public void drawRunnerMonster(Position position, GUI.ACTION action, boolean runner) {
        char c;
        switch (action) {
            case UP: { c = runner ? '3' : '1'; break;}
            case LEFT: {c = runner ? 'X' : 'W'; break;}
            case RIGHT: {c = runner ? '}' : '2'; break;}
            default: c = runner ? '|' : 'V';

        }
        String color = runner ? "#FF0000" : "#FFFF66";
        gui.drawCharacter(position.getX(), position.getY(), c, color);
    }

    public void drawWallBreakerMonster(Position position, GUI.ACTION action) {
        char c;
        switch (action) {
            case UP: { c = '0'; break;}
            case LEFT: {c = 'é'; break;}
            case RIGHT: {c = 'z'; break;}
            default: c = 'U';

        }
        gui.drawCharacter(position.getX(), position.getY(), c, "#FF99FF");
    }


    public void drawAppleFruit(Position position) {
        gui.drawCharacter(position.getX(), position.getY(), 'L', "#FF0000");
    }


    public void drawBananaFruit(Position position) {
        gui.drawCharacter(position.getX(), position.getY(), 'M', "#FFFF00");
    }


    public void drawPineappleFruit(Position position) {
        gui.drawCharacter(position.getX(), position.getY(), 'O', "#FFFF66");
    }


    public void drawPepperFruit(Position position) {
        gui.drawCharacter(position.getX(), position.getY(), 'K', "#FF0000");
    }


    public void drawStrawberryFruit(Position position) {
        gui.drawCharacter(position.getX(), position.getY(), 'Q', "#FF0000");
    }


    public void drawHotFloor(Position position) {
        gui.drawCharacter(position.getX(), position.getY(), 'E', "#FF0000");
    }


    public void drawText(Position position, String text, String color){
        gui.drawText(position, text, color);
    }


    @Override
    public Graphics clone() {
        try {
            return (Graphics) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
