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
            case UP: {c = '7'; break;}
            case LEFT: {c = ':'; break;}
            case RIGHT: {c = '9'; break;}
            default: c = '8';

        }
        gui.drawCharacter(position.getX(), position.getY(), c , "#FFFFFF");
    }
    public void drawStoneWall(Position position) {
        gui.drawCharacter(position.getX(), position.getY(), 'G', "#696969");
    }
    public void drawIceWall(Position position, int type){
        switch (type) {
            case 1: gui.drawCharacter(position.getX(), position.getY(), 'F', "#87CEFA");
            break;
            case 3: gui.drawCharacter(position.getX(), position.getY(), 'f', "#87CEFA");
            break;
            case 4: gui.drawCharacter(position.getX(), position.getY(), 'g', "#87CEFA");
            break;
            case 5: gui.drawCharacter(position.getX(), position.getY(), 'h', "#87CEFA");
            break;
            case 6: gui.drawCharacter(position.getX(), position.getY(), 'i', "#87CEFA");
            break;
            case 7: gui.drawCharacter(position.getX(), position.getY(), 'e', "#87CEFA");
            break;
            case 8: gui.drawCharacter(position.getX(), position.getY(), 'k', "#87CEFA");
            break;
            case 9: gui.drawCharacter(position.getX(), position.getY(), 'l', "#87CEFA");
            break;
            case 10: gui.drawCharacter(position.getX(), position.getY(), 'm', "#87CEFA");
            break;
            case 11: gui.drawCharacter(position.getX(), position.getY(), 'n', "#87CEFA");
            break;
        }
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
        gui.drawCharacter(position.getX(), position.getY(), ']', "#FF0000");
    }


    public void drawBananaFruit(Position position) {
        gui.drawCharacter(position.getX(), position.getY(), 'a', "#FFFF00");
    }


    public void drawPineappleFruit(Position position) {
        gui.drawCharacter(position.getX(), position.getY(), '^', "#FFFF66");

    }


    public void drawPepperFruit(Position position) {
        gui.drawCharacter(position.getX(), position.getY(), '\\', "#FF0000");
    }


    public void drawStrawberryFruit(Position position) {
        gui.drawCharacter(position.getX(), position.getY(), '_', "#FF0000");
    }


    public void drawHotFloor(Position position, int type) {
        switch (type) {
            case 1: gui.drawCharacter(position.getX(), position.getY(), 'w', "#FF0000");
                break;
            case 2: gui.drawCharacter(position.getX(), position.getY(), 'd', "#FF0000");
                break;
            case 3: gui.drawCharacter(position.getX(), position.getY(), 'c', "#FF0000");
                break;
            case 4: gui.drawCharacter(position.getX(), position.getY(), 'x', "#FF0000");
                break;
            case 5: gui.drawCharacter(position.getX(), position.getY(), '%', "#FF0000");
                break;
            case 6: gui.drawCharacter(position.getX(), position.getY(), '(', "#FF0000");
                break;
            case 7: gui.drawCharacter(position.getX(), position.getY(), '\'', "#FF0000");
                break;
            case 8: gui.drawCharacter(position.getX(), position.getY(), '&', "#FF0000");
                break;
            case 9: gui.drawCharacter(position.getX(), position.getY(), ')', "#FF0000");
                break;
            case 10: gui.drawCharacter(position.getX(), position.getY(), '+', "#FF0000");
                break;
            case 11: gui.drawCharacter(position.getX(), position.getY(), ',', "#FF0000");
                break;
            case 12: gui.drawCharacter(position.getX(), position.getY(), '*', "#FF0000");
                break;
            case 13: gui.drawCharacter(position.getX(), position.getY(), '-', "#FF0000");
                break;
            case 14: gui.drawCharacter(position.getX(), position.getY(), '.', "#FF0000");
                break;
            case 15: gui.drawCharacter(position.getX(), position.getY(), 'S', "#FF0000");
                break;
            case 16: gui.drawCharacter(position.getX(), position.getY(), 'R', "#FF0000");
                break;
            case 17: gui.drawCharacter(position.getX(), position.getY(), '!', "#FF0000");
                break;
            case 18: gui.drawCharacter(position.getX(), position.getY(), '#', "#FF0000");
                break;
            case 19: gui.drawCharacter(position.getX(), position.getY(), '"', "#FF0000");
                break;
            case 20: gui.drawCharacter(position.getX(), position.getY(), '$', "#FF0000");
                break;
            case 21: gui.drawCharacter(position.getX(), position.getY(), 'C', "#FF0000");
                break;
            case 22: gui.drawCharacter(position.getX(), position.getY(), '@', "#FF0000");
                break;
            case 23: gui.drawCharacter(position.getX(), position.getY(), 'D', "#FF0000");
                break;
            case 24: gui.drawCharacter(position.getX(), position.getY(), 'B', "#FF0000");
                break;
            case 25: gui.drawCharacter(position.getX(), position.getY(), 'A', "#FF0000");
                break;
            default: gui.drawCharacter(position.getX(), position.getY(), 'b', "#FF0000");
        }
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
