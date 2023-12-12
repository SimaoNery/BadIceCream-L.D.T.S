package badIceCream.GUI;

import badIceCream.model.Position;
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
        String color = strawberry ? "#48DEFF" : "#FFFFFF";
        gui.drawCharacter(position.getX(), position.getY(), c , color);
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
            case 4: gui.drawCharacter(position.getX(), position.getY(), 'h', "#87CEFA");
            break;
            case 5: gui.drawCharacter(position.getX(), position.getY(), 'g', "#87CEFA");
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

    public void drawCherryFruit(Position position) {
        gui.drawCharacter(position.getX(), position.getY(), '\\', "#FF0000");
    }


    public void drawStrawberryFruit(Position position) {
        gui.drawCharacter(position.getX(), position.getY(), '_', "#FF0000");
    }


    public void drawHotFloor(Position position, int type) {
        switch (type) {
            case 1: gui.drawCharacter(position.getX(), position.getY(), 'w', "#e14750");
                break;
            case 2: gui.drawCharacter(position.getX(), position.getY(), 'd', "#e14750");
                break;
            case 3: gui.drawCharacter(position.getX(), position.getY(), 'c', "#e14750");
                break;
            case 4: gui.drawCharacter(position.getX(), position.getY(), 'x', "#e14750");
                break;
            case 5: gui.drawCharacter(position.getX(), position.getY(), '%', "#e14750");
                break;
            case 6: gui.drawCharacter(position.getX(), position.getY(), '(', "#e14750");
                break;
            case 7: gui.drawCharacter(position.getX(), position.getY(), '\'', "#e14750");
                break;
            case 8: gui.drawCharacter(position.getX(), position.getY(), '&', "#e14750");
                break;
            case 9: gui.drawCharacter(position.getX(), position.getY(), ')', "#e14750");
                break;
            case 10: gui.drawCharacter(position.getX(), position.getY(), '+', "#e14750");
                break;
            case 11: gui.drawCharacter(position.getX(), position.getY(), ',', "#e14750");
                break;
            case 12: gui.drawCharacter(position.getX(), position.getY(), '*', "#e14750");
                break;
            case 13: gui.drawCharacter(position.getX(), position.getY(), '-', "#e14750");
                break;
            case 14: gui.drawCharacter(position.getX(), position.getY(), '.', "#e14750");
                break;
            case 15: gui.drawCharacter(position.getX(), position.getY(), 'S', "#e14750");
                break;
            case 16: gui.drawCharacter(position.getX(), position.getY(), 'R', "#e14750");
                break;
            case 17: gui.drawCharacter(position.getX(), position.getY(), '!', "#e14750");
                break;
            case 18: gui.drawCharacter(position.getX(), position.getY(), '#', "#e14750");
                break;
            case 19: gui.drawCharacter(position.getX(), position.getY(), '"', "#e14750");
                break;
            case 20: gui.drawCharacter(position.getX(), position.getY(), '$', "#e14750");
                break;
            case 21: gui.drawCharacter(position.getX(), position.getY(), 'C', "#e14750");
                break;
            case 22: gui.drawCharacter(position.getX(), position.getY(), '@', "#e14750");
                break;
            case 23: gui.drawCharacter(position.getX(), position.getY(), 'D', "#e14750");
                break;
            case 24: gui.drawCharacter(position.getX(), position.getY(), 'B', "#e14750");
                break;
            case 25: gui.drawCharacter(position.getX(), position.getY(), 'A', "#e14750");
                break;
            case 26: gui.drawCharacter(position.getX(), position.getY(), ';', "#e14750");
                break;
            case 27: gui.drawCharacter(position.getX(), position.getY(), '=', "#e14750");
                break;
            case 28: gui.drawCharacter(position.getX(), position.getY(), '>', "#e14750");
                break;
            case 29: gui.drawCharacter(position.getX(), position.getY(), '<', "#e14750");
                break;
            default: gui.drawCharacter(position.getX(), position.getY(), 'b', "#e14750");
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

    public void drawCharacters() {
        gui.drawCharacter(33, 15, 'Ê', "#00FF00");
        gui.drawCharacter(33, 18, 'À', "#00FF00");
        gui.drawCharacter(33, 21, 'Á', "#00FF00");
        gui.drawCharacter(33, 24, 'È', "#00FF00");
        gui.drawCharacter(33, 27, 'É', "#00FF00");
        gui.drawCharacter(33, 30, 'Í', "#00FF00");
    }
}
